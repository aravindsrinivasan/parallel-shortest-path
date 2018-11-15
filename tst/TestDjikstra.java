import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestDjikstra {

    @Test
    public void test1() {
        double inf = Double.POSITIVE_INFINITY;
        double[][] edges = {
                {inf,5,inf,10},
                {inf,inf,3,inf},
                {inf,inf,inf,1},
                {1,inf,2,inf}
                };

        Djikstra d = new Djikstra(edges, 0);
        double[] result = d.solve();
        double[] expected = {0, 5, 8, 9};
        assertArrayEquals(expected, result, 0.01);
    }

}