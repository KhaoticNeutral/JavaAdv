package examples;

import java.util.Properties;

public class ScanTest {

    public static void main(String[] args) {
        Properties props = System.getProperties();
        props.list(System.out);
    }
}


