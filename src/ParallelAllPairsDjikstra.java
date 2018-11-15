import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ParallelAllPairsDjikstra {
    int numNodes;
    double[][] edges;
    ExecutorService executor;

    public ParallelAllPairsDjikstra(double[][] e, int numThreads) {
        this.numNodes = e.length;
        this.edges = e;
        executor = Executors.newFixedThreadPool(numThreads);
    }

    public double[][] solve() {
        List<Callable<List<Double>>> tasks = new ArrayList<>();
        for(int i = 0; i < numNodes; i++) {
            tasks.add(new SingleDjikstra(edges, i));
        }
        try {
            List<Future<List<Double>>> futures = executor.invokeAll(tasks);
            double[][] result = new double[numNodes][];
            for(int i = 0; i < numNodes; i++) {
                result[i] = futures.get(i).get().stream().mapToDouble(t -> t).toArray();
            }
            return result;
        } catch (InterruptedException |ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    class SingleDjikstra implements Callable<List<Double>> {

        int source;
        double[][] edges;

        public SingleDjikstra(double[][] e, int s) {
            this.edges = e;
            this.source = s;
        }

        @Override
        public List<Double> call() throws Exception {
            Djikstra d = new Djikstra(edges, source);
            return Arrays.stream(d.solve()).boxed().collect(Collectors.toList());
        }
    }

}
