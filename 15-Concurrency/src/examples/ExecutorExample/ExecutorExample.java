package examples.ExecutorExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ExecutorExample {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        es.execute(new ExampleRunnable("one"));
        es.execute(new ExampleRunnable("two"));
        es.shutdown();
    }
}

//This code creates a fixed-size thread pool with 3 threads using `Executors.newFixedThreadPool(3)`. It then submits two `ExampleRunnable`
// tasks, one named "one" and the other "two", to the thread pool for execution. Finally, it shuts down the thread pool using `es.shutdown()`.

