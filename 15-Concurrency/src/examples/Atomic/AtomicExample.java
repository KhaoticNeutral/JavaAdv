package examples.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {

    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(5);
        System.out.println("New value: "
                + ai.incrementAndGet());
        System.out.println("New value: "
                + ai.getAndIncrement());
        System.out.println("New value: "
                + ai.getAndIncrement());

    }
}

//In summary, this code demonstrates how to use AtomicInteger to safely increment an integer value in a multithreaded environment.
// The incrementAndGet() and getAndIncrement() methods ensure that the increment operation is atomic, meaning it happens as a single,
// indivisible operation, preventing race conditions and ensuring thread safety.