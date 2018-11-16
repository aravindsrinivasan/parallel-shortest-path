import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class TestSeidel {

    @Test
    public void testBasic() {
        double[][] edges = {
                {0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0}
        };

        double[][] expected = {
                {0.0, 1.0, 2.0, 2.0, 2.0, 1.0},
                {1.0, 0.0, 1.0, 1.0, 1.0, 2.0},
                {2.0, 1.0, 0.0, 1.0, 2.0, 3.0},
                {2.0, 1.0, 1.0, 0.0, 1.0, 2.0},
                {2.0, 1.0, 2.0, 1.0, 0.0, 1.0},
                {1.0, 2.0, 3.0, 2.0, 1.0, 0.0}
        };

        Seidel s = new Seidel(edges);
        double[][] result = s.solve();
        assertArrayEquals(expected, result);
    }

}

