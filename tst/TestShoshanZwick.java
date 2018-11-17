import org.junit.Test;

import java.util.Arrays;

public class TestShoshanZwick {

    @Test
    public void testBasic() {
        double inf = Double.POSITIVE_INFINITY;
        double[][] d = {
                {0, inf, 1, 3},
                {1, 0, 4, 1},
                {inf, 4, 0, inf},
                {2, 8, 5, 0}
        };
        ParallelAllPairsDjikstra djikstra = new ParallelAllPairsDjikstra(d, 4);
        System.out.println(Arrays.deepToString(djikstra.solve()));
        ShoshanZwick sz = new ShoshanZwick(d, 8);
        System.out.println(Arrays.deepToString(sz.solve()));

    }

}
