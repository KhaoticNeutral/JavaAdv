package examples.SynchronizedExamples;

public class SynchronizedCounter {
    private static int i = 0;

    public synchronized void increment(){
        i++;
    }

    public synchronized void decrement(){
        i--;
    }

    public synchronized int getValue(){
        return i;
    }
}

//The `SynchronizedCounter` class implements a counter using a simple integer variable `i`.
// It uses the `synchronized` keyword to ensure that only one thread can access and modify the counter at a time.
// This prevents race conditions by providing a lock mechanism.  The `increment`, `decrement`, and `getValue` methods are all synchronized,
// ensuring that all operations on the counter are atomic and thread-safe.

