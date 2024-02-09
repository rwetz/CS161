
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author rwetz
 * @version 2-07-2024
 */
public class Client {

    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        boolean quit = false;

        //loop until the user wants to quit
        while (!quit) {
            System.out.println("==========  Menu  ==========");
            System.out.println(" A)  Base-Two Logarithm ");
            System.out.println(" B)  Multiplication ");
            System.out.println(" C)  Find File ");
            System.out.println(" Q)  Quit ");
            System.out.print("Enter choice: ");
            String choice = keyScan.nextLine();

            switch (choice.toLowerCase()) {
                case "a" ->
                    callOptionA();
                case "b" ->
                    callOptionB();
                case "c" ->
                    callOptionC();
                case "q" ->
                    quit = true;
                default ->
                    System.out.println("Invalid Choice, Try Again\n");
            }
        }
    }

    /**
     * @version calling code for option A
     */
    public static void callOptionA() {
        System.out.println("callOptionA() method has been called.");
        Scanner keyScan = new Scanner(System.in);
        int n = 0;

        boolean tryAgain = true;
        while (tryAgain) {
            System.out.print("Enter a positive Integer: ");
            String answer = keyScan.nextLine();

            try {
                n = Integer.parseInt(answer);
                if (n < 0) {
                    throw new IllegalArgumentException("Parameter must be >= 0.");
                }
                tryAgain = false;
            } catch (NumberFormatException nfe) {
                System.out.println("You must enter an integer value. Try again.");
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage() + " Try again.");
            }
        }

        System.out.printf("optionA(%d) = %,d\n", n, OptionA(n));
    }

    /**
     * @version calling code for option B
     */
    public static void callOptionB() {
        System.out.println("callOptionB() method has been called.");
        Scanner keyScan = new Scanner(System.in);
        int n = 0;
        int v = 0;

        boolean tryAgain = true;
        while (tryAgain) {
            try {
                System.out.print("Enter a positive Integer: ");
                n = Integer.parseInt(keyScan.nextLine());

                System.out.print("Enter another positive Integer: ");
                v = Integer.parseInt(keyScan.nextLine());

                if (n < 0 || v < 0) {
                    throw new IllegalArgumentException("Parameters must be >= 0.");
                }
                tryAgain = false;
            } catch (NumberFormatException nfe) {
                System.out.println("You must enter an integer value. Try again.");
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage() + " Try again.");
            }
        }

        System.out.printf("optionB(%d, %d) = %,d\n", n, v, OptionB(n, v));
    }

    /**
     * @version calling code for option C
     */
    public static void callOptionC() {
        System.out.println("callOptionC() method has been called.");
        Scanner keyScan = new Scanner(System.in);
        boolean tryAgain = true;

        while (tryAgain) {
            try {
                System.out.print("Enter a path to look up: ");
                String path = keyScan.nextLine();
                File newPath = new File(path);

                if (!newPath.exists()) {
                    throw new FileNotFoundException("That file does NOT exist");
                }

                System.out.print("Enter a target file name: ");
                String target = keyScan.nextLine();

                OptionC(path, target);

                System.out.print("Calculate another option? (Y/N): ");
                String ynAnswer = keyScan.nextLine();
                if (ynAnswer.equalsIgnoreCase("N")) {
                    tryAgain = false;
                }
            } catch (FileNotFoundException fnfe) {
                System.out.println("Invalid file path, enter a new path");
            }
        }
    }

    /**
     *
     * @param i
     * @return recursive method for logarithm function
     */
    private static int OptionA(int i) {
        return Recursion.log(i);
    }

    /**
     *
     * @param i
     * @param t
     * @return @return recursive method for multiplication function
     */
    public static int OptionB(int i, int t) {
        return Recursion.multiplication(i, t);
    }

    /**
     *
     * @param path
     * @param filename
     * @version calls recursive method for file finding function
     */
    public static void OptionC(String path, String filename) {
        Recursion.find(path, filename);
    }
}
