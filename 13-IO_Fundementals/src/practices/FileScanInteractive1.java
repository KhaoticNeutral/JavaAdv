package practices;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileScanInteractive1 {

    // Method to count the number of occurrences of a given word in a file.
    public int countTokens(String file, String search) throws IOException {
        int instanceCount = 0;

        // Use a try-with-resources to handle file resources safely.
        // Chain a FileReader to a BufferedReader to a Scanner for efficient reading.
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr);
             Scanner s = new Scanner(br)) {

            // Set the delimiter for the Scanner to match non-word characters (i.e., split by whitespace, punctuation, etc.).
            s.useDelimiter("\\W");

            // Iterate through each token (word) in the file.
            while (s.hasNext()) {
                // Check if the current token matches the search string (case-insensitive).
                if (search.equalsIgnoreCase(s.next().trim())) {
                    instanceCount++; // Increment the counter if a match is found.
                }
            }
        } // The try-with-resources statement ensures that the FileReader, BufferedReader, and Scanner are closed automatically.

        // Return the total count of occurrences of the search string in the file.
        return instanceCount;
    }

    // Main method: Entry point of the program.
    public static void main(String[] args) {
        // Check if a file name has been provided as a command-line argument.
        if (args.length < 1) {
            System.out.println("Usage: java ScanFileInteractive <file to search>");
            System.exit(-1);
        }

        // Save the file name from the command line argument.
        String file = args[0];

        // Create an instance of the FileScanInteractive1 class to access non-static methods.
        FileScanInteractive1 scan = new FileScanInteractive1();

        // Use a BufferedReader to read input from the console (user input).
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String search = ""; // Variable to hold the search string input by the user.

            System.out.println("Searching through the file: " + file);

            // Infinite loop to continuously prompt the user for a search string.
            while (true) {
                System.out.print("Enter the search string or q to exit: ");

                // Read the search string from the user.
                search = in.readLine().trim();

                // Exit the loop if the user enters 'q'.
                if (search.equalsIgnoreCase("q")) {
                    break;
                }

                // Call the countTokens method to count occurrences of the search string in the file.
                int count = scan.countTokens(file, search);

                // Display the number of times the search string appears in the file.
                System.out.println("The word \"" + search + "\" appears "
                        + count + " times in the file.");
            }
        } catch (IOException e) { // Handle any IO exceptions that may occur.
            System.out.println("Exception: " + e);
            System.exit(-1);
        }
    }
}

