package EmployeeSearch17;

import java.util.List;

public class A04Parallel {

    public static void main(String[] args) {

        List<Employee> eList = Employee.createShortList();

        double result = eList.parallelStream()
                .filter(e -> e.getState().equals("CO"))
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .peek(e -> e.printSummary())
                .mapToDouble(e -> e.getSalary())
                .sum();

        System.out.printf("Total CO Executive Pay: $%,9.2f %n", result);

        System.out.println("\n");

        // Call parallel from pipeline
        result = eList.stream()
                .filter(e -> e.getState().equals("CO"))
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .peek(e -> e.printSummary())
                .mapToDouble(e -> e.getSalary())
                .parallel()
                .sum();

        System.out.printf("Total CO Executive Pay: $%,9.2f %n", result);

        System.out.println("\n");

        // Call sequential from pipeline
        result = eList.stream()
                .filter(e -> e.getState().equals("CO"))
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .peek(e -> e.printSummary())
                .mapToDouble(e -> e.getSalary())
                .sequential()
                .sum();

        System.out.printf("Total CO Executive Pay: $%,9.2f %n", result);
    }
}

//shows different ways to use parallel streams in Java, but it's crucial to understand the implications of parallelism and
// to ensure that your code is thread-safe and optimized for performance.
