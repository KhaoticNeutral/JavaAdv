package examples;

import examples.util.Finder;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class FindFileTest {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: FindFileExample <start path> <search string>");
            System.exit(-1);
        }
        Path root = Paths.get(args[0]);
        if (!Files.isDirectory(root)) {
            System.out.println(args[0] + " must be a directory!");
            System.exit(-1);
        }

        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + args[1]);
        Finder finder = new Finder(root, matcher);
        try {
            Files.walkFileTree(root, finder);
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
        finder.done();
    }
}

//In summary, the FindFileTest class:
//
//Takes a starting directory and a search pattern as command-line arguments.
//Uses the Files.walkFileTree() method to traverse the directory tree.
//Uses a PathMatcher to match files and directories against the search pattern.
//Prints the names of all matching files and directories.
//Prints the total number of matches found.
//This class demonstrates how to use Java's file system APIs to search for files and directories based on a pattern.
