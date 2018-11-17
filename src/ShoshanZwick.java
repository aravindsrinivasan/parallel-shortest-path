import java.util.Arrays;
import java.util.stream.IntStream;

public class ShoshanZwick {

    double[][] edges;
    int M;
    int numNodes;
    int l;
    int m;
    double[][] D;
    double[][] P;
    double[][] A;

    public ShoshanZwick(double[][] d, int M) {
        this.edges = d;
        this.M = M;
        this.numNodes = d.length;
        this.l = (int) (Math.log(numNodes)/Math.log(2));
        this.m = (int) (Math.log(M)/Math.log(2));
    }

    public double[][] solve() {
        D = edges;
        for(int i = 1; i <= m+1; i++) {
            D = clip(min(D, D), 0, 2*M);
        }
        A = new double[numNodes][numNodes];
        IntStream.range(0, numNodes).parallel().forEach(i -> {
                    IntStream.range(0, numNodes).parallel().forEach(j -> {
                        A[i][j] = D[i][j] - M;
                    });
                }
        );
        for(int i = 1; i <= l; i++) {
            A = clip(min(A,A), -1*M, M);
        }
        double[][] C = new double[numNodes][numNodes];
        for(double[] a : C) {
            Arrays.fill(a, -1*M);
        }
        P = clip(D, 0, M);
        double[][] Q = new double[numNodes][numNodes];
        for(double[] a : Q) {
            Arrays.fill(a, Double.POSITIVE_INFINITY);
        }
        double[][][] allC = new double[l+1][][];
        allC[l] = deepCopy(C);
        for(int i = l-1; i >= 0; i--) {
            double[][] temp1 = one(clip(min(P, A), -1*M, M), C);
            double[][] temp2 = two(clip(min(Q, A), -1*M, M), C);
            C = three(temp1, temp2);
            allC[i] = deepCopy(C);
            P = three(P, Q);
            Q = chop(C, 1 - M, M);
        }
        double[][][] B = new double[l+1][][];
        for(int i = 1; i <= l; i++) {
            B[i] = boolean1(allC[i]);
        }
        B[0] = boolean2(P);
        double[][] R = new double[numNodes][numNodes];
        IntStream.range(0, numNodes).parallel().forEach(i -> {
            IntStream.range(0, numNodes).parallel().forEach(j -> {
                R[i][j] = P[i][j] % M;
            });
        });

        double[][] result = new double[numNodes][numNodes];
        IntStream.range(0, l+1).forEach(i -> {
            IntStream.range(0, numNodes).parallel().forEach(j -> {
                IntStream.range(0, numNodes).parallel().forEach(k -> {
                    result[j][k] = Math.pow(2, i)*B[i][j][k];
                });
            });
        });

        IntStream.range(0, numNodes).parallel().forEach(i -> {
            IntStream.range(0, numNodes).parallel().forEach(j -> {
                result[i][j] = M*result[i][j] + R[i][j];
            });
        });
        return result;

    }

    private double[][] deepCopy(double[][] C) {
        double[][] result = new double[C.length][];
        for(int i = 0; i < C.length; i++) {
            result[i] = Arrays.copyOf(C[i], C[i].length);
        }
        return result;
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
        double[][] result = new double[numNodes][numNodes];
        IntStream.range(0, numNodes).parallel()
                .forEach(i -> {
                    IntStream.range(0, numNodes).parallel()
                            .forEach(j -> {
                                if(A[i][j] != Double.POSITIVE_INFINITY) result[i][j] = A[i][j];
                                else if(B[i][j] != Double.POSITIVE_INFINITY) result[i][j] = B[i][j];
                                else result[i][j] = Double.POSITIVE_INFINITY;

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

    private double[][] min(double[][] A, double[][] B){
        double[][] result = new double[numNodes][numNodes];
        IntStream.range(0, numNodes).parallel()
                .forEach(i -> {
                    IntStream.range(0, numNodes).parallel()
                    .forEach(j -> {
                       double min = Double.MAX_VALUE;
                       for(int k = 0; k < numNodes; k++){
                           min = Math.min(min, A[i][k] + B[k][j]);
                       }
                       result[i][j] = min;
                    });
                });
        return result;
    }

}
