package examples.SynchronizedExamples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(4);

        es.submit(new AtomicCounterRunnable(10, "A"));
        es.submit(new AtomicCounterRunnable(10, "B"));
        es.submit(new AtomicCounterRunnable(10, "C"));

        es.shutdown();
    }
}

//The `AtomicTest` class creates an `ExecutorService` with **4 threads** and submits **three instances** of the `AtomicCounterRunnable` to the executor.
// Each `AtomicCounterRunnable` increments the shared counter **10 times**, printing the current count and its thread name.
// This demonstrates how the `ExecutorService` manages the execution of multiple threads concurrently, showcasing the thread-safe operation of the
// `AtomicCounter` in a multi-threaded environment.
