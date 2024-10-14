package examples;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CyclicBarrierExample implements Runnable{
    final CyclicBarrier barrier = new CyclicBarrier(2);
    AtomicInteger threadCount = new AtomicInteger(0);


    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(4);

        CyclicBarrierExample ex = new CyclicBarrierExample();
        es.submit(ex);
        //es.submit(ex);

        es.shutdown();
    }

    public void run() {
        try {
            System.out.println("before await - "
                    + threadCount.incrementAndGet());
            barrier.await();
            System.out.println("after await - "
                    + threadCount.get());
        } catch (BrokenBarrierException|InterruptedException ex) {

        }
    }

}

//the CyclicBarrierExample class demonstrates how to use a CyclicBarrier to synchronize threads.
// It creates a barrier that waits for 2 threads to reach it before allowing any of them to proceed.
// The run() method of each thread prints messages to the console and increments a counter to track the number of
// threads that have reached the barrier.
