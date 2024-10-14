package examples;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.*;

public class CopyStream {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java CopyStream <URL> <file>");
            System.err.println("CopyStream copies a web page to a file.");
            System.exit(-1);
        }

        // Open the file to write to
        Path path = Paths.get(args[1]);
        URI u = URI.create(args[0]);
        try (InputStream in = u.toURL().openStream()) {
            Files.copy(in, path, REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println("Exception: " + e);
        }
    }
}

//In summary, the CopyStream class:
//
//Takes a URL and a file path as command-line arguments.
//Opens an input stream from the URL.
//Copies the data from the input stream to the target file.
//Handles potential IOException during the copy process.
//This class demonstrates how to download a web page from a URL and save it to a local file using Java's file I/O and network APIs.
