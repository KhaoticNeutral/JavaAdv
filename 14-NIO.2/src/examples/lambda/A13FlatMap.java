package examples.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class A13FlatMap {

    public static void main(String[] args) {

        try(Stream<String> lines =
                    Files.lines(Paths.get("tempest.txt"))){

            long matches = lines
                    .flatMap(line -> Stream.of(line.split(" ")))
                    .filter(word -> word.contains("my"))
                    .peek(s -> System.out.println("Match: " + s))
                    .count();

            System.out.println("# of Matches: " + matches);
        } catch (IOException e){
            System.out.println("Message: " + e.getMessage());
        }
    }
}

//In summary, the code does the following:
//
//Reads lines from "tempest.txt".
//Splits each line into individual words.
//Filters the words to keep only those containing "my".
//(Optional) Prints each matching word.
//Counts the number of matching words.
//Prints the total count.
//This code demonstrates how flatMap can be used to flatten a stream of streams (in this case, a stream of lines into a stream of words),
// allowing for further processing on the individual elements (words).
