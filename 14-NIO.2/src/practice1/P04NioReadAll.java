package practice1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class P04NioReadAll {
    public static void main(String[] args) {

        Path file =  Paths.get("hamlet.txt");
        List<String> fileArr;

        try{
            fileArr = Files.readAllLines(file);

            System.out.println("\n=== Lord Count ===");
            long wordCount = fileArr.stream()
                    .flatMap(line -> Stream.of(line.split(" ")))
                    .filter(word -> word.contains("lord"))
                    .peek(word -> System.out.println(word))
                    .count();
            System.out.println("Word count: " + wordCount);

            System.out.println("\n=== Prison Count ===");
            wordCount = fileArr.stream()
                    .flatMap(line -> Stream.of(line.split(" ")))
                    .filter(word -> word.contains("prison"))
                    .peek(word -> System.out.println(word))
                    .count();
            System.out.println("Word count: " + wordCount);

        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}

//In summary, this code reads the "hamlet.txt" file, splits it into words, filters for words containing "lord" and "prison,"
// prints those words, and counts their occurrences. It demonstrates how to use streams for processing text data, splitting it into words,
// filtering, and counting elements efficiently.
