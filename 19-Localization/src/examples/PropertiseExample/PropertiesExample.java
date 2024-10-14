package examples.PropertiseExample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {
    public static void main(String[] args) {

        Properties myProps = new Properties();
        try {
            FileInputStream fis = new FileInputStream("ServerInfo.properties");
            myProps.load(fis);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Print Values
        System.out.println("Server: " + myProps.getProperty("hostName"));
        System.out.println("User: " + myProps.getProperty("userName"));
        System.out.println("Password: " + myProps.getProperty("password"));
    }
}

//This code is a basic example of how to use the Properties class to read configuration information from a file.
// The Properties class is a useful tool for storing and retrieving configuration settings in a Java application.
