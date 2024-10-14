package examples.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class A12FileFind {

    public static void main(String[] args) {

        try(Stream<Path> files =
                    Files.find(
                            Paths.get("."), 9, (p, a) -> a.isDirectory())){

            files
                    .forEach(f -> System.out.println("Dirname: " + f));

        } catch (IOException e){
            System.out.println("Message: " + e.getMessage());
        }
    }
}

//In summary, the code does this:
//
//It starts from the current directory.
//It searches for directories within the current directory and its subdirectories up to a depth of 9 levels.
//It prints the paths of all found directories to the console.
//This code demonstrates how to use Files.find to specifically target directories within a directory structure, making it a more focused
// file search compared to the previous Files.walk example.
