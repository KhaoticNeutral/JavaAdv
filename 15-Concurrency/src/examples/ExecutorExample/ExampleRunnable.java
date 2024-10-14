package examples.ExecutorExample;

public class ExampleRunnable implements Runnable {
    private final String name;

    public ExampleRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(name + ":" + i);
        }
    }
}

//In essence, this class represents a task that simply prints the name of the task and a sequence of numbers from 0 to 999.
// You can create an instance of this class and then use it to create a new thread using the Thread class. When the thread starts,
// the run() method will be executed, performing the task defined within it.