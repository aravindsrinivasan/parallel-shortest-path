import java.util.*;

public class Djiktra {

    int[][] distances;
    int source;
    int numNodes;

    Node[] nodes;

    public Djiktra(int[][] d, int s) {
        this.distances = d;
        this.source = s;
        this.numNodes = d.length;
        nodes = new Node[numNodes];
        for(int i = 0; i < numNodes; i++) {
            nodes[i] = new Node(i, Integer.MAX_VALUE);
        }
        for(int i = 0; i < numNodes; i++) {
            for(int j = 0 ; j < numNodes; j++) {
                if(d[i][j] > 0) {
                    nodes[i].connections.add(nodes[j]);
                }
            }
        }
        nodes[source].distance = 0;
    }

    public int[] run(int[][] distances, int source) {

        Set<Node> visited = new HashSet<Node>();

        TreeSet<Node> queue = new TreeSet<Node>(new NodeComparator());
        queue.add(nodes[source]);

        while(!queue.isEmpty()) {
            Node next = queue.first();
            queue.remove(next);
            visited.add(next);
            for(Node c : next.connections) {
                if(!visited.contains(c)) {
                    int d = next.distance + distances[next.index][c.index];
                    if (c.distance > d) {
                        c.distance = d;
                        c.pred = next;
                        if(queue.contains(c)) {
                            queue.remove(c);
                        }
                        queue.add(c);
                    }
                }
            }
        }
        int[] result = new int[numNodes];
        for(int i = 0; i < numNodes; i++) {
            result[i] = nodes[i].distance;
        }

        return result;
    }

    class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.distance - o2.distance;
        }
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
