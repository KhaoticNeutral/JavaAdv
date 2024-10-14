package examples.ExecutorExample;

public class ThreadTest {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ExampleRunnable("one"));
        ExampleThread thread2 = new ExampleThread("two");

        // Start Threads
        thread1.start();
        thread2.start();
    }
}

//This code creates two threads, one using an `ExampleRunnable` object and the other using an `ExampleThread` object.
// Both threads are named "one" and "two" respectively. The code then starts both threads using `thread1.start()` and `thread2.start()`.
// This will cause the threads to execute their `run()` methods concurrently.

