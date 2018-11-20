import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestParallelDijkstra {

    @Test
    public void test4x4() {

        double inf = Double.POSITIVE_INFINITY;
        double[][] graph = Parser.parse("tst/matrix_4x4.txt");
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0.0) graph[i][j] = inf;
            }
        }

        //Prints out runtime for threads 1 to 64 in powers of 2
        int[] numThreads = {1, 2, 4, 8, 16, 32, 64};
        for(int threads : numThreads) {
            ParallelDijkstra d1 = new ParallelDijkstra(graph, 0, threads);
            long start = System.nanoTime();
            d1.solve();
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("Time for " + threads + " threads: " + time);
        }

        //Checks for correctness
        ParallelDijkstra d = new ParallelDijkstra(graph, 0, 4);
        double[] result = d.solve();
        Dijkstra d1 = new Dijkstra(graph, 0);
        double[] expected = d1.solve();
        for(int i = 0; i < result.length; i++){
                assertEquals(result[i], expected[i], 0.0001);
            }
    }

    @Test
    public void test16x16() {
        double inf = Double.POSITIVE_INFINITY;
        double[][] graph = Parser.parse("tst/matrix_16x16.txt");
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == 0.0) graph[i][j] = inf;
            }
        }

        //Prints out runtime for threads 1 to 64 in powers of 2
        int[] numThreads = {1, 2, 4, 8, 16, 32, 64};
        for (int threads : numThreads) {
            ParallelDijkstra d1 = new ParallelDijkstra(graph, 0, threads);
            long start = System.nanoTime();
            d1.solve();
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("Time for " + threads + " threads: " + time);
        }

        //Checks for correctness
        ParallelDijkstra d = new ParallelDijkstra(graph, 0, 4);
        double[] result = d.solve();
        Dijkstra d1 = new Dijkstra(graph, 0);
        double[] expected = d1.solve();
        for(int i = 0; i < result.length; i++){
            assertEquals(result[i], expected[i], 0.0001);
        }
    }

    @Test
    public void test32x32(){
        double inf = Double.POSITIVE_INFINITY;
        double[][] graph = Parser.parse("tst/matrix_32x32.txt");
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0.0) graph[i][j] = inf;
            }
        }

        //Prints out runtime for threads 1 to 64 in powers of 2
        int[] numThreads = {1, 2, 4, 8, 16, 32, 64};
        for (int threads : numThreads) {
            ParallelDijkstra d1 = new ParallelDijkstra(graph, 0, threads);
            long start = System.nanoTime();
            d1.solve();
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("Time for " + threads + " threads: " + time);
        }

        //Checks for correctness
        ParallelDijkstra d = new ParallelDijkstra(graph, 0, 4);
        double[] result = d.solve();
        Dijkstra d1 = new Dijkstra(graph, 0);
        double[] expected = d1.solve();
        for(int i = 0; i < result.length; i++){
            assertEquals(result[i], expected[i], 0.0001);
        }
    }

    @Test
    public void test64x64(){
        double inf = Double.POSITIVE_INFINITY;
        double[][] graph = Parser.parse("tst/matrix_64x64.txt");
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0.0) graph[i][j] = inf;
            }
        }

        //Prints out runtime for threads 1 to 64 in powers of 2
        int[] numThreads = {1, 2, 4, 8, 16, 32, 64};
        for (int threads : numThreads) {
            ParallelDijkstra d1 = new ParallelDijkstra(graph, 0, threads);
            long start = System.nanoTime();
            d1.solve();
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("Time for " + threads + " threads: " + time);
        }

        //Checks for correctness
        ParallelDijkstra d = new ParallelDijkstra(graph, 0, 4);
        double[] result = d.solve();
        Dijkstra d1 = new Dijkstra(graph, 0);
        double[] expected = d1.solve();
        for(int i = 0; i < result.length; i++){
            assertEquals(result[i], expected[i], 0.0001);
        }
    }

    @Test
    public void test128x128(){
        double inf = Double.POSITIVE_INFINITY;
        double[][] graph = Parser.parse("tst/matrix_128x128.txt");
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0.0) graph[i][j] = inf;
            }
        }

        //Prints out runtime for threads 1 to 64 in powers of 2
        int[] numThreads = {1, 2, 4, 8, 16, 32, 64};
        for (int threads : numThreads) {
            ParallelDijkstra d1 = new ParallelDijkstra(graph, 0, threads);
            long start = System.nanoTime();
            d1.solve();
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("Time for " + threads + " threads: " + time);
        }

        //Checks for correctness
        ParallelDijkstra d = new ParallelDijkstra(graph, 0, 4);
        double[] result = d.solve();
        Dijkstra d1 = new Dijkstra(graph, 0);
        double[] expected = d1.solve();
        for(int i = 0; i < result.length; i++){
            assertEquals(result[i], expected[i], 0.0001);
        }
    }

    @Test
    public void test256x256(){
        double inf = Double.POSITIVE_INFINITY;
        double[][] graph = Parser.parse("tst/matrix_256x256.txt");
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0.0) graph[i][j] = inf;
            }
        }

        //Prints out runtime for threads 1 to 64 in powers of 2
        int[] numThreads = {1, 2, 4, 8, 16, 32, 64};
        for (int threads : numThreads) {
            ParallelDijkstra d1 = new ParallelDijkstra(graph, 0, threads);
            long start = System.nanoTime();
            d1.solve();
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("Time for " + threads + " threads: " + time);
        }

        //Checks for correctness
        ParallelDijkstra d = new ParallelDijkstra(graph, 0, 4);
        double[] result = d.solve();
        Dijkstra d1 = new Dijkstra(graph, 0);
        double[] expected = d1.solve();
        for(int i = 0; i < result.length; i++){
            assertEquals(result[i], expected[i], 0.0001);
        }
    }

    @Test
    public void test512x512(){
        double inf = Double.POSITIVE_INFINITY;
        double[][] graph = Parser.parse("tst/matrix_512x512.txt");
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0.0) graph[i][j] = inf;
            }
        }

        //Prints out runtime for threads 1 to 64 in powers of 2
        int[] numThreads = {1, 2, 4, 8, 16, 32, 64};
        for (int threads : numThreads) {
            ParallelDijkstra d1 = new ParallelDijkstra(graph, 0, threads);
            long start = System.nanoTime();
            d1.solve();
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("Time for " + threads + " threads: " + time);
        }

        //Checks for correctness
        ParallelDijkstra d = new ParallelDijkstra(graph, 0, 4);
        double[] result = d.solve();
        Dijkstra d1 = new Dijkstra(graph, 0);
        double[] expected = d1.solve();
        for(int i = 0; i < result.length; i++){
            assertEquals(result[i], expected[i], 0.0001);
        }
    }

    @Test
    public void test1024x1024(){
        double inf = Double.POSITIVE_INFINITY;
        double[][] graph = Parser.parse("tst/matrix_1024x1024.txt");
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0.0) graph[i][j] = inf;
            }
        }

        //Prints out runtime for threads 1 to 64 in powers of 2
        int[] numThreads = {1, 2, 4, 8, 16, 32, 64};
        for (int threads : numThreads) {
            ParallelDijkstra d1 = new ParallelDijkstra(graph, 0, threads);
            long start = System.nanoTime();
            d1.solve();
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("Time for " + threads + " threads: " + time);
        }

        //Checks for correctness
        ParallelDijkstra d = new ParallelDijkstra(graph, 0, 4);
        double[] result = d.solve();
        Dijkstra d1 = new Dijkstra(graph, 0);
        double[] expected = d1.solve();
        for(int i = 0; i < result.length; i++){
            assertEquals(result[i], expected[i], 0.0001);
        }
    }

    @Test
    public void test2048x2048(){
        double inf = Double.POSITIVE_INFINITY;
        double[][] graph = Parser.parse("tst/matrix_2048x2048.txt");
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0.0) graph[i][j] = inf;
            }
        }

        //Prints out runtime for threads 1 to 64 in powers of 2
        int[] numThreads = {1, 2, 4, 8, 16, 32, 64};
        for (int threads : numThreads) {
            ParallelDijkstra d1 = new ParallelDijkstra(graph, 0, threads);
            long start = System.nanoTime();
            d1.solve();
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("Time for " + threads + " threads: " + time);
        }

        //Checks for correctness
        ParallelDijkstra d = new ParallelDijkstra(graph, 0, 4);
        double[] result = d.solve();
        Dijkstra d1 = new Dijkstra(graph, 0);
        double[] expected = d1.solve();
        for(int i = 0; i < result.length; i++){
            assertEquals(result[i], expected[i], 0.0001);
        }

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

        //Prints out runtime for threads 1 to 64 in powers of 2
        int[] numThreads = {1, 2, 4, 8, 16, 32, 64};
        for(int threads : numThreads) {
            ParallelDijkstra d1 = new ParallelDijkstra(graph, 0, threads);
            long start = System.nanoTime();
            d1.solve();
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("Time for " + threads + " threads: " + time);
        }

        //Checks for correctness
        ParallelDijkstra d = new ParallelDijkstra(graph, 0, 4);
        double[] result = d.solve();
        Dijkstra d1 = new Dijkstra(graph, 0);
        double[] expected = d1.solve();
        for(int i = 0; i < result.length; i++){
            assertEquals(result[i], expected[i], 0.0001);
        }
    }
 }
