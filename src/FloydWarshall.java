public class FloydWarshall {

    double[][] dist;
    int V;

    public FloydWarshall(double[][] matrix){
        V = matrix.length;
        dist = new double[V][V];
        for(int i = 0; i < V; i++)
            for(int j = 0; j < V; j++)
                dist[i][j] = matrix[i][j];
    }

    public double[][] solve(){
        for (int k = 0; k < V; k++){
            // Pick all vertices as source one by one
            for (int i = 0; i < V; i++){
                // Pick all vertices as destination for the
                // above picked source
                for (int j = 0; j < V; j++){
                    // If vertex k is on the shortest path from
                    // i to j, then update the value of dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        return dist;
    }
}
