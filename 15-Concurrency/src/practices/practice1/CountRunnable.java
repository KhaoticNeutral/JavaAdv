package practices.practice1;

public class CountRunnable implements Runnable{

    final int count;
    final String threadName;

    // Setup Constructor to initialize variables
    public CountRunnable(int count, String name){
        this.count = count;
        this.threadName = name;
    }

    public void run(){
        // Count with for loop
        for (int i = 1; i <= count; i++){
            System.out.println("Thread " + threadName +
                    ": " + i);
        }
    }
}

//the CountRunnable class provides a simple way to create threads that count from 1 to a specified number and print the count to the console.
// It's a useful example for understanding how to use the Runnable interface and how to create threads in Java.

