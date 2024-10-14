package practices.practice2;

import java.util.List;

public class CalcTest {

    public static void main(String[] args) {

        List<SalesTxn> tList = SalesTxn.createTxnList();

        // Print out Transaction Totals
        System.out.println("=== Transactions Totals ===");
        double t1 = tList.parallelStream()
                .filter(t -> t.getBuyerName().equals("Radio Hut"))
                .mapToDouble( t -> t.getTransactionTotal())
                .sum();

        System.out.printf("Radio Hut Total: $%,9.2f%n", t1);

        double t2 = tList.stream()
                .filter(t -> t.getBuyerName().equals("PriceCo"))
                .mapToDouble( t -> t.getTransactionTotal())
                .parallel()
                .sum();

        System.out.printf("PriceCo Total: $%,9.2f%n", t2);

        double t3 = tList.stream()
                .filter(t -> t.getBuyerName().equals("Best Deals"))
                .mapToDouble( t -> t.getTransactionTotal())
                .sequential()
                .sum();

        System.out.printf("Best Deals Total: $%,9.2f%n", t3);

    }
}

//This code demonstrates how to use Java streams to efficiently process a list of sales transactions,
// filter them based on buyer names, extract transaction totals, and calculate the sum of those totals for each buyer.
// The use of parallel streams for "Radio Hut" and "PriceCo" highlights the potential for performance optimization,
// while the sequential stream for "Best Deals" shows the flexibility of stream operations.