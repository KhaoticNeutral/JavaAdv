package examples.lambda;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class A11FileWalk {

    public static void main(String[] args) {

        try(Stream<Path> files = Files.walk(Paths.get("."))){

            files
                    .forEach(line -> System.out.println(line));

        } catch (Exception e){
            System.out.println("Message: " + e.getMessage());
        }
    }
}

//In essence, the code does the following:
//
//It starts from the current directory.
//It walks through all files and directories within the current directory and its subdirectories.
//For each file or directory encountered, it prints its path to the console.
//This code provides a basic example of how to traverse a directory structure in Java using the Files.walk method and stream processing.