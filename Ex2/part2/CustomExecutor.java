package Ex2.part2;

import java.util.concurrent.*;
import java.util.concurrent.Future;

public class CustomExecutor<T>{
    private ThreadPoolExecutor myThreadPool;
    private PriorityBlockingQueue taskQueue = new PriorityBlockingQueue<>();
    private int arr[]= {0,0,0,0,0,0,0,0,0,0};


    public CustomExecutor() {
        int num_of_cores = Runtime.getRuntime().availableProcessors();
        int core_pool_size = num_of_cores / 2;
        int max_pool_size = num_of_cores - 1;
        myThreadPool = new ThreadPoolExecutor(core_pool_size, max_pool_size, 300, TimeUnit.MILLISECONDS, taskQueue);
    }

    private <T> Future<T> exe(Task task) {
        if (task == null) {
            throw new NullPointerException();
        }
        RunnableFuture<T> futureTask = new Adapter<T>(task);
        myThreadPool.execute(futureTask);
        arr[task.get_priority()-1]--;
        return futureTask;
    }

    public  <T> Future<T> submit(Callable callable, TaskType type) {
        Task task = Task.createTask(callable, type);
        arr[task.get_priority()-1]++;
        return exe(task);
    }
    public  <T> Future<T> submit(Callable callable){
        Task task = Task.createTask(callable);
        arr[task.get_priority()-1]++;
        return exe(task);
    }

    public int getCurrentMax() {
        for (int i = 0; i <arr.length; i++) {
            if(arr[i]!=0)
                return i+1;
        }
        return 0;
    }
    public void gracefullyTerminate() {
        myThreadPool.shutdown();
    }
}

