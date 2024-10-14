package EmployeeSearch17;

import java.util.stream.IntStream;

public class A08Reduction {

    public static void main(String[] args) {

        int r1 = IntStream.rangeClosed(1, 5).parallel()
                .reduce(0, (a, b) -> a + b);

        System.out.println("Result: " + r1);

        int r2 = IntStream.rangeClosed(1, 5).parallel()
                .reduce(0, (sum, element) -> sum + element);


        System.out.println("Result: " + r2);

        int r3 = IntStream.rangeClosed(1, 8).parallel().reduce(0, (sum, element) -> sum + element);

        System.out.println("Result: " + r3);

    }

}

//The code in A08Reduction demonstrates the use of the reduce() operation on parallel streams of integers.
// It calculates the sum of numbers within a range using different approaches.