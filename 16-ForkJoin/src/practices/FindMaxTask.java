package practices;

import java.util.concurrent.RecursiveTask;

public class FindMaxTask extends RecursiveTask<Integer> {
    private final int threshold;
    private final int[] myArray;
    private int start;
    private int end;

    public FindMaxTask(int[] myArray, int start, int end, int threshold) {
        this.threshold = threshold;
        this.myArray = myArray;
        this.start = start;
        this.end = end;
    }

    protected Integer compute() {
        if (end - start < threshold) {
            int max = Integer.MIN_VALUE;
            for (int i = start; i <= end; i++) {
                int n = myArray[i];
                if (n > max) {
                    max = n;
                }
            }
            return max;
        } else {
            int midway = (end - start) / 2 + start;
            FindMaxTask a1 = new FindMaxTask(myArray, start, midway, threshold);
            a1.fork();
            FindMaxTask a2 = new FindMaxTask(myArray, midway + 1, end, threshold);
            return Math.max(a2.compute(), a1.join());
        }
    }
}

//The `FindMaxTask` class finds the maximum value in an array using recursion and parallel processing.
// It splits the array into smaller parts until they're small enough to process directly, then combines the results
// to find the overall maximum. This is efficient for large arrays because it can use multiple processors.
// The `threshold` parameter controls how many parts the array is split into.