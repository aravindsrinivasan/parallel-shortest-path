import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class TestShoshanZwick {

    @Test
    public void testCorrectness() {
        double inf = Double.POSITIVE_INFINITY;
        double[][] d = {
                {0, inf, 1, 3},
                {1, 0, 4, 1},
                {inf, 4, 0, inf},
                {2, 8, 5, 0}
        };
        ParallelAllPairsDjikstra djikstra = new ParallelAllPairsDjikstra(d, 4);
        ShoshanZwick sz = new ShoshanZwick(d, 8);
        assertArrayEquals(djikstra.solve(), sz.solve());
    }

    @Test
    public void testVaryingTimes() {
        for(int nodes = 4; nodes <= 2048; nodes *= 2) {
            if(nodes == 8) continue;
            double inf = Double.POSITIVE_INFINITY;
            double[][] graph = Parser.parse("tst/sz_matrix_" + nodes + "x" + nodes + ".txt");
            for(int i = 0; i < graph.length; i++){
                for(int j = 0; j < graph[0].length; j++){
                    if(graph[i][j] == 0.0 && i != j) graph[i][j] = inf;
                }
            }
            ShoshanZwick sz = new ShoshanZwick(graph, 16);
            long start = System.nanoTime();
            sz.solve();
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("Time for " + nodes + " nodes: " + time);
        }
    }

}
