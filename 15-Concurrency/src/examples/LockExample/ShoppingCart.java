package examples.LockExample;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ShoppingCart {
    private final ReentrantReadWriteLock rwl =
            new ReentrantReadWriteLock();

    public void addItem(Object o) {
        rwl.writeLock().lock();
        // modify shopping cart
        rwl.writeLock().unlock();
    }
    public String getSummary() {
        String s = "";
        rwl.readLock().lock();
        // read cart, modify s
        rwl.readLock().unlock();
        return s;
    }
    public double getTotal() {
        double total = 0;
        rwl.readLock().lock();
        // read cart, add everything to total
        rwl.readLock().unlock();
        return total;
    }
}

//The `ShoppingCart` class uses a `ReentrantReadWriteLock` to ensure that the shopping cart is accessed in a thread-safe manner.
// The `addItem` method acquires the **write lock** before modifying the shopping cart, ensuring that no other thread can read or
// write to the cart at the same time. The `getSummary` and `getTotal` methods acquire the **read lock** before reading the cart,
// allowing multiple threads to read the cart concurrently. This approach ensures that the shopping cart is updated consistently and efficiently.
