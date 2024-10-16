package EmployeeSearch17;

import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class A03CodeStream {

    public static void main(String[] args) {

        List<Employee> eList = Employee.createShortList();

        Stream<Employee> s1 = eList.stream();

        Stream<Employee> s2 = s1.filter(
                e -> e.getState().equals("CO"));

        Stream<Employee> s3 = s2.filter(
                e -> e.getRole().equals(Role.EXECUTIVE));
        Stream<Employee> s4 = s3.peek(e -> e.printSummary());
        DoubleStream s5 = s4.mapToDouble(e -> e.getSalary());
        double result = s5.sum();

        System.out.printf("Total CO Executive Pay: $%,9.2f %n", result);
    }

}

//While this approach is more verbose than the previous one, it might be considered clearer for beginners who are
// learning about stream operations. It explicitly shows how each intermediate operation transforms the stream and creates
// a new one. However, in practice, the chained approach in A02NewStyleLoop is generally preferred for its conciseness and readability.

