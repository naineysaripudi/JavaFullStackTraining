
import java.util.concurrent.*;

class Day6 {
    public static void main(String[] args) throws Exception {
        ExecutorService ex = Executors.newSingleThreadExecutor();

        Callable<Integer> c = () -> {
            Thread.sleep(2000);
            return 100;
        };

        Future<Integer> f = ex.submit(c);

        System.out.println("Is Done: " + f.isDone());

        System.out.println("Result: " + f.get());

        System.out.println("Is Done: " + f.isDone());

        System.out.println("Is Cancelled: " + f.isCancelled());

        ex.shutdown();
    }
}
