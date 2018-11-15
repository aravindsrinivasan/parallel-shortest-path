import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestFloydWarshall {
    @Test
    public void test1(){
        int e = Integer.MAX_VALUE/2 - 1000;
        int[][] edges = {
                {0,5,e,10},
                {e,0,3,e},
                {e,e,0,1},
                {1,e,2,0}
        };
        int[][] expected = {
                {0, 5, 8, 9},
                {5, 0, 3, 4},
                {2, 7, 0, 1},
                {1, 6, 2, 0}
        };

        FloydWarshall f = new FloydWarshall(edges);
        int[][] result = f.run();
        assertArrayEquals(expected, result);
    }
}
