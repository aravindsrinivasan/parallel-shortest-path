package src;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class ParallelDjikstra {
    private int[][] dist;
    private int source;
    private int numNodes;

    private Node[] nodes;

    private final static int NUMCORES = 32767;

    public ParallelDjikstra(int[][] matrix, int s){
        this.source = s;
        this.dist = matrix;
        this.numNodes = matrix.length;
        nodes = new Node[numNodes];
        for(int i = 0; i < numNodes; i++) {
            nodes[i] = new Node(i, Integer.MAX_VALUE);
        }
        for(int i = 0; i < numNodes; i++) {
            for(int j = 0 ; j < numNodes; j++) {
                if(matrix[i][j] > 0) {
                    nodes[i].connections.add(nodes[j]);
                }
            }
        }
        nodes[source].distance = 0;
    }

    public int[] run() {
        Set<Node> nodeSet = new HashSet<>(Arrays.asList(nodes));
        Set<Node> visited = new HashSet<>();
        ForkJoinPool pool = new ForkJoinPool(NUMCORES);
        while(!nodeSet.isEmpty()){
            Optional<Node> current = Optional.empty();
            try {
                current = pool
                        .submit(()-> nodeSet
                                .parallelStream()
                                .min(Comparator.comparing(n->n.distance)))
                        .get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            if(!current.isPresent()){
                System.err.println("Parallel stream returned an invalid value");
                return new int[0];
            }
            Node node = current.get();
            nodeSet.remove(node);
            visited.add(node);
            for(Node c : node.connections) {
                if (!visited.contains(c)) {
                    int d = node.distance + dist[node.index][c.index];
                    if (c.distance > d) {
                        c.distance = d;
                        c.pred = node;
                    }
                }
            }

        }
        
        int[] result = new int[numNodes];
        for(int i = 0; i < numNodes; i++){
            result[i] = nodes[i].distance;
        }
        return result;
    }

    class Node {
        int index;
        int distance;
        Node pred;
        List<Node> connections;

        public Node(int i, int d) {
            this.index = i;
            this.distance = d;
            this.pred = null;
            connections = new ArrayList<Node>();
        }
    }
}
