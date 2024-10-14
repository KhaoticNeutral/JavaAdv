package EmployeeSearch17;

import java.util.List;

public class A06Determine {

    public static void main(String[] args) {

        List<Employee> eList = Employee.createShortList();

        double r1 = eList.stream()
                .filter(e -> e.getState().equals("CO"))
                .mapToDouble(Employee::getSalary)
                .sequential().sum();

        double r2 = eList.stream()
                .filter(e -> e.getState().equals("CO"))
                .mapToDouble(Employee::getSalary)
                .parallel().sum();

        System.out.println("The same: " + (r1 == r2));
    }
}

//The code in A06Determine compares the results of calculating the sum of salaries for Colorado employees using both a sequential
// stream and a parallel stream. Since the operations involved (filtering, mapping, and summing) are deterministic and the order of
// elements doesn't affect the sum, the code is likely to output "The same: true", indicating that both approaches produce the same result.
