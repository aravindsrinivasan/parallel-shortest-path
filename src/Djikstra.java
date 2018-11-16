import java.util.*;

public class Djikstra {

    double[][] distances;
    int source;
    int numNodes;

    Node[] nodes;

    public Djikstra(double[][] d, int s) {
        this.distances = d;
        this.source = s;
        this.numNodes = d.length;
        nodes = new Node[numNodes];
        for(int i = 0; i < numNodes; i++) {
            nodes[i] = new Node(i, Double.POSITIVE_INFINITY);
        }
        for(int i = 0; i < numNodes; i++) {
            for(int j = 0 ; j < numNodes; j++) {
                if(d[i][j] != Double.POSITIVE_INFINITY) {
                    nodes[i].connections.add(nodes[j]);
                }
            }
        }
        nodes[source].distance = 0;
    }

    public double[] solve() {

        Set<Node> visited = new HashSet<Node>();
        TreeSet<Node> queue = new TreeSet<>(Comparator.comparingDouble(Node::getDistance).thenComparing(Node::getIndex));
        queue.addAll(Arrays.asList(nodes));

        while(!queue.isEmpty()) {
            Node next = queue.first();
            queue.remove(next);
            visited.add(next);
            for(Node c : next.connections) {
                if(!visited.contains(c)) {
                    double d = next.distance + distances[next.index][c.index];
                    if (c.distance > d) {
                        queue.remove(c);
                        c.distance = d;
                        c.pred = next;
                        queue.add(c);
                    }
                }
            }
        }
        
        double[] result = new double[numNodes];
        for(int i = 0; i < numNodes; i++) {
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

        public double getDistance(){
            return distance;
        }

        public int getIndex(){
            return index;
        }
    }

}
