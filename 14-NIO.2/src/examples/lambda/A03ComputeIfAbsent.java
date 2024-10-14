package examples.lambda;

import java.util.HashMap;
import java.util.Map;

public class A03ComputeIfAbsent {

    private static final String placeHolder = "TBD";

    public static void main(String[] args) {

        Map<String, String> stMap = new HashMap<>();

        stMap.put("WY", "Cheyenne");
        stMap.put("SD", "Pierre");
        stMap.put("CO", "Denver");

        stMap.computeIfAbsent("AL", v -> placeHolder);

        System.out.println("=== Print Map ===");
        stMap.forEach(
                (k, v) -> System.out.println("Key: " + k + " "
                        + "Value: " + v));
    }
}

//The code initializes a map with several state-capital pairs, then uses computeIfAbsent() to add the key "AL" with a placeholder value "TBD"
// if it wasn't already in the map. The map's contents are then printed, showing all the key-value pairs.