package EmployeeSearch17;

import java.util.List;

public class A02NewStyleLoop {

    public static void main(String[] args) {

        List<Employee> eList = Employee.createShortList();

        double result = eList.stream()
                .filter(e -> e.getState().equals("CO"))
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .peek(e -> e.printSummary())
                .mapToDouble(e -> e.getSalary())
                .sum();

        System.out.printf("Total CO Executive Pay: $%,9.2f %n", result);
    }

}

// demonstrates the power of Java streams for processing data efficiently and declaratively. It chains together
// operations like filtering, mapping, and reducing to achieve the desired result. Compared to the traditional loop-based approach,
// streams offer a more concise and readable way to express data transformations. They are particularly useful for larger datasets,
// as they can be optimized for parallel processing.

