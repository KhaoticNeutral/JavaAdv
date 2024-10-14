package examples.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class A08BufferedRead {
    public static void main(String[] args) {
        try(BufferedReader bReader =
                    new BufferedReader(new FileReader("tempest.txt"))){

            bReader.lines()
                    .forEach(line ->
                            System.out.println("Line: " + line));

        } catch (IOException e){
            System.out.println("Message: " + e.getMessage());
        }
    }
}

//This code opens a file named "tempest.txt" using BufferedReader, processes its content line by line using a stream,
// and prints each line with the prefix "Line: ". If an IOException occurs (e.g., file not found), the error message is displayed.
// The try-with-resources ensures proper resource management, automatically closing the BufferedReader.

