import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class TestParallelDjikstra {

    @Test
    public void TestBasic(){
        int e = Integer.MAX_VALUE/2 - 10000;
        int[][] edges = {
                {e,5,e,10},
                {e,e,3,e},
                {e,e,e,1},
                {1,e,2,e}
        };
        int[] expected = {0, 5, 8, 9};

        ParallelDjikstra d = new ParallelDjikstra(edges, 0);
        int[] result = d.solve();
        Arrays.stream(result).forEach(System.out::println);
        assertArrayEquals(expected, result);
    }
}
