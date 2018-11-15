import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

public class TestParallelAllPairsDjikstra {


    @Test
    public void test1() {
        double inf = Double.POSITIVE_INFINITY;
        double[][] edges = {
                {0,5,inf,10},
                {inf,0,3,inf},
                {inf,inf,0,1},
                {1,inf,2,0}
        };

        ParallelAllPairsDjikstra d = new ParallelAllPairsDjikstra(edges, 4);
        double[][] result = d.solve();
        double[][] expected = {
                {0, 5, 8, 9},
                {5, 0, 3, 4},
                {2, 7, 0, 1},
                {1, 6, 2, 0}
        };
        assertTrue(Arrays.deepEquals(expected, result));
        //assertArrayEquals(expected, result, 0.01);
        //assertArrayEquals(expected, f.run());

    }

}