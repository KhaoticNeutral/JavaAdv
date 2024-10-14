package practices.practice1;

import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class CalcTest {

    public static void main(String[] args) {

        List<SalesTxn> tList = SalesTxn.createTxnList();

        // Print out Transaction Totals
        System.out.println("=== Transactions Totals ===");

        Stream<SalesTxn> s1 = tList.stream();
        Stream<SalesTxn> s2 = s1.filter(
                t -> t.getBuyerName().equals("Radio Hut"));
        DoubleStream s3 = s2.mapToDouble(
                t -> t.getTransactionTotal());
        double t1 = s3.sum();

        System.out.printf("Radio Hut Total: $%,9.2f%n", t1);

    }
}

//The code uses a chain of stream operations to filter transactions by buyer, extract transaction totals,
// and calculate the sum of those totals. This demonstrates the power of Java streams for efficient data processing.

