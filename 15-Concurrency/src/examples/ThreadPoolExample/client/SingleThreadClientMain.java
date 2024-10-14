package examples.ThreadPoolExample.client;

import java.io.IOException;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SingleThreadClientMain {

    public static void main(String[] args) {
        String host = "localhost";
        for (int port = 10000; port < 10010; port++) {
            RequestResponse lookup = new RequestResponse(host, port);
            try (Socket sock = new Socket(lookup.host, lookup.port);
                 Scanner scanner = new Scanner(sock.getInputStream());) {
                lookup.response = scanner.next();
                System.out.println(lookup.host + ":" + lookup.port + " " + lookup.response);
            } catch (NoSuchElementException | IOException ex) {
                System.out.println("Error talking to " + host + ":" + port);
            }
        }
    }
}

//this code sequentially connects to a series of network clients on different ports, retrieves a response from each, and prints the results.
// It's a simple example of how to interact with multiple network clients using a single thread. However, it's important to note that this approach
// can be inefficient for large numbers of clients, as it will block the main thread while waiting for each connection to complete.