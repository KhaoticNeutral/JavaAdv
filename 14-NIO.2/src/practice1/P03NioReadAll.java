package practice1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class P03NioReadAll {

    public static void main(String[] args) {

        List<String> fileArr;
        Path file =  Paths.get("hamlet.txt");

        try{
            fileArr = Files.readAllLines(file);

            System.out.println("\n=== Rosencrantz ===");
            fileArr.stream()
                    .filter(line -> line.contains("Ros."))
                    .forEach(line -> System.out.println(line));

            System.out.println("\n=== Guildenstern ===");
            fileArr.stream()
                    .filter(line -> line.contains("Guil."))
                    .forEach(line -> System.out.println(line));


        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}

//In summary, this code reads the entire "hamlet.txt" file into a list of strings, then filters and prints lines containing either "Ros."
// or "Guil.". It demonstrates how to use Files.readAllLines() for reading the entire file content and how to use streams for filtering
// and processing data efficiently.
