import org.junit.Test;

import java.util.Arrays;

public class TestParallelAllPairsDjikstra {


    @Test
    public void test1() {
        int e = Integer.MAX_VALUE - 1000000;
        int[][] edges = {
                {e,5,e,10},
                {e,e,3,e},
                {e,e,e,1},
                {1,e,2,e}
        };

        ParallelAllPairsDjikstra d = new ParallelAllPairsDjikstra(edges, 4);
        int[][] result = d.run();
        int[][] expected = {
                {0, 5, 8, 9},
                {5, 0, 3, 4},
                {2, 7, 0, 1},
                {1, 6, 2, 0}
        };
        System.out.println(Arrays.deepToString(result));
        //assertArrayEquals(expected, result);
        FloydWarshall f = new FloydWarshall(edges);
        System.out.println(Arrays.deepToString(f.run()));
        //assertArrayEquals(expected, f.run());

    }

}