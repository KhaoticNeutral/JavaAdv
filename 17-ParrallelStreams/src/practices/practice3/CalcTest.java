package practices.practice3;

import java.util.List;

public class CalcTest {

    public static void main(String[] args) {

        List<SalesTxn> tList = SalesTxn.createTxnList();

        // Print out Transaction Totals
        System.out.println("=== Transactions Totals ===");
        double t2 = tList.stream()
                .filter(t -> t.getBuyerName().equals("PriceCo"))
                .mapToDouble( t -> t.getTransactionTotal())
                .parallel()
                .reduce(0, (sum, e) -> sum + e);

        System.out.printf("%nPriceCo Total: $%,9.2f%n", t2);

        int c2 = tList.stream()
                .filter(t -> t.getBuyerName().equals("PriceCo"))
                .mapToInt(t -> 1)
                .parallel()
                .reduce(0, (sum, e) -> sum + e);

        System.out.printf("PriceCo Transactions: %,6d%n", c2);

    }
}

//This code demonstrates how to use Java streams to efficiently process a list of sales transactions,
// filter them based on buyer names, calculate the sum of transaction totals, and count the number of transactions
// for a specific buyer. The use of parallel streams for both calculations highlights the potential for performance optimization.
