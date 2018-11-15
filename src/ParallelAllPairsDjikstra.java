import src.Djikstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ParallelAllPairsDjikstra {
    int numNodes;
    int[][] edges;
    ExecutorService executor;

    public ParallelAllPairsDjikstra(int[][] e, int numThreads) {
        this.numNodes = e.length;
        this.edges = e;
        executor = Executors.newFixedThreadPool(numThreads);
    }

    public int[][] run() {
        List<Callable<List<Integer>>> tasks = new ArrayList<>();
        for(int i = 0; i < numNodes; i++) {
            tasks.add(new SingleDjikstra(edges, i));
        }
        try {
            List<Future<List<Integer>>> futures = executor.invokeAll(tasks);
            int[][] result = new int[numNodes][numNodes];
            for(int i = 0; i < numNodes; i++) {
                result[i] = futures.get(i).get().stream().mapToInt(t -> t).toArray();
            }
            return result;
        } catch (InterruptedException |ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    class SingleDjikstra implements Callable<List<Integer>> {

        int source;
        int[][] edges;

        public SingleDjikstra(int[][] e, int s) {
            this.edges = e;
            this.source = s;
        }

        @Override
        public List<Integer> call() throws Exception {
            Djikstra d = new Djikstra(edges, source);
            return Arrays.stream(d.run()).boxed().collect(Collectors.toList());
        }
    }

}
