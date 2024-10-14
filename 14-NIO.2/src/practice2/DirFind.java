package practice2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirFind {

    public static void main(String[] args) {


        try(Stream<Path> files =
                    Files.find(Paths.get("."), 9, (p,a) -> a.isDirectory())){

            System.out.println("\n=== Find all dirs ===");
            files.forEach(line -> System.out.println(line));

        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}

//In summary, this code finds all directories within the current directory (and its subdirectories up to 9 levels deep) and prints their
// paths to the console. It demonstrates how to use Files.find() to search for files and directories based on specific criteria.

