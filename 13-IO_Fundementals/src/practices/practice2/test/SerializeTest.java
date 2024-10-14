package practices.practice2.test;

import practices.practice2.domain.Item;
import practices.practice2.domain.ShoppingCart;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.text.NumberFormat;
import java.lang.String;

public class SerializeTest {

    public static void main(String[] args) {
        // Define the directory where the serialized shopping cart files will be saved.
        String directory = "/home/oracle/labs/13-IO_Fundamentals/practices/practice2/SerializeShoppingCart";
        String cartId = null;
        ShoppingCart cart = null;

        // Prompt the user to enter the ID of the cart to create and serialize, or 'q' to exit.
        System.out.println("Enter the ID of the cart file to create and serialize or q to exit.");

        // Wrap the System.in InputStream with a BufferedReader to read each line from the keyboard.
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            // Read the cart ID from the console.
            cartId = in.readLine();
            if (cartId.equals("q")) {
                // Exit the program if the user enters 'q'.
                System.exit(0);
            }

            // Create a new ShoppingCart object with the provided ID.
            cart = new ShoppingCart(Integer.parseInt(cartId));
        } catch (IOException | NumberFormatException e) { // Handle any IO exceptions or invalid number format.
            System.out.println("Exception: " + e);
            System.exit(-1);
        }

        // Add some items to the shopping cart.
        cart.addItem(new Item(101, "Duke Plastic Circular Flying Disc", 10.95));
        cart.addItem(new Item(123, "Duke Soccer Pro Soccer ball", 29.95));
        cart.addItem(new Item(45, "Duke \"The Edge\" Tennis Balls - 12-Ball Bag", 17.49));

        // Print details about the cart.
        System.out.println("Shopping cart " + cartId + " contains " + cart.getCartSize() + " items");
        System.out.println("Shopping cart total: "
                + NumberFormat.getCurrencyInstance().format(cart.getCartTotal()));

        // Construct the path to the cart file where it will be serialized.
        String cartFile = directory + "cart" + cart.getCartID() + ".ser";

        // Serialize the shopping cart to the specified file.
        try (FileOutputStream fos = new FileOutputStream(cartFile);
             ObjectOutputStream o = new ObjectOutputStream(fos)) {
            // Write the ShoppingCart object to the file.
            o.writeObject(cart);
        } catch (IOException e) { // Handle any IO exceptions that may occur during serialization.
            System.out.println("Exception serializing " + cartFile + ": " + e);
            System.exit(-1);
        }

        // Print a success message if serialization was successful.
        System.out.println("Successfully serialized shopping cart with ID: " + cart.getCartID());
    }
}
