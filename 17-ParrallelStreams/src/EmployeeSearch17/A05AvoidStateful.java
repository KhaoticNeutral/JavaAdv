package EmployeeSearch17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class A05AvoidStateful {

    public static void main(String[] args) {

        List<Employee> eList = Employee.createShortList();
        List<Employee> newList01 = new ArrayList<>();
        List<Employee> newList02 = new ArrayList<>();

        eList.parallelStream() // Not Parallel. Bad.
                .filter(e -> e.getDept().equals("Eng"))
                .forEach(e -> newList01.add(e));

        newList02 = eList.parallelStream() // Good Parallel
                .filter(e -> e.getDept().equals("Eng"))
                .collect(Collectors.toList());

    }
}

//When working with parallel streams, it's essential to avoid stateful operations that modify shared data.
// Use methods like collect with appropriate collectors to ensure thread-safe and predictable results.

