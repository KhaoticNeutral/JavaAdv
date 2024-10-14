package examples.SerializeStockExample;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Random;

public class Stock implements Serializable {

    // Serialization identifier for version control.
    private static final long serialVersionUID = 100L;

    // The stock symbol, such as "ORCL", "APPL", etc.
    private String symbol;

    // The number of shares owned.
    private int shares;

    // The price at which the shares were purchased.
    private double purchasePrice;

    // The current price of the stock.
    // Marked as 'transient' so it won't be serialized (i.e., won't be saved when the object is serialized).
    private transient double currPrice;

    // Constructor to initialize the stock's symbol, number of shares, and purchase price.
    public Stock(String symbol, int shares, double purchasePrice) {
        this.symbol = symbol;
        this.shares = shares;
        this.purchasePrice = purchasePrice;
        setStockPrice(); // Sets a random current price to simulate market value.
    }

    // This method is called during deserialization.
    // It reads the non-transient data and initializes any transient fields.
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject(); // Deserialize the non-transient fields.
        // Set a random current price for the stock after deserialization.
        setStockPrice();
    }

    // Getter for the stock symbol.
    public String getSymbol() {
        return symbol;
    }

    // Calculates the total value of the stock by multiplying shares by the current price.
    public double getValue() {
        return shares * currPrice;
    }

    // Sets a random value for the current stock price to simulate changes in the market.
    // Normally, this value would be fetched from a live data feed.
    private void setStockPrice() {
        Random r = new Random(); // Create a new Random object to generate random numbers.
        double rVal = r.nextDouble(); // Generate a random value between 0.0 and 1.0.
        double p = 0;

        // Use the purchase price if current price is zero; otherwise use the current price.
        if (currPrice == 0) {
            p = purchasePrice;
        } else {
            p = currPrice;
        }

        // Calculate the new price based on the random value.
        // If the random value is less than 0.5, decrease the price by up to $10.
        // Otherwise, increase the price by up to $10.
        if (rVal < 0.5) {
            currPrice = p + (-10 * rVal);
        } else {
            currPrice = p + (10 * rVal);
        }
    }

    // Overrides the default toString() method to provide a string representation of the stock.
    @Override
    public String toString() {
        double value = getValue(); // Calculate the total value of the stock.
        // Format the stock information into a human-readable string.
        return "Stock:  " + symbol + "\n"
                + "Shares: " + shares + " @ " + NumberFormat.getCurrencyInstance().format(purchasePrice) + "\n"
                + "Curr $: " + NumberFormat.getCurrencyInstance().format(currPrice) + "\n"
                + "Value:  " + NumberFormat.getCurrencyInstance().format(value) + "\n";
    }
}

