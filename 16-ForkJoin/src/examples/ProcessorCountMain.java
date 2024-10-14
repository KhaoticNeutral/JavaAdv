package examples;

public class ProcessorCountMain {

    public static void main(String[] args) {
        int count = Runtime.getRuntime().availableProcessors();
        System.out.println("Processor Count:" + count);
    }
}

//This is a basic example of how to get information about the system's hardware using Java.
// You can use this information to tailor your application's behavior to the specific environment it's running in.
