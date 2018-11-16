import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestDjikstra {

    @Test
    public void test4x4() {

        double inf = Double.POSITIVE_INFINITY;
        double[][] graph = Parser.parse("tst/matrix_4x4.txt");
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0.0) graph[i][j] = inf;
            }
        }

        Djikstra d = new Djikstra(graph, 0);
        double[] result = d.solve();
        double[] expected = {0, 6, 1, 3};
        assertArrayEquals(expected, result, 0.01);
    }

}