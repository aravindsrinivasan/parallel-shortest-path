import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class ParallelDjikstra {
    private double[][] dist;
    private int source;
    private int numNodes;

    private Node[] nodes;

    private final static int NUMCORES = 32767;

    public ParallelDjikstra(double[][] matrix, int source){
        this.source = source;
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

    public double[] solve() {
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
                return new double[0];
            }
            Node node = current.get();
            nodeSet.remove(node);
            visited.add(node);
            for(Node c : node.connections) {
                if (!visited.contains(c)) {
                    double d = node.distance + dist[node.index][c.index];
                    if (c.distance > d) {
                        c.distance = d;
                        c.pred = node;
                    }
                }
            }

        }
        
        double[] result = new double[numNodes];
        for(int i = 0; i < numNodes; i++){
            result[i] = nodes[i].distance;
        }
        return result;
    }

    class Node {
        int index;
        double distance;
        Node pred;
        List<Node> connections;

        public Node(int i, double d) {
            this.index = i;
            this.distance = d;
            this.pred = null;
            connections = new ArrayList<Node>();
        }
    }
}
