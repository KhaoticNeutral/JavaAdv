package examples.lambda;

import java.util.HashMap;
import java.util.Map;

public class A05MapStream {

    public static void main(String[] args) {

        Map<String, String> stMap = new HashMap<>();

        stMap.put("WY", "Cheyenne");
        stMap.put("SD", "Pierre");
        stMap.put("CO", "Denver");
        stMap.put("CA", "Sacramento");
        stMap.put("DE", "Dover");

        // Stream Key's
        stMap.keySet().stream()
                .filter(s -> s.startsWith("C"))
                .forEach(s -> System.out.println("State:  " + s));

        // Stream Values
        stMap.values().stream()
                .filter(s -> s.startsWith("D"))
                .forEach(s -> System.out.println("City: " + s));
    }

}

//The code uses Java Streams to filter and print specific keys and values from a Map. It filters the keys that start with "C"
// (printing "CO" and "CA") and filters the values that start with "D" (printing "Denver" and "Dover").
// This demonstrates how to work with Map keys and values using streams for filtering and processing.
