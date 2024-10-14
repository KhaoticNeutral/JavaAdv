package examples.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class A06MapMerge {
    public static void main(String[] args) {
        Map<String, String> stMap = new HashMap<>();
        String message = " (Verified C State)";

        stMap.put("WY", "Cheyenne");
        stMap.put("SD", "Pierre");
        stMap.put("CO", "Denver");
        stMap.put("CA", "Sacramento");
        stMap.put("DE", "Dover");

        // Stream Key's
        List<String> cList = stMap.keySet().stream()
                .filter(s -> s.startsWith("C"))
                .collect(Collectors.toList());

        cList.stream().forEach((e) -> {
            stMap.merge(e, message, (s,m) -> s.concat(m));
        });

        stMap.forEach((k,v) ->
                System.out.println("Key: " + k + "  Value: " + v));
    }
}

//The code filters the map's keys for those starting with "C" and then updates the corresponding values using the merge() method.
// It concatenates a verification message (Verified C State) to the values of "CO" and "CA". Finally, the updated map is printed, showing the
// modified and unmodified key-value pairs.
