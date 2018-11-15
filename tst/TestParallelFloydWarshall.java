import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

public class TestParallelFloydWarshall {

    @Test
    public void testCorrectness() {

        double inf = Double.POSITIVE_INFINITY;

        double[][] edges = {
                {0, 5.0, inf, 10.0},
                {inf, 0, 3.0, inf},
                {inf, inf, 0, 1},
                {1, inf, 2, 0}
        };

        ParallelFloydWarshall f = new ParallelFloydWarshall(edges, 4);
        f.solve();
        double[][] result = f.allShortestPathLengths();
        double[][] expected = {
                {0, 5, 8, 9},
                {5, 0, 3, 4},
                {2, 7, 0, 1},
                {1, 6, 2, 0}
        };
        assertTrue(Arrays.deepEquals(expected, result));
    }

}
