package examples.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class A09bReadAllNio {

    public static void main(String[] args) {

        Path file = Paths.get("tempest.txt");
        List<String> fileArr;

        try{

            fileArr = Files.readAllLines(file);

            fileArr.stream()
                    .filter(line -> line.contains("PROSPERO"))
                    .forEach(line -> System.out.println(line));

        } catch (IOException e){
            System.out.println("Message: " + e.getMessage());
        }
    }
}

//The code reads the entire content of the file "tempest.txt" into a List<String> using Files.readAllLines().
// It then filters and prints the lines that contain the word "PROSPERO". If an IOException occurs (e.g., the file is not found),
// the program catches it and prints an error message. The use of NIO simplifies file handling with better resource management.

