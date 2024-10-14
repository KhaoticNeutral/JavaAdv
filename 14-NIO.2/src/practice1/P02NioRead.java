package practice1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class P02NioRead {

    public static void main(String[] args) {

        try(Stream<String> lines = Files.lines(Paths.get("hamlet.txt"))){

            System.out.println("\n=== Entire File ===");
            lines.forEach(line -> System.out.println(line));

        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}

//In summary, this code reads the entire "hamlet.txt" file line by line using the Files.lines() method from the NIO API and prints each line to the console.
// It demonstrates a concise and efficient way to read and process text files in Java using NIO. The try-with-resources block ensures that the stream
// is properly closed, preventing resource leaks.

