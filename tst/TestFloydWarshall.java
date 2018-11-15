import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class TestFloydWarshall {
    @Test
    public void test1(){
        double inf = Double.POSITIVE_INFINITY;
        double[][] edges = {
                {0,5,inf,10},
                {inf,0,3,inf},
                {inf,inf,0,1},
                {1,inf,2,0}
        };
        double[][] expected = {
                {0, 5, 8, 9},
                {5, 0, 3, 4},
                {2, 7, 0, 1},
                {1, 6, 2, 0}
        };

        FloydWarshall f = new FloydWarshall(edges);
        double[][] result = f.solve();
        System.out.println(Arrays.deepToString(result));
        assertArrayEquals(expected, result);
    }
}
