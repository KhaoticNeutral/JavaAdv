package examples.lambda;

import java.util.HashMap;
import java.util.Map;

public class A04ComputeIfPresent {

    public static void main(String[] args) {

        Map<String, String> stMap = new HashMap<>();

        stMap.put("WY", "Cheyenne");
        stMap.put("SD", "Pierre");
        stMap.put("CO", "Denver");

        stMap.computeIfPresent("WY",
                (k,v) -> v + " (Verified " + k + ")");

        System.out.println("=== Print Map ===");
        stMap.forEach(
                (k, v) -> System.out.println("Key: " + k + " "
                        + "Value: " + v));

    }

}

//The code updates the value associated with the key "WY" using computeIfPresent(), appending a verification note to it. It prints the map,
// showing that only the "WY" key has an updated value, while the other key-value pairs remain the same.