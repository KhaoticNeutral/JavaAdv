package examples.SynchronizedExamples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);

        es.submit(new SynchronizedCounterRunnable(10, "A"));
        es.submit(new SynchronizedCounterRunnable(10, "B"));
        es.submit(new SynchronizedCounterRunnable(10, "C"));

        es.shutdown();
    }
}

//In essence, this code creates three threads that will increment a shared counter using the SynchronizedCounterRunnable class.
// The synchronized keyword in the SynchronizedCounterRunnable ensures that the counter is accessed and modified in a thread-safe manner,
// preventing race conditions.
