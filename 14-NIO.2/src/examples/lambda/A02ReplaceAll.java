package examples.lambda;

import java.time.LocalDate;
import java.util.ArrayList;

public class A02ReplaceAll {
    public static void main(String[] args) {
        ArrayList<Employee> eList =
                (ArrayList) Employee.createShortList();

        System.out.println("=== Starting List ===");
        eList.forEach(Employee::printSummary);

        eList.replaceAll(e ->
                new Employee.Builder()
                        .givenName("Bob")
                        .surName("Baker")
                        .age(23)
                        .gender(Gender.MALE)
                        .role(Role.STAFF)
                        .dept("Eng")
                        .startDate(LocalDate.of(2013, 1, 10))
                        .salary(40000)
                        .email("bob.baker@example.com")
                        .phoneNumber("201-121-4678")
                        .address("44 4th St")
                        .city("Smallville")
                        .state("KS")
                        .code("12333")
                        .build()
        );

        System.out.println("\n=== Ending List ===");
        eList.forEach(Employee::printSummary);

    }
}

//The code replaces every employee in the list with a new Employee object using the replaceAll() method.
// After the replacement, all employees in the list are identical, with the hardcoded details of "Bob Baker"