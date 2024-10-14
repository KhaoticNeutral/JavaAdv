package practice2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirWalk {
    public static void main(String[] args) {
        try(Stream<Path> files = Files.walk(Paths.get("."))){

            System.out.println("\n=== Dir walk ===");
            files.forEach(line -> System.out.println(line));

        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

        try(Stream<Path> files = Files.walk(Paths.get("."))){

            System.out.println("\n=== Dir build ===");
            files
                    .filter(path -> path.toString().contains("build"))
                    .forEach(line -> System.out.println(line));

        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}

//In summary, this code first walks through the entire directory structure starting from the current directory and prints all
// file and directory paths. Then, it walks through the same structure again, but this time filters the results to only include paths
// containing "build" in their string representation. This demonstrates how to use Files.walk() to traverse a directory structure and how to
// filter the results based on specific criteria.
