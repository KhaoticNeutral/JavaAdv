package examples.ExecutorExample;

public class ExampleThread extends Thread {
    private final String name;

    public ExampleThread(String name){
        this.name = name;
    }

    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            System.out.println(name + ":" + i);
        }
    }
}

//This code defines a class ExampleThread that extends the Thread class, creating a custom thread that prints the name of the
// thread and a sequence of numbers from 0 to 999.
