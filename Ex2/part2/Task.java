package Ex2.part2;

import java.util.concurrent.Callable;

    public class Task<T> implements Callable<T> , Comparable<Task> {

        private Callable <T> callable;
        public static TaskType type ;

        private Task(Callable <T> callable, TaskType type) {
            this.callable = callable;
            this.type = type;
        }

        public static <T> Task<T> createTask(Callable<T> callable) {
            return new Task<T>(callable, TaskType.OTHER);
        }

        public static <T> Task<T> createTask(Callable<T> callable, TaskType type) {
            return new Task<T>(callable, type);
        }

        public int get_priority() {
            return type.getPriorityValue();
        }

        @Override
        public T call() {
            try {
                return callable.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(type.getPriorityValue(),other.get_priority());
        }
    }


