package examples.lambda;

import java.util.stream.Stream;

public class A07StreamOf {
    public static void main(String[] args) {

        Stream.of("Monday", "Tuesday","Wedensday", "Thursday")
                .filter(s -> s.startsWith("T"))
                .forEach(s -> System.out.println("Matching Days: " + s));
    }
}

//The code creates a stream of day names, filters out those that start with the letter "T" ("Tuesday" and "Thursday"), and prints the matching days.
// This demonstrates how to use streams with filtering and processing in Java.
