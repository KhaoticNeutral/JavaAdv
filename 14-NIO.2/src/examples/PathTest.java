package examples;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

    public static void main(String[] args) {
        Path p1 = Paths.get(args[0]);
        System.out.format("getFileName: %s%n", p1.getFileName());
        System.out.format("getParent: %s%n", p1.getParent());
        System.out.format("getNameCount: %d%n", p1.getNameCount());
        System.out.format("getRoot: %s%n", p1.getRoot());
        System.out.format("isAbsolute: %b%n", p1.isAbsolute());
        System.out.format("toAbsolutePath: %s%n", p1.toAbsolutePath());
        System.out.format("toURI: %s%n", p1.toUri());
    }
}

//In summary, the PathTest class demonstrates how to use the following methods of the Path class:
//
//getFileName(): Retrieves the file or directory name.
//getParent(): Retrieves the parent directory.
//getNameCount(): Counts the path components.
//getRoot(): Retrieves the root path component.
//isAbsolute(): Checks if the path is absolute.
//toAbsolutePath(): Converts the path to its absolute representation.
//toURI(): Converts the path to a URI.
//This class provides a basic example of how to work with file and directory paths in Java using the Path class.