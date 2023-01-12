package Ex2.part2;

import java.util.concurrent.FutureTask;

public class Adapter<T> extends FutureTask<T> implements Comparable<Adapter<T>> {
    private Task<T> task;
    public Adapter(Task<T> task) {
        super(task);
        this.task = task;
    }
    @Override
    public int compareTo(Adapter<T> other){
        return Integer.compare(task.get_priority(), other.task.get_priority());
    }
}
