import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ParallelFloydWarshall {

    private ExecutorService exec;
    private int numThreads;
    private double[] current;
    private double[] next;

    private int[] maxIndex;
    private int numNodes;
    private boolean solved;

    private int getIndex(int i, int j){
        return i*numNodes+j;
    }

    private int getI(int index){
        return index / numNodes;
    }

    private int getJ(int index){
        return index % numNodes;
    }

    public ParallelFloydWarshall(double[][] distances, int numThreads){
        this.exec = Executors.newFixedThreadPool(numThreads);
        this.numThreads = numThreads;
        this.numNodes = distances.length;
        this.current = new double[numNodes*numNodes];
        this.next = new double[numNodes*numNodes];
        this.maxIndex = new int[numNodes*numNodes];
        Arrays.fill(maxIndex, -1);
        for(int i = 0; i < numNodes; i++){
            for(int j = 0; j < numNodes; j++){
                current[getIndex(i,j)] = distances[i][j];
            }
        }
        this.solved = false;
    }

    public void solve(){
        if(solved){
            throw new RuntimeException("Already solved");
        }
        for(int k = 0; k < numNodes; k++){
            List<Callable<Boolean>> tasks = new ArrayList<Callable<Boolean>>();
            if(current.length < numThreads){
                for(int i = 0; i < current.length; i++){
                    tasks.add(new FloydJob(i,i+1,k));
                }
            }
            else{
                for(int t = 0; t < numThreads; t++){
                    int lo = t*current.length/numThreads;
                    int hi = (t+1)*current.length/numThreads;
                    tasks.add(new FloydJob(lo,hi,k));
                }
            }
            try {
                List<Future<Boolean>> results = this.exec.invokeAll(tasks);
                for(Future<Boolean> result : results){
                    if(!result.get().booleanValue()){
                        throw new RuntimeException();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
            double[] temp = current;
            current = next;
            next = temp;
        }
        next = null;
        solved = true;
        exec.shutdown();
    }

    public double shorestPathLength(int i, int j){
        if(!solved){
            throw new RuntimeException("Must solve first");
        }
        return this.current[getIndex(i,j)];
    }

    public List<Integer> shortestPath(int i, int j){
        if(current[getIndex(i,j)] == Double.POSITIVE_INFINITY){
            return null;
        }
        else{
            List<Integer> ans = new ArrayList<Integer>();
            ans.add(Integer.valueOf(i));
            shortestPathHelper(i,j,ans);
            return ans;
        }
    }

    public double[][] allShortestPathLengths() {
        double[][] result = new double[numNodes][numNodes];
        for(int i = 0; i < numNodes; i++) {
            for(int j = 0; j < numNodes; j++) {
                result[i][j] = shorestPathLength(i, j);
            }
        }
        return result;
    }

    public void shortestPathHelper(int i, int j, List<Integer> partialPath){
        int index = getIndex(i,j);
        if(this.maxIndex[index] < 0){
            partialPath.add(Integer.valueOf(j));
        }
        else{
            shortestPathHelper(i,this.maxIndex[index],partialPath);
            shortestPathHelper(this.maxIndex[index],j,partialPath);
        }
    }

    private class FloydJob implements Callable<Boolean>{

        private final int lo;
        private final int hi;
        private final int k;

        public FloydJob(int lo, int hi, int k){
            this.lo = lo;
            this.hi = hi;
            this.k = k;
        }

        @Override
        public Boolean call() throws Exception {
            for(int index = lo; index < hi; index++){
                int i = getI(index);
                int j = getJ(index);
                double alternatePathValue = current[getIndex(i,k)]
                        + current[getIndex(k,j)];

                if(alternatePathValue < current[index]){
                    next[index] = alternatePathValue;
                    maxIndex[index] = k;
                }
                else{
                    next[index] = current[index];
                }
            }
            return true;
        }
    }
}