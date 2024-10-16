package EmployeeSearch17;

import java.util.List;
import java.util.Optional;

public class A07DetermineNot {

    public static void main(String[] args) {

        List<Employee> eList = Employee.createShortList();

        Optional<Employee> e1 = eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .sequential().findAny();

        Optional<Employee> e2 = eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .parallel().findAny();

        System.out.println("The same: " +
                e1.get().getEmail().equals(e2.get().getEmail()));

    }
}

//The code in A07DetermineNot compares the results of finding any Employee with the role Role.EXECUTIVE using both a sequential
// stream and a parallel stream.