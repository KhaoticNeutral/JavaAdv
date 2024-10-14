package practices.practice2.test;

import practices.practice2.domain.ShoppingCart;
import practices.practice2.domain.Item;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.text.NumberFormat;
import java.util.List;

public class DeserializeTest {

    public static void main(String[] args) {
        // Define the directory where the serialized shopping cart files are located.
        String directory = "practices/practice2/domain/ShoppingCart";
        String cartId = null;

        // Prompt the user to enter the ID of the shopping cart file to deserialize or 'q' to exit.
        System.out.println("Enter the ID of the cart file to deserialize or q to exit.");

        // Wrap the System.in InputStream with a BufferedReader to read each line from the keyboard.
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            // Read the cart ID from the console.
            cartId = in.readLine();
            if (cartId.equals("q")) {
                // Exit the program if the user enters 'q'.
                System.exit(0);
            }
        } catch (IOException e) { // Catch any IO exceptions that may occur while reading input.
            System.out.println("Exception: " + e);
            System.exit(-1);
        }

        // Construct the full path to the cart file using the directory and the cart ID provided by the user.
        String cartFile = directory + "cart" + cartId + ".ser";

        // Attempt to open the file and deserialize it into a ShoppingCart object.
        ShoppingCart cart = null;
        try (FileInputStream fis = new FileInputStream(cartFile);
             ObjectInputStream in = new ObjectInputStream(fis)) {
            // Read the serialized object from the file and cast it to a ShoppingCart.
            cart = (ShoppingCart) in.readObject();
        } catch (ClassNotFoundException | IOException e) {
            // Handle exceptions if the class is not found or if there is an I/O error during deserialization.
            System.out.println("Exception deserializing " + cartFile + ": " + e);
            System.exit(-1);
        }

        // If successful, print the details of the deserialized ShoppingCart object.
        System.out.println("Successfully deserialized shopping cart with ID: " + cart.getCartID());
        System.out.println("Shopping cart contains: ");

        // Get the list of items in the shopping cart.
        List<Item> cartContents = cart.getItems();

        // Loop through each item in the cart and print its details.
        for (Item item : cartContents) {
            System.out.println(item);
        }

        // Print the total cost of the shopping cart in a formatted manner (currency).
        System.out.println("Shopping cart total: "
                + NumberFormat.getCurrencyInstance().format(cart.getCartTotal()));
    }
}

