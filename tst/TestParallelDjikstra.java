import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestParallelDjikstra {

    @Test
    public void TestBasic(){
        int e = Integer.MAX_VALUE/2 - 10000;
        double[][] edges = {
                {e,5,e,10},
                {e,e,3,e},
                {e,e,e,1},
                {1,e,2,e}
        };
        double[] expected = {0, 5, 8, 9};

        ParallelDjikstra d = new ParallelDjikstra(edges, 0);
        double[] result = d.solve();
        assertArrayEquals(expected, result, 0.0000001);

    }
}