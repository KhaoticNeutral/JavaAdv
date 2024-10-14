package practices.practice2.domain;

import java.io.Serializable;

public class Item implements Serializable {

    // Serialization identifier to ensure class compatibility during deserialization.
    private static final long serialVersionUID = 42L;

    // Unique identifier for the item.
    private int id;

    // Description of the item.
    private String description;

    // Cost of the item.
    private double cost;

    // Constructor to initialize the fields of the Item object.
    public Item(int id, String description, double cost) {
        this.id = id;                      // Set the item ID.
        this.description = description;    // Set the item description.
        this.cost = cost;                  // Set the item cost.
    }

    // Getter method for the cost of the item.
    public double getCost() {
        return cost;
    }

    // Setter method to update the cost of the item.
    public void setCost(double cost) {
        this.cost = cost;
    }

    // Getter method for the description of the item.
    public String getDescription() {
        return description;
    }

    // Setter method to update the description of the item.
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter method for the unique ID of the item.
    public int getId() {
        return id;
    }

    // Setter method to update the ID of the item.
    public void setId(int id) {
        this.id = id;
    }

    // Override the default toString() method to provide a string representation of the Item object.
    @Override
    public String toString() {
        return ("Item ID: " + id + " Description: " + description + " Cost: " + cost);
    }
}
