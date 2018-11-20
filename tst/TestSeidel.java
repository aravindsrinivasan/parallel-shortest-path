import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class TestSeidel {

    @Test
    public void testCorrectness() {
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

    @Test
    public void testVaryingNodeTimes() {

        for(int nodes = 4; nodes <= 4096; nodes *=2) {
            if(nodes == 8) continue;
            double inf = Double.POSITIVE_INFINITY;
            double[][] graph = Parser.parse("tst/seidel_matrix_" + nodes + "x" + nodes + ".txt");
            for(int i = 0; i < graph.length; i++){
                for(int j = 0; j < graph[0].length; j++){
                    if(graph[i][j] == 0.0) graph[i][j] = inf;
                }
            }

            Seidel s = new Seidel(graph);
            long start = System.nanoTime();
            s.solve();
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("Time for " + nodes + " nodes: " + time);

        }

    }

}

