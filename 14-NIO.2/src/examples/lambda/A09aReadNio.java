package examples.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class A09aReadNio {

    public static void main(String[] args) {

        try(Stream<String> lines =
                    Files.lines(Paths.get("tempest.txt"))){

            lines.forEach(line ->
                    System.out.println("Line: " + line));

        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}

//This code uses NIO's Files.lines() method to read the "tempest.txt" file line by line, printing each line prefixed with "Line: ".
// If an IOException occurs (such as the file not being found), the error is caught and an appropriate message is printed.
// The try-with-resources block ensures that the stream is closed after use.
