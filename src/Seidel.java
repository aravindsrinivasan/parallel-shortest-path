import java.util.Arrays;
import java.util.stream.IntStream;

public class Seidel {

    double[][] edges;
    int n;

    boolean flag;

    public Seidel(double[][] e) {
        this.edges = e;
        this.n = e.length;
    }

    public double[][] solve() {
        return APD(edges);
    }

    public double[][] APD(double[][] A) {
        MatrixMultiply m = new MatrixMultiply(A, A);
        double[][] Z = m.solve();
        double[][] B = new double[n][n];

        IntStream.range(0, n).parallel()
                .forEach(i -> {
                    IntStream.range(0,n).parallel()
                            .filter(j -> i != j && (A[i][j] == 1 || Z[i][j] > 0))
                            .forEach(j -> B[i][j] = 1);
                }
        );
        flag = true;
        IntStream.range(0, n).parallel()
                .forEach(i -> {
                    IntStream.range(0, n).parallel()
                            .forEach(j-> {
                                if(i != j && B[i][j] != 1) {
                                    flag = false;
                                }
                            });
                }
        );
        double[][] D = new double[n][n];;
        if(flag) {
            IntStream.range(0, n).parallel().forEach(
                    i -> {
                        IntStream.range(0, n).parallel()
                                .forEach(j -> {
                                    D[i][j] = 2.0*B[i][j] - A[i][j];
                                });
                    }
            );
            return D;
        } else {
            double[][] T = APD(B);
            MatrixMultiply m2 = new MatrixMultiply(A, T);
            double[][] X = m2.solve();
            IntStream.range(0, n).parallel()
                    .forEach(i -> {
                        double degree = IntStream.range(0, n).mapToDouble(j -> A[i][j]).sum();
                        IntStream.range(0, n).parallel()
                                .forEach(j -> {
                                    if(X[i][j] >= T[i][j]*degree) {
                                        D[i][j] = 2*T[i][j];
                                    } else {
                                        D[i][j] = 2*T[i][j] - 1;
                                    }
                                });
                    }
            );
            return D;
        }
    }


}
