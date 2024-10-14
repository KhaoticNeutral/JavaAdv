package examples.ExecutorExample;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorExample2 {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(4);
        Future<String> f1 = es.submit(new ExampleCallable("one", 10000));
        Future<String> f2 = es.submit(new ExampleCallable("two", 10000));

        try {
            es.awaitTermination(5, TimeUnit.SECONDS);
            es.shutdown();
            String result1 = f1.get();
            System.out.println("Result of one: " + result1);
            String result2 = f2.get();
            System.out.println("Result of two: " + result2);
        } catch (ExecutionException | InterruptedException ex) {
            System.out.println("Exception: " + ex);
        }

    }
}

//This code creates a fixed-size thread pool with 4 threads. It then submits two `ExampleCallable` tasks,
// one named "one" and the other "two", to the thread pool for execution. Each task calculates the sum of numbers from 0 to 9999.
// The code then waits for the thread pool to terminate (or for 5 seconds) and retrieves the results from the `Future` objects.
// Finally, it prints the results of each task.