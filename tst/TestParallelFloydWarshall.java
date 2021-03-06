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

        //Tests for correctness
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

        //Tests for correctness
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

        //Tests for correctness
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

        //Tests for correctness
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

        //Tests for correctness
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

        //Tests for correctness
        ParallelFloydWarshall d = new ParallelFloydWarshall(graph, graph.length);
        d.solve();
        double[][] result = d.allShortestPathLengths();
        FloydWarshall d1 = new FloydWarshall(graph);
        assertArrayEquals(result, d1.solve());
    }


    @Test
    public void test4096x4096(){
        double inf = Double.POSITIVE_INFINITY;
        double[][] graph = Parser.parse("tst/matrix_4096x4096.txt");
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0.0) graph[i][j] = inf;
            }
        }

        //Tests for correctness
        ParallelFloydWarshall d = new ParallelFloydWarshall(graph, graph.length);
        d.solve();
        double[][] result = d.allShortestPathLengths();
        FloydWarshall d1 = new FloydWarshall(graph);
        assertArrayEquals(result, d1.solve());
    }

    @Test
    public void testVaryingThreadTimes() {

        int[] numNodes = {4, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096};
        for(int nodes : numNodes) {
            System.out.println(nodes + " total nodes");
            double inf = Double.POSITIVE_INFINITY;
            double[][] graph = Parser.parse("tst/matrix_" + nodes + "x" + nodes + ".txt");
            for(int i = 0; i < graph.length; i++){
                for(int j = 0; j < graph[0].length; j++){
                    if(graph[i][j] == 0.0) graph[i][j] = inf;
                }
            }

            int[] numThreads = {1, 2, 4, 8, 16, 32, 64};

            for(int threads : numThreads) {
                ParallelFloydWarshall d1 = new ParallelFloydWarshall(graph, threads);
                long start = System.nanoTime();
                d1.solve();
                long end = System.nanoTime();
                long time = end - start;
                System.out.println("Time for " + threads + " threads: " + time);
            }

        }
    }


}
