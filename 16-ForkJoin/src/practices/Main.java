package practices;

import java.util.concurrent.ForkJoinPool;

public class Main {

    //We use a lot of memory
    //The project properties should have a Run, VM Option of -Xmx1024m
    public static void main(String[] args) {
        int[] data = new int[1024 * 1024 * 128]; //512MB

        ForkJoinPool pool = new ForkJoinPool();

        RandomArrayAction action = new RandomArrayAction(data, 0, data.length-1, data.length/16);
        pool.invoke(action);

        FindMaxTask task = new FindMaxTask(data, 0, data.length-1, data.length/16);
        Integer result = pool.invoke(task);
        System.out.println("Max value found:" + result);

    }
}

//This code leverages parallel processing to efficiently find the maximum value in a large array.
// The -Xmx1024m VM option indicates that the Java Virtual Machine (JVM) is configured with a maximum heap size of 1024 MB,
// likely to accommodate the large array.
