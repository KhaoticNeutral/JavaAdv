package examples.SynchronizedExamples;

public class SynchronizedCounterRunnable implements Runnable{
    private SynchronizedCounter count = new SynchronizedCounter();
    private int countSize = 0;
    private String threadName;

    public SynchronizedCounterRunnable(){
        super();
    }

    public SynchronizedCounterRunnable(int countSize, String threadName){
        this.countSize = countSize;
        this.threadName = threadName;
    }

    @Override
    public void run(){
        for (int i = 0; i < countSize; i++){
            synchronized(this){
                count.increment();
                System.out.println(threadName
                        + " Current Count: " + count.getValue());
            }
        }
    }
}

//The use of the synchronized block and the SynchronizedCounter object together ensure that the counter is incremented and accessed
// in a thread-safe manner, preventing race conditions.
