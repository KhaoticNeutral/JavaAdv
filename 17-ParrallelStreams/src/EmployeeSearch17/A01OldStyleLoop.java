package EmployeeSearch17;

import java.util.List;

public class A01OldStyleLoop {

    public static void main(String[] args) {

        List<Employee> eList = Employee.createShortList();

        double sum = 0;

        for(Employee e:eList){
            if(e.getState().equals("CO") &&
                    e.getRole().equals(Role.EXECUTIVE)){
                e.printSummary();
                sum += e.getSalary();
            }
        }

        System.out.printf("Total CO Executive Pay: $%,9.2f %n", sum);
    }

}

//this code snippet demonstrates a straightforward way to filter and process data from a list using a traditional loop.
// It iterates through each element, applies conditions, and performs actions based on the results. This approach is suitable for
// smaller datasets, but for larger datasets, alternative approaches like streams or parallel processing might be more efficient.
