
import java.util.Random;

/**
 *
 * @author rwetz
 */
public class Client {

    /**
     * Returns the sum of the integers in given array.
     *
     * @param arr
     * @return
     */
    public static int example1(int[] arr) {
        int n = arr.length, total = 0;
        for (int j = 0; j < n; j++) // loop from 0 to n-1
        {
            total += arr[j];
        }
        return total;
    }

    /**
     * Returns the sum of the integers with even index in given array.
     *
     * @param arr
     * @return
     */
    public static int example2(int[] arr) {
        int n = arr.length, total = 0;
        for (int j = 0; j < n; j += 2) // note the increment of 2
        {
            total += arr[j];
        }
        return total;
    }

    /**
     * Returns the sum of the prefix sums of given array.
     *
     * @param arr
     * @return
     */
    public static int example3(int[] arr) {
        int n = arr.length, total = 0;
        for (int j = 0; j < n; j++) // loop from 0 to n-1
        {
            for (int k = 0; k <= j; k++) // loop from 0 to j
            {
                total += arr[j];
            }
        }
        return total;
    }

    /**
     * Returns the sum of the prefix sums of given array.
     *
     * @param arr
     * @return
     */
    public static int example4(int[] arr) {
        int n = arr.length, prefix = 0, total = 0;
        for (int j = 0; j < n; j++) {                             // loop from 0 to n-1
            prefix += arr[j];
            total += prefix;
        }
        return total;
    }

    /**
     * Returns the number of times second array stores sum of prefix sums from
     * first.
     *
     * @param first
     * @param second
     * @return
     */
    public static int example5(int[] first, int[] second) { // assume equal-length arrays
        int n = first.length, count = 0;
        for (int i = 0; i < n; i++) {                                // loop from 0 to n-1
            int total = 0;
            for (int j = 0; j < n; j++) // loop from 0 to n-1
            {
                for (int k = 0; k <= j; k++) // loop from 0 to j
                {
                    total += first[k];
                }
            }
            if (second[i] == total) {
                count++;
            }
        }
        return count;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        long[][] results = new long[14][6];

        int row = 0;

        System.out.println("+-----------+------------+------------+------------+------------+------------+");
        System.out.println("|     N     |  example1  |  example2  |  example3  |  example4  |  example5  |");
        System.out.println("+-----------+------------+------------+------------+------------+------------+");

        for (int n = 2; n < 30000; n *= 2) {

            int[] arr = new int[n];
            Random rand = new Random();

            for (int i = 0; i < n; i++) {
                arr[i] = rand.nextInt();
            }

            results[row][0] = n;

            long start1 = System.nanoTime();
            Client.example1(arr);
            long end1 = System.nanoTime();
            long etime1 = (end1 - start1);
            results[row][1] = etime1;

            long start2 = System.nanoTime();
            Client.example2(arr);
            long end2 = System.nanoTime();
            long etime2 = (end2 - start2);
            results[row][2] = etime2;

            long start3 = System.nanoTime();
            Client.example3(arr);
            long end3 = System.nanoTime();
            long etime3 = (end3 - start3);
            results[row][3] = etime3;

            long start4 = System.nanoTime();
            Client.example4(arr);
            long end4 = System.nanoTime();
            long etime4 = (end4 - start4);
            results[row][4] = etime4;

            long start5 = System.nanoTime();
            Client.example5(arr, arr);
            long end5 = System.nanoTime();
            long etime5 = (end5 - start5);
            results[row][5] = etime5;

            row++;
        }

        printTable(results);
    }

    /**
     *
     * @param data
     */
    private static void printTable(long[][] data) {

        int[] colWidths = new int[data[0].length];

        for (int col = 0; col < colWidths.length; col++) {
            for (int row = 0; row < data.length; row++) {
                String temp = String.format("%,d", data[row][col]);
                if (temp.length() > colWidths[col]) {
                    colWidths[col] = temp.length();
                }
            }
        }
        //format rowlines
        String rowLines = "+";
        for (int col = 0; col < colWidths.length; col++) {
            for (int i = 0; i < colWidths[col] + 4; i++) {
                rowLines += "-";
            }
            rowLines += "+";
        }

        //format data
        String[] formatters = new String[colWidths.length];
        for (int col = 0; col < colWidths.length; col++) {
            formatters[col] = "|  %," + colWidths[col] + "d  ";
        }

        //print data
        for (int row = 0; row < data.length; row++) {
            System.out.println(rowLines);
            for (int col = 0; col < colWidths.length; col++) {
                System.out.printf(formatters[col], data[row][col]);
            }
            System.out.println("|");
        }
        System.out.println(rowLines);
    }
}
