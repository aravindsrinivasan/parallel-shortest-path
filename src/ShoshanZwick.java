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
        double[][] result = new double[numNodes][numNodes];
        IntStream.range(0, numNodes).parallel().forEach(i -> {
            IntStream.range(0, numNodes).parallel().forEach(j -> {
                if(D[i][j] < a) {
                    result[i][j] = a;
                } else if(D[i][j] <= b) {
                    result[i][j] = D[i][j];
                } else {
                    result[i][j] = Double.POSITIVE_INFINITY;
                }
            });
        });
        return result;
    }

    private double[][] chop(double[][] D, double a, double b) {
        double[][] result = new double[numNodes][numNodes];
        IntStream.range(0, numNodes).parallel().forEach(i -> {
            IntStream.range(0, numNodes).parallel().forEach(j -> {
                result[i][j] = (a <= D[i][j] && D[i][j] <= b) ? D[i][j] : Double.POSITIVE_INFINITY;
            });
        });
        return result;
    }

    private double[][] one(double[][] A, double[][] B) {
        double[][] result = new double[numNodes][numNodes];
        IntStream.range(0, numNodes).parallel().forEach(i -> {
            IntStream.range(0, numNodes).parallel().forEach(j -> {
                result[i][j] = (B[i][j] < 0) ? A[i][j] : Double.POSITIVE_INFINITY;
            });
        });
        return result;
    }

    private double[][] two(double[][] A, double[][] B) {
        double[][] result = new double[numNodes][numNodes];
        IntStream.range(0, numNodes).parallel().forEach(i -> {
            IntStream.range(0, numNodes).parallel().forEach(j -> {
                result[i][j] = (B[i][j] >= 0) ? A[i][j] : Double.POSITIVE_INFINITY;
            });
        });
        return result;
    }

    private double[][] three(double[][] A, double[][] B) {
        return null;
    }

    private double[][] boolean1(double[][] C) {
        return null;
    }

    private double[][] boolean2(double[][] P) {
        return null;
    }

}
