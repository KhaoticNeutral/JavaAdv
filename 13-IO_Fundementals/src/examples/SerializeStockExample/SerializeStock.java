package examples.SerializeStockExample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeStock {

    public static void main(String[] args) {
        // Determine if we have a file name for the Portfolio.
        // If no file name is provided as a command-line argument, print an error and exit the program.
        if (args.length < 1) {
            System.out.println("Specify the name of a file name for the Portfolio");
            System.exit(-1);
        }

        // Create a stock portfolio with three stocks.
        Stock s1 = new Stock("ORCL", 100, 32.50);  // Stock for Oracle, 100 shares at $32.50 each.
        Stock s2 = new Stock("APPL", 100, 245);    // Stock for Apple, 100 shares at $245 each.
        Stock s3 = new Stock("GOOG", 100, 54.67);  // Stock for Google, 100 shares at $54.67 each.

        Portfolio p = null;
        try {
            // Create a portfolio containing the three stocks.
            // If an exception is thrown during portfolio creation, print the error and exit.
            p = new Portfolio(s1, s2, s3);
        } catch (PortfolioException pe) {
            System.out.println("Exception creating Portfolio: " + pe);
            System.exit(-1);
        }

        // Print the portfolio before serialization.
        System.out.println("Before serialization:\n" + p + "\n");

        // Write out the Portfolio to a file specified in the command line argument.
        try (FileOutputStream fos = new FileOutputStream(args[0]);
             ObjectOutputStream out = new ObjectOutputStream(fos)) {
            // Serialize the Portfolio object and write it to the specified file.
            out.writeObject(p);
            System.out.println("Successfully wrote Portfolio as an object");
        } catch (IOException i) {
            // Handle any I/O exceptions that occur during writing.
            System.out.println("Exception writing out Portfolio: " + i);
        }

        // Read the Portfolio back in from the file to verify the serialization process.
        try (FileInputStream fis = new FileInputStream(args[0]);
             ObjectInputStream in = new ObjectInputStream(fis)) {
            // Deserialize the Portfolio object from the specified file.
            Portfolio newP = (Portfolio) in.readObject();
            // Print the deserialized Portfolio to confirm successful reading.
            System.out.println("Success: read Portfolio back in:\n" + newP);
        } catch (ClassNotFoundException | IOException i) {
            // Handle exceptions if the class is not found or an I/O error occurs during reading.
            System.out.println("Exception reading in Portfolio: " + i);
        }
    }
}

