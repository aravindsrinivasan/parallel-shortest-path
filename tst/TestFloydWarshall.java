import org.junit.Test;

import java.util.Arrays;

public class TestFloydWarshall {

    @Test
    public void test4x4() {

        double inf = Double.POSITIVE_INFINITY;
        double[][] graph = Parser.parse("tst/matrix_4x4.txt");
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0.0) graph[i][j] = inf;
            }
        }

        FloydWarshall d = new FloydWarshall(graph);
        double[][] result = d.solve();
        System.out.println(Arrays.deepToString(result));
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

        FloydWarshall d = new FloydWarshall(graph);
        double[][] result = d.solve();
        System.out.println(Arrays.deepToString(result));
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

        FloydWarshall d = new FloydWarshall(graph);
        double[][] result = d.solve();
        System.out.println(Arrays.deepToString(result));
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

        FloydWarshall d = new FloydWarshall(graph);
        double[][] result = d.solve();
        System.out.println(Arrays.deepToString(result));
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

        FloydWarshall d = new FloydWarshall(graph);
        double[][] result = d.solve();
        System.out.println(Arrays.deepToString(result));
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

        FloydWarshall d = new FloydWarshall(graph);
        double[][] result = d.solve();
        System.out.println(Arrays.deepToString(result));
    }
}
