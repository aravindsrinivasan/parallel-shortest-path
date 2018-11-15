import org.junit.Test;
import src.Djikstra;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DjikstraTest {

    @Test
    public void test1() {
        int e = Integer.MAX_VALUE;
        int[][] edges = {
                {e,5,e,10},
                {e,e,3,e},
                {e,e,e,1},
                {1,e,2,e}
                };

        Djikstra d = new Djikstra(edges, 0);
        int[] result = d.run();
        int[] expected = {0, 5, 8, 9};
        assertArrayEquals(expected, result);
    }

}