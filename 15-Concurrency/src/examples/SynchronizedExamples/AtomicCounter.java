package examples.SynchronizedExamples;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private static AtomicInteger i = new AtomicInteger();

    public void increment(){
        i.incrementAndGet();
    }

    public void decrement(){
        i.decrementAndGet();
    }

    public int getValue(){
        return i.get();
    }
}

//The use of AtomicInteger eliminates the need for explicit synchronization mechanisms like locks.
// It ensures that the counter is always updated correctly and consistently, even in a multi-threaded environment.


