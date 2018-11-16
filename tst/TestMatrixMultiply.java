import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestMatrixMultiply {


    @Test
    public void testBasic() {
        int mSize = 1024;
        double[][] a = new double[mSize][mSize];
        double[][] b = new double[mSize][mSize];
        for (int i = 0; i < mSize; ++i) {
            for (int j = 0; j < mSize; ++j) {
                a[i][j] = Math.random() * 1000 - 500;
                b[i][j] = Math.random() * 1000 - 500;
            }
        }
        System.out.println("Parallel O(N^3) matrix multiplication start...");
        long start = System.currentTimeMillis();
        MatrixMultiply pmm = new MatrixMultiply(a, b);
        pmm.solve();
        long finish = System.currentTimeMillis();
        System.out.println("finished.");
        System.out.format("Time elapsed: %d ms\n", finish-start);
        double[][] res = pmm.getResult();

        double[][] check = new double[mSize][mSize];

        System.out.println("Serial O(N^3) matrix multiplication start...");
        start = System.currentTimeMillis();
        for (int i = 0; i < mSize; ++i) {
            for (int j = 0; j < mSize; ++j) {
                for (int k = 0; k < mSize; ++k) {
                    check[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        finish = System.currentTimeMillis();
        System.out.println("finished.");
        System.out.format("Time elapsed: %d ms\n", finish-start);

        System.out.println("Validating results...");
        for (int i = 0; i < mSize; ++i) {
            for (int j = 0; j < mSize; ++j) {
                assertEquals(check[i][j], res[i][j]);
            }
        }
    }


}
