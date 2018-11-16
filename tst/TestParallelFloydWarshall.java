import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestParallelFloydWarshall {

    @Test
    public void test4x4() {

        double inf = Double.POSITIVE_INFINITY;
        double[][] graph = Parser.parse("tst/matrix_4x4.txt");
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0.0) graph[i][j] = inf;
            }
        }

        ParallelFloydWarshall d = new ParallelFloydWarshall(graph, graph.length);
        d.solve();
        double[][] result = d.allShortestPathLengths();
        FloydWarshall d1 = new FloydWarshall(graph);
        assertArrayEquals(result, d1.solve());
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

        ParallelFloydWarshall d = new ParallelFloydWarshall(graph, graph.length);
        d.solve();
        double[][] result = d.allShortestPathLengths();
        FloydWarshall d1 = new FloydWarshall(graph);
        assertArrayEquals(result, d1.solve());
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

        ParallelFloydWarshall d = new ParallelFloydWarshall(graph, graph.length);
        d.solve();
        double[][] result = d.allShortestPathLengths();
        FloydWarshall d1 = new FloydWarshall(graph);
        assertArrayEquals(result, d1.solve());
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

        ParallelFloydWarshall d = new ParallelFloydWarshall(graph, graph.length);
        d.solve();
        double[][] result = d.allShortestPathLengths();
        FloydWarshall d1 = new FloydWarshall(graph);
        assertArrayEquals(result, d1.solve());
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

        ParallelFloydWarshall d = new ParallelFloydWarshall(graph, graph.length);
        d.solve();
        double[][] result = d.allShortestPathLengths();
        FloydWarshall d1 = new FloydWarshall(graph);
        assertArrayEquals(result, d1.solve());
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

        ParallelFloydWarshall d = new ParallelFloydWarshall(graph, graph.length);
        d.solve();
        double[][] result = d.allShortestPathLengths();
        FloydWarshall d1 = new FloydWarshall(graph);
        assertArrayEquals(result, d1.solve());
    }

    @Test
    public void test4092x4092(){
        double inf = Double.POSITIVE_INFINITY;
        double[][] graph = Parser.parse("tst/matrix_4096x4096.txt");
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0.0) graph[i][j] = inf;
            }
        }

        ParallelFloydWarshall d = new ParallelFloydWarshall(graph, 8);
        long start1 = System.nanoTime();
        d.solve();
        long end1 = System.nanoTime();
        FloydWarshall d1 = new FloydWarshall(graph);
        long start2 = System.nanoTime();
        double[][] compare = d1.solve();
        long end2 = System.nanoTime();
        long parallel = end1 - start1;
        long seq = end2 - start2;
        System.out.println("Parallel Runtime: " + parallel + " Sequential Runtime: " + seq);
        double[][] result = d.allShortestPathLengths();
        assertArrayEquals(result, compare);
    }
}
