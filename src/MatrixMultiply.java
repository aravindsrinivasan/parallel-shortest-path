import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class MatrixMultiply {

    double[][] A;
    double[][] B;
    double[][] C;
    int n;

    private final static int NUMCORES = 32767;
    private static final int POOL_SIZE = 16,
            MINIMUM_THRESHOLD = 64;

    private final ExecutorService exec = Executors.newFixedThreadPool(POOL_SIZE);

    public MatrixMultiply(double[][] A, double[][] B) {
        this.A = A;
        this.B = B;
        this.n = A.length;
        C = new double[n][n];
    }

    public double[][] solve() {
        Future f = exec.submit(new MultiplyTask(A, B, C, 0, 0, 0, 0, 0, 0, n));
        try {
            f.get();
            exec.shutdown();
            return C;
        } catch (Exception e) {
        }
        return null;
    }

    public double[][] getResult() {
        return C;
    }

    class MultiplyTask implements Runnable {

        private double[][] a;
        private double[][] b;
        private double[][] c;
        private int a_i, a_j, b_i, b_j, c_i, c_j, size;

        MultiplyTask(double[][] a, double[][] b, double[][] c, int a_i, int a_j, int b_i, int b_j, int c_i, int c_j, int size) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.a_i = a_i;
            this.a_j = a_j;
            this.b_i = b_i;
            this.b_j = b_j;
            this.c_i = c_i;
            this.c_j = c_j;
            this.size = size;
        }

        @Override
        public void run() {
            int h = size/2;
            if (size <= MINIMUM_THRESHOLD) {
                for (int i = 0; i < size; ++i) {
                    for (int j = 0; j < size; ++j) {
                        for (int k = 0; k < size; ++k) {
                            c[c_i+i][c_j+j] += a[a_i+i][a_j+k] * b[b_i+k][b_j+j];
                        }
                    }
                }
            } else {
                MultiplyTask[] tasks = {
                        new MultiplyTask(a, b, c, a_i, a_j, b_i, b_j, c_i, c_j, h),
                        new MultiplyTask(a, b, c, a_i, a_j+h, b_i+h, b_j, c_i, c_j, h),

                        new MultiplyTask(a, b, c, a_i, a_j, b_i, b_j+h, c_i, c_j+h, h),
                        new MultiplyTask(a, b, c, a_i, a_j+h, b_i+h, b_j+h, c_i, c_j+h, h),

                        new MultiplyTask(a, b, c, a_i+h, a_j, b_i, b_j, c_i+h, c_j, h),
                        new MultiplyTask(a, b, c, a_i+h, a_j+h, b_i+h, b_j, c_i+h, c_j, h),

                        new MultiplyTask(a, b, c, a_i+h, a_j, b_i, b_j+h, c_i+h, c_j+h, h),
                        new MultiplyTask(a, b, c, a_i+h, a_j+h, b_i+h, b_j+h, c_i+h, c_j+h, h)
                };

                FutureTask[] fs = new FutureTask[tasks.length/2];

                for (int i = 0; i < tasks.length; i+=2) {
                    fs[i/2] = new FutureTask(new Sequentializer(tasks[i], tasks[i+1]), null);
                    exec.execute(fs[i/2]);
                }
                for (int i = 0; i < fs.length; ++i) {
                    fs[i].run();
                }
                try {
                    for (int i = 0; i < fs.length; ++i) {
                        fs[i].get();
                    }
                } catch (Exception e) {

                }
            }
        }
    }

    class Sequentializer implements Runnable{
        private MultiplyTask first, second;
        Sequentializer(MultiplyTask first, MultiplyTask second) {
            this.first = first;
            this.second = second;
        }
        public void run() {
            first.run();
            second.run();
        }
    }

}
