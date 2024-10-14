package examples.lambda;

import java.util.ArrayList;

public class A01RemoveIf {
    public static void main(String[] args) {
        ArrayList<Employee> eList =
                (ArrayList) Employee.createShortList();

        System.out.println("=== Starting List ===");
        eList.forEach(Employee::printSummary);

        eList.removeIf(e -> e.getState().equals("KS"));

        System.out.println("=== Ending List ===");
        eList.forEach(Employee::printSummary);

    }
}

//The code starts with a list of employees, prints their summaries, removes those from Kansas using removeIf, and then prints the remaining employees.