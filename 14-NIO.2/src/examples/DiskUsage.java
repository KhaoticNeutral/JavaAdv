package examples;

import java.nio.file.*;
import java.io.IOException;

/**
 * Example utility that works like the df(1M) program to print out disk space
 * information
 */
public class DiskUsage {

    static final long K = 1024;

    static void printFileStore(FileStore store) throws IOException {
        long total = store.getTotalSpace() / K;
        long used = (store.getTotalSpace() - store.getUnallocatedSpace()) / K;
        long avail = store.getUsableSpace() / K;

        String s = store.toString();
        if (s.length() > 20) {
            System.out.println(s);
            s = "";
        }
        System.out.format("%-20s %12d %12d %12d\n", s, total, used, avail);
    }

    public static void main(String[] args) throws IOException {
        System.out.format("%-20s %12s %12s %12s\n", "Filesystem", "kbytes", "used", "avail");
        if (args.length == 0) {
            FileSystem fs = FileSystems.getDefault();
            for (FileStore store : fs.getFileStores()) {
                printFileStore(store);
            }
        } else {
            for (String file : args) {
                FileStore store = Files.getFileStore(Paths.get(file));
                printFileStore(store);
            }
        }
    }
}

//In summary, the DiskUsage class:
//
//Displays disk usage information for one or more file systems.
//It can be used to display information about all file systems or specific file systems specified as command-line arguments.
//It calculates and prints the total disk space, used space, and available space in kilobytes.
//This class demonstrates how to access and display disk usage information using Java's file system APIs.
