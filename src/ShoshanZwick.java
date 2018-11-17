import java.util.stream.IntStream;

public class ShoshanZwick {

    double[][] edges;
    int M;
    int numNodes;
    int l;
    int m;

    public ShoshanZwick(double[][] d, int M) {
        this.edges = d;
        this.M = M;
        this.numNodes = d.length;
        this.l = (int) (Math.log(numNodes)/Math.log(2));
        this.m = (int) (Math.log(M)/Math.log(2));
    }

    public double[][] solve() {
        
        return null;

    }

    private double[][] clip(double[][] D, double a, double b) {
        return null;
    }

    private double[][] chop(double[][] D, double a, double b) {
        return null;
    }

    private double[][] one(double[][] A, double[][] B) {
        return null;
    }

    private double[][] two(double[][] A, double[][] B) {
        return null;
    }

    private double[][] three(double[][] A, double[][] B) {
        double[][] result = new double[numNodes][numNodes];
        IntStream.range(0, numNodes).parallel()
                .forEach(i -> {
                    IntStream.range(0, numNodes).parallel()
                            .forEach(j -> {
                                if(A[i][j] != Double.POSITIVE_INFINITY) result[i][j] = A[i][j];
                                else if(B[i][j] != Double.POSITIVE_INFINITY) result[i][j] = B[i][j];
                                else{
                                    result[i][j] = Double.POSITIVE_INFINITY;
                                }
                            });
                });
        return result;

    }

    private double[][] boolean1(double[][] C) {
        double[][] result = new double[numNodes][numNodes];
        IntStream.range(0, numNodes).parallel()
                .forEach(i -> {
                    IntStream.range(0, numNodes).parallel()
                            .forEach(j -> {
                                result[i][j] = C[i][j] >= 0 ? 1 : 0;
                            });
                });
        return result;
    }

    private double[][] boolean2(double[][] P) {
        double[][] result = new double[numNodes][numNodes];
        IntStream.range(0, numNodes).parallel()
                .forEach(i -> {
                    IntStream.range(0, numNodes).parallel()
                            .forEach(j -> {
                                result[i][j] = P[i][j] >= 0 && P[i][j] <= M ? 1 : 0;
                            });
                });
        return result;
    }

}
