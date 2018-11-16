import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestParallelAllPairsDjikstra {

    @Test
    public void test4x4() {

        double inf = Double.POSITIVE_INFINITY;
        double[][] graph = Parser.parse("tst/matrix_4x4.txt");
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0.0) graph[i][j] = inf;
            }
        }

        ParallelAllPairsDjikstra d = new ParallelAllPairsDjikstra(graph, graph.length);
        double[][] result = d.solve();
        FloydWarshall d1 = new FloydWarshall(graph);
        double[][] expected = d1.solve();
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                if(i != j) assertEquals(result[i][j], expected[i][j], 0.0001);
            }
        }
    }

    @Test
    public void test16x16() {

        double inf = Double.POSITIVE_INFINITY;
        double[][] graph = Parser.parse("tst/matrix_16x16.txt");
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0.0) graph[i][j] = inf;
            }
        }

        ParallelAllPairsDjikstra d = new ParallelAllPairsDjikstra(graph, graph.length);
        double[][] result = d.solve();
        FloydWarshall d1 = new FloydWarshall(graph);
        double[][] expected = d1.solve();
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                if(i != j) assertEquals(result[i][j], expected[i][j], 0.0001);
            }
        }
    }

    @Test
    public void test32x32() {

        double inf = Double.POSITIVE_INFINITY;
        double[][] graph = Parser.parse("tst/matrix_32x32.txt");
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0.0) graph[i][j] = inf;
            }
        }

        ParallelAllPairsDjikstra d = new ParallelAllPairsDjikstra(graph, graph.length);
        double[][] result = d.solve();
        FloydWarshall d1 = new FloydWarshall(graph);
        double[][] expected = d1.solve();
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                if(i != j) assertEquals(result[i][j], expected[i][j], 0.0001);
            }
        }
    }

    @Test
    public void test64x64() {

        double inf = Double.POSITIVE_INFINITY;
        double[][] graph = Parser.parse("tst/matrix_64x64.txt");
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0.0) graph[i][j] = inf;
            }
        }

        ParallelAllPairsDjikstra d = new ParallelAllPairsDjikstra(graph, graph.length);
        double[][] result = d.solve();
        FloydWarshall d1 = new FloydWarshall(graph);
        double[][] expected = d1.solve();
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                if(i != j) assertEquals(result[i][j], expected[i][j], 0.0001);
            }
        }
    }

    @Test
    public void test256x256() {

        double inf = Double.POSITIVE_INFINITY;
        double[][] graph = Parser.parse("tst/matrix_256x256.txt");
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0.0) graph[i][j] = inf;
            }
        }

        ParallelAllPairsDjikstra d = new ParallelAllPairsDjikstra(graph, graph.length);
        double[][] result = d.solve();
        FloydWarshall d1 = new FloydWarshall(graph);
        double[][] expected = d1.solve();
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                if(i != j) assertEquals(result[i][j], expected[i][j], 0.0001);
            }
        }
    }

    @Test
    public void test512x512() {

        double inf = Double.POSITIVE_INFINITY;
        double[][] graph = Parser.parse("tst/matrix_512x512.txt");
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0.0) graph[i][j] = inf;
            }
        }

        ParallelAllPairsDjikstra d = new ParallelAllPairsDjikstra(graph, graph.length);
        double[][] result = d.solve();
        FloydWarshall d1 = new FloydWarshall(graph);
        double[][] expected = d1.solve();
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                if(i != j) assertEquals(result[i][j], expected[i][j], 0.0001);
            }
        }
    }
}