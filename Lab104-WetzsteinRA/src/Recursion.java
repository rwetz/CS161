
import java.io.File;

/**
 *
 * @author rwetz
 */
public class Recursion {

    public Recursion() {

    }

    /**
     *
     * @param n
     * @return the integer part of the base-two logarithm of n using only
     * addition and integer division
     */
    public static int log(int n) {
        if (n <= 1) {
            return 0;
        }
        return 1 + log(n / 2);
    }

    /**
     *
     * @param m
     * @param n
     * @return the product of two positive integers, m and n, using only
     * addition and subtraction
     */
    public static int multiplication(int m, int n) {
        //base case
        if (m == 0 || n == 0) {
            return 0;
        }
        //base case
        if (m == 1) {
            return n;
        }
        //base case
        if (n == 1) {
            return m;
        }

        //recursive case if m and n are both positive integers greater than 1
        return n + multiplication(m - 1, n);
    }

    /**
     * 
     * @param path
     * @param filename 
     * @version void method that finds a file in a file system
     */
    public static void find(String path, String filename) {
        File f = new File(path); // Use the provided path instead of hardcoding a specific file path
        // Base case: Check if the file exists and if it is a file (not a directory)
        if (!f.exists()) {
            System.out.println("File does not exist: " + path);
            return; // Exit the method if the file does not exist
        }
        if (f.isFile()) {
            if (f.getName().equals(filename)) {
                System.out.println("File found: " + path);
            }
            return; // Exit the method if the file is found
        }
        // Recursive case: If it's a directory, search recursively inside it
        if (f.isDirectory()) {
            File[] fileArray = f.listFiles();
            if (fileArray != null) { // Ensure the file array is not null
                for (File child : fileArray) {
                    find(child.getAbsolutePath(), filename); // Recursively search inside each child
                }
            }
        }
    }

}
