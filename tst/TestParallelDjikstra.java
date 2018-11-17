import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestParallelDjikstra {

    @Test
    public void test4x4() {

        double inf = Double.POSITIVE_INFINITY;
        double[][] graph = Parser.parse("tst/matrix_4x4.txt");
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0.0) graph[i][j] = inf;
            }
        }


        int[] numThreads = {1, 2, 4, 8, 16, 32, 64};

        for(int threads : numThreads) {
            ParallelDjikstra d1 = new ParallelDjikstra(graph, 0, threads);
            long start = System.nanoTime();
            d1.solve();
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("Time for " + threads + " threads: " + time);
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

        int[] numThreads = {1, 2, 4, 8, 16, 32, 64};

        for (int threads : numThreads) {
            ParallelDjikstra d1 = new ParallelDjikstra(graph, 0, threads);
            long start = System.nanoTime();
            d1.solve();
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("Time for " + threads + " threads: " + time);
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

        int[] numThreads = {1, 2, 4, 8, 16, 32, 64};

        for (int threads : numThreads) {
            ParallelDjikstra d1 = new ParallelDjikstra(graph, 0, threads);
            long start = System.nanoTime();
            d1.solve();
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("Time for " + threads + " threads: " + time);
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

        int[] numThreads = {1, 2, 4, 8, 16, 32, 64};

        for (int threads : numThreads) {
            ParallelDjikstra d1 = new ParallelDjikstra(graph, 0, threads);
            long start = System.nanoTime();
            d1.solve();
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("Time for " + threads + " threads: " + time);
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

        int[] numThreads = {1, 2, 4, 8, 16, 32, 64};

        for (int threads : numThreads) {
            ParallelDjikstra d1 = new ParallelDjikstra(graph, 0, threads);
            long start = System.nanoTime();
            d1.solve();
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("Time for " + threads + " threads: " + time);
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

        int[] numThreads = {1, 2, 4, 8, 16, 32, 64};

        for (int threads : numThreads) {
            ParallelDjikstra d1 = new ParallelDjikstra(graph, 0, threads);
            long start = System.nanoTime();
            d1.solve();
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("Time for " + threads + " threads: " + time);
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

        int[] numThreads = {1, 2, 4, 8, 16, 32, 64};

        for (int threads : numThreads) {
            ParallelDjikstra d1 = new ParallelDjikstra(graph, 0, threads);
            long start = System.nanoTime();
            d1.solve();
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("Time for " + threads + " threads: " + time);
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

        int[] numThreads = {1, 2, 4, 8, 16, 32, 64};

        for (int threads : numThreads) {
            ParallelDjikstra d1 = new ParallelDjikstra(graph, 0, threads);
            long start = System.nanoTime();
            d1.solve();
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("Time for " + threads + " threads: " + time);
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

        int[] numThreads = {1, 2, 4, 8, 16, 32, 64};

        for (int threads : numThreads) {
            ParallelDjikstra d1 = new ParallelDjikstra(graph, 0, threads);
            long start = System.nanoTime();
            d1.solve();
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("Time for " + threads + " threads: " + time);
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
        int[] numThreads = {1, 2, 4, 8, 16, 32, 64};
        for(int threads : numThreads) {
            ParallelDjikstra d1 = new ParallelDjikstra(graph, 0, threads);
            long start = System.nanoTime();
            d1.solve();
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("Time for " + threads + " threads: " + time);
        }
    }

    //Takes incredibly long, would not recommend running
    @Test
    public void test8192x8192(){
        double inf = Double.POSITIVE_INFINITY;
        double[][] graph = Parser.parse("tst/matrix_8192x8192.txt");
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0.0) graph[i][j] = inf;
            }
        }

        ParallelDjikstra d = new ParallelDjikstra(graph, 0, 4);
        double[] result = d.solve();
        Djikstra d2 = new Djikstra(graph, 0);
        assertArrayEquals(result, d2.solve(), 0.01);

    }
}
