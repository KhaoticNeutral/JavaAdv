package practice2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirList {
    public static void main(String[] args) {

        try(Stream<Path> files = Files.list(Paths.get("."))){

            System.out.println("\n=== Dir list ===");
            files.forEach(line -> System.out.println(line));

        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}

//In summary, this code lists all files and directories within the current directory and prints their paths to the console.
// It demonstrates how to use Files.list() to list files and directories within a specific directory.