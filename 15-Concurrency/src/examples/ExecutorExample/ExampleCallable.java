package examples.ExecutorExample;

import java.util.concurrent.Callable;

public class ExampleCallable implements Callable {

    private final String name;
    private final int len;
    private int sum = 0;

    public ExampleCallable(String name, int len) {
        this.name = name;
        this.len = len;
    }

    @Override
    public String call() throws Exception {
        for (int i = 0; i < len; i++) {
            System.out.println(name + ":" + i);
            sum += i;
        }
        return "sum: " + sum;
    }

}

//In essence, this class represents a task that performs a simple summation operation. It can be submitted to a thread pool using the
// ExecutorService class, and the call() method will be executed by a thread from the pool. The result of the task, the calculated sum,
// will be returned as a string.
