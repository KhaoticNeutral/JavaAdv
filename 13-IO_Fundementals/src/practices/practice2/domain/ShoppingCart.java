package practices.practice2.domain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingCart implements Serializable {

    // Serialization identifier to ensure compatibility during deserialization.
    private static final long serialVersionUID = 23L;

    // Unique identifier for the shopping cart.
    private int cartId;

    // List to store the items in the shopping cart.
    private ArrayList<Item> items;

    // Counter for the number of items in the cart.
    private int itemCount;

    // Total cost of items in the cart. Marked as 'transient' because it is recalculated rather than serialized.
    private transient double cartTotal;

    // Constructor to initialize the shopping cart with a customer ID.
    public ShoppingCart(int custID) {
        this.cartId = custID;         // Set the cart ID, typically associated with a customer ID.
        items = new ArrayList<>();    // Initialize the list of items in the cart.
        itemCount = 0;                // Initialize item count to zero.
        cartTotal = 0;                // Initialize the cart total to zero.
    }

    // Getter method for the total cost of the cart.
    public double getCartTotal() {
        return cartTotal;
    }

    // Getter method for the shopping cart ID.
    public int getCartID() {
        return cartId;
    }

    // Method to add an item to the shopping cart.
    public void addItem(Item i) {
        // Add the item to the cart and update the cart total.
        if (items.add(i)) {
            cartTotal += i.getCost(); // Add the cost of the new item to the total cost.
        }
    }

    // Method to get the number of items in the cart.
    public int getCartSize() {
        return items.size();
    }

    // Method to get the list of items in the cart.
    public List<Item> getItems() {
        return items;
    }

    // This method is called during deserialization to handle custom deserialization logic.
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject(); // Deserialize the non-transient fields (cartId, items, itemCount).

        // Recalculate the cart total because 'cartTotal' is transient and not serialized.
        if (cartTotal == 0 && (items.size() > 0)) {
            for (Item item : items) {
                cartTotal += item.getCost();
            }
        }

        // Deserialize a date object representing the serialization time.
        Date date = (Date) ois.readObject();
        System.out.println("Restored Shopping Cart from: " + DateFormat.getDateInstance().format(date));
    }

    // This method is called during serialization to handle custom serialization logic.
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject(); // Serialize the non-transient fields (cartId, items, itemCount).

        // Write the current date to the serialized data to keep track of when the cart was saved.
        oos.writeObject(new Date());
    }
}

