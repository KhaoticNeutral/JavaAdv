package practices.practice1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        // Setup Executor
        ExecutorService es = Executors.newCachedThreadPool();

        // Submit Runnable
        es.submit(new CountRunnable(20,"A"));
        es.submit(new CountRunnable(20,"B"));
        es.submit(new CountRunnable(20,"C"));

        // Showndown ExectuorService
        es.shutdown();
    }
}

//the Main class creates an ExecutorService and uses it to execute three instances of CountRunnable concurrently.
// The ExecutorService manages the creation and termination of threads, ensuring that the tasks are executed efficiently and effectively.
// This code demonstrates a basic example of how to use an ExecutorService to perform tasks in parallel.
