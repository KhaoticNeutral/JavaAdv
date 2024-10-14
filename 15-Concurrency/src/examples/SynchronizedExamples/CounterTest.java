package examples.SynchronizedExamples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CounterTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(4);

        es.submit(new CounterRunnable(10, "A"));
        es.submit(new CounterRunnable(10, "B"));
        es.submit(new CounterRunnable(10, "C"));

        es.shutdown();
    }
}

//The `CounterTest` class is similar to `AtomicTest`, but instead of using `AtomicCounterRunnable`,
// it uses `CounterRunnable`. This implies that `CounterRunnable` likely lacks the thread-safe mechanisms of
// `AtomicCounterRunnable`. Therefore, running `CounterTest` might lead to incorrect results due to race conditions when multiple
// threads access and modify the shared counter concurrently.
