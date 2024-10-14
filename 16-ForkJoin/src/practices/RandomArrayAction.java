package practices;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayAction extends RecursiveAction {
    private final int threshold;
    private final int[] myArray;
    private int start;
    private int end;

    public RandomArrayAction(int[] myArray, int start, int end, int threshold) {
        this.threshold = threshold;
        this.myArray = myArray;
        this.start = start;
        this.end = end;
    }

    protected void compute() {
        if (end - start < threshold) {
            for (int i = start; i <= end; i++) {
                myArray[i] = ThreadLocalRandom.current().nextInt();
            }
        } else {
            int midway = (end - start) / 2 + start;
            RandomArrayAction r1 = new RandomArrayAction(myArray, start, midway, threshold);
            RandomArrayAction r2 = new RandomArrayAction(myArray, midway + 1, end, threshold);
            invokeAll(r1, r2);
        }
    }
}

//RandomArrayAction uses recursion and parallel processing to efficiently fill a large array with random integers.
// The threshold parameter allows for controlling the granularity of the splitting process, balancing the overhead of
// creating tasks with the potential for parallelism.
