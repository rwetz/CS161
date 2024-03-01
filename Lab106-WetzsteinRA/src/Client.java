
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author rwetz
 * @version 2-19-2024
 */
public class Client {

    private static String path;

    private static String startDir;

    private static ArrayBag<File> ab;

    private static int rowsProcessed = 0;

    private static int errorLines = 0;

    private static int filesProcessed = 0;

    /**
     *
     * @param percent
     * @return
     */
    private static String formatPercent(String percent) {
        double val = Double.parseDouble(percent);
        val /= 100;
        return Double.toString(val);
    }

    /**
     *
     * @param date
     * @return
     */
    private static String formatDate(String date) {
        String[] parts = date.split("/");
        String month = parts[0];
        String day = parts[1];
        String year = parts[2];
        return year + month + day;
    }

    /**
     *
     * @param filename
     * @return
     */
    private static PrintWriter createPrintWriter(String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename, false);
            return new PrintWriter(fos);
        } catch (FileNotFoundException fnfe) {
            // Print a warning or log the exception
            System.err.println("File not found: " + filename);
            return null;
        }
    }

    /**
     *
     * @param f
     * @param pw
     * @param errors
     * @throws FileNotFoundException
     */
    private static void processBonds(File f, PrintWriter pw, PrintWriter errors) throws FileNotFoundException {
        Scanner scan = new Scanner(f);

        String header = scan.nextLine();
        String[] parts = header.split("/");
        String st = parts[0];
        String cs = parts[1];
        String re = parts[2];
        String id = parts[3];
        String md = parts[4];
        String hr = parts[5];
        String ir = parts[6];
        String el = parts[7];
        header = st + cs + re + id + md + hr + ir + el;

        scan.nextLine(); // read data
        int lineNumber = 0;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String lineToPrint = "";
            Scanner lineScan = new Scanner(line);
            boolean errorLine = false;

            //sec term
            if (!lineScan.hasNext() || errorLine) {
                errorLine = true;
            } else {
                String secTerm = lineScan.next();
                switch (secTerm) {
                    case "4-Week", "8-Week", "13-Week", "17-Week", "26-Week", "52-Week" ->
                        lineToPrint += secTerm + ",";
                    default ->
                        errorLine = true;
                }
            }

            //cusip
            if (!lineScan.hasNext() || errorLine) {
                errorLine = true;
            } else {
                String CUSIP = lineScan.next();
                if (CUSIP.length() == 9) {
                    lineToPrint += CUSIP + ",";
                } else {
                    errorLine = true;
                }
            }

            //reopenning
            if (!lineScan.hasNext() || errorLine) {
                errorLine = true;
            } else {
                String reopenVal = lineScan.next();
                switch (reopenVal) {
                    case "yes" ->
                        lineToPrint += reopenVal + ",";
                    case "no" ->
                        lineToPrint += reopenVal + ",";
                    default ->
                        errorLine = true;
                }
            }
            //issue date
            if (!lineScan.hasNext() || errorLine) { //for high rate
                errorLine = true;
            } else {
                String issueDate = lineScan.next();
                if (issueDate.length() == 10) {
                    lineToPrint += formatDate(issueDate) + ",";
                } else {
                    errorLine = true;
                }
            }

            //maturity date
            if (!lineScan.hasNext() || errorLine) { //for high rate
                errorLine = true;
            } else {
                String maturityDate = lineScan.next();
                if (maturityDate.length() == 10) {
                    lineToPrint += formatDate(maturityDate) + ",";
                } else {
                    errorLine = true;
                }
            }
            //highrate
            if (!lineScan.hasNext() || errorLine) {
                errorLine = true;
            } else {
                String highRate = lineScan.next();
                if (highRate.charAt(highRate.length() - 1) == '%') { // if it is percent
                    lineToPrint += formatPercent(highRate) + ",";
                } else {
                    errorLine = true;
                }
            }
            //investmentrate
            if (!lineScan.hasNext() || errorLine) {
                errorLine = true;
            } else {
                String investmentRate = lineScan.next();
                if (investmentRate.charAt(investmentRate.length() - 1) == '%') { // if it is percent
                    lineToPrint += formatPercent(investmentRate) + ",";
                } else {
                    errorLine = true;
                }
            }

            //errorline
            if (errorLine) {
                errors.printf("%s,%d,%s", f.getAbsolutePath(), lineNumber, line);
                errorLines++;
            } else {
                pw.println(lineToPrint);
            }
            lineNumber++;
            rowsProcessed++;
        }
        filesProcessed++;
    }

    /**
     *
     * @param f
     * @param pw
     * @param errors
     * @throws FileNotFoundException
     */
    private static void processTBills(File f, PrintWriter pw, PrintWriter errors) throws FileNotFoundException {
        Scanner scan = new Scanner(f);

        String header = scan.nextLine();
        String[] parts = header.split("/");
        String st = parts[0];
        String cs = parts[1];
        String id = parts[2];
        String md = parts[3];
        String hr = parts[4];
        String ir = parts[5];
        String el = parts[6];
        header = st + cs + id + md + hr + ir + el;

        scan.nextLine(); // read data
        int lineNumber = 0;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String lineToPrint = "";
            Scanner lineScan = new Scanner(line);
            boolean errorLine = false;

            //sec term
            if (!lineScan.hasNext() || errorLine) {
                errorLine = true;
            } else {
                String secTerm = lineScan.next();
                switch (secTerm) {
                    case "4-Week", "8-Week", "13-Week", "17-Week", "26-Week", "52-Week" ->
                        lineToPrint += secTerm + ",";
                    default ->
                        errorLine = true;
                }
            }

            //cusip
            if (!lineScan.hasNext() || errorLine) {
                errorLine = true;
            } else {
                String CUSIP = lineScan.next();
                if (CUSIP.length() == 9) {
                    lineToPrint += CUSIP + ",";
                } else {
                    errorLine = true;
                }
            }

            //issue date
            if (!lineScan.hasNext() || errorLine) { //for high rate
                errorLine = true;
            } else {
                String issueDate = lineScan.next();
                if (issueDate.length() == 10) {
                    lineToPrint += formatDate(issueDate) + ",";
                } else {
                    errorLine = true;
                }
            }

            //maturity date
            if (!lineScan.hasNext() || errorLine) { //for high rate
                errorLine = true;
            } else {
                String maturityDate = lineScan.next();
                if (maturityDate.length() == 10) {
                    lineToPrint += formatDate(maturityDate) + ",";
                } else {
                    errorLine = true;
                }
            }
            //highrate
            if (!lineScan.hasNext() || errorLine) {
                errorLine = true;
            } else {
                String highRate = lineScan.next();
                if (highRate.charAt(highRate.length() - 1) == '%') { // if it is percent
                    lineToPrint += formatPercent(highRate) + ",";
                } else {
                    errorLine = true;
                }
            }
            //investmentrate
            if (!lineScan.hasNext() || errorLine) {
                errorLine = true;
            } else {
                String investmentRate = lineScan.next();
                if (investmentRate.charAt(investmentRate.length() - 1) == '%') { // if it is percent
                    lineToPrint += formatPercent(investmentRate) + ",";
                } else {
                    errorLine = true;
                }
            }

            //errorline
            if (errorLine) {
                errors.printf("%s,%d,%s", f.getAbsolutePath(), lineNumber, line);
                errorLines++;
            } else {
                pw.println(lineToPrint);
            }
            lineNumber++;
            rowsProcessed++;
        }
        filesProcessed++;
    }

    /**
     *
     * @param f
     * @param pw
     * @param errors
     * @throws FileNotFoundException
     */
    private static void processNotes(File f, PrintWriter pw, PrintWriter errors) throws FileNotFoundException {
        Scanner scan = new Scanner(f);

        String header = scan.nextLine();
        String[] parts = header.split("/");
        String st = parts[0];
        String cs = parts[1];
        String re = parts[2];
        String id = parts[3];
        String md = parts[4];
        String hr = parts[5];
        String ir = parts[6];
        String el = parts[7];
        header = st + cs + re + id + md + hr + ir + el;

        scan.nextLine();
        int lineNumber = 0;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String lineToPrint = "";
            Scanner lineScan = new Scanner(line);
            boolean errorLine = false;

            //sec term
            if (!lineScan.hasNext() || errorLine) {
                errorLine = true;
            } else {
                String secTerm = lineScan.next();
                switch (secTerm) {
                    case "4-Week", "8-Week", "13-Week", "17-Week", "26-Week", "52-Week" ->
                        lineToPrint += secTerm + ",";
                    default ->
                        errorLine = true;
                }
            }

            //cusip
            if (!lineScan.hasNext() || errorLine) {
                errorLine = true;
            } else {
                String CUSIP = lineScan.next();
                if (CUSIP.length() == 9) {
                    lineToPrint += CUSIP + ",";
                } else {
                    errorLine = true;
                }
            }

            //reopenning
            if (!lineScan.hasNext() || errorLine) {
                errorLine = true;
            } else {
                String reopenVal = lineScan.next();
                switch (reopenVal) {
                    case "yes" ->
                        lineToPrint += reopenVal + ",";
                    case "no" ->
                        lineToPrint += reopenVal + ",";
                    default ->
                        errorLine = true;
                }
            }

            //issue date
            if (!lineScan.hasNext() || errorLine) { //for high rate
                errorLine = true;
            } else {
                String issueDate = lineScan.next();
                if (issueDate.length() == 10) {
                    lineToPrint += formatDate(issueDate) + ",";
                } else {
                    errorLine = true;
                }
            }

            //maturity date
            if (!lineScan.hasNext() || errorLine) { //for high rate
                errorLine = true;
            } else {
                String maturityDate = lineScan.next();
                if (maturityDate.length() == 10) {
                    lineToPrint += formatDate(maturityDate) + ",";
                } else {
                    errorLine = true;
                }
            }

            //highrate
            if (!lineScan.hasNext() || errorLine) {
                errorLine = true;
            } else {
                String highRate = lineScan.next();
                if (highRate.charAt(highRate.length() - 1) == '%') { // if it is percent
                    lineToPrint += formatPercent(highRate) + ",";
                } else {
                    errorLine = true;
                }
            }

            //investmentrate
            if (!lineScan.hasNext() || errorLine) {
                errorLine = true;
            } else {
                String investmentRate = lineScan.next();
                if (investmentRate.charAt(investmentRate.length() - 1) == '%') { // if it is percent
                    lineToPrint += formatPercent(investmentRate) + ",";
                } else {
                    errorLine = true;
                }
            }

            //errorline
            if (errorLine) {
                errors.printf("%s,%d,%s", f.getAbsolutePath(), lineNumber, line);
                errorLines++;
            } else {
                pw.println(lineToPrint);
            }
            lineNumber++;
            rowsProcessed++;
        }
        filesProcessed++;
    }

    /**
     *
     * @param path
     * @throws FileNotFoundException
     */
    private static void searchFiles(String path) throws FileNotFoundException {
        File temp = new File(path);
        if (temp.isFile() && temp.getName().contains("T-Bills")
                || temp.getName().contains("Notes")
                || temp.getName().contains("Bonds")) {
            ab.add(temp);
        }
    }

    /**
     *
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        //
        Scanner scan = new Scanner(System.in);

        //
        System.out.print("Import a starting directory: ");
        //ArrayBag<File> files = new ArrayBag<>();
        String startDirectory = scan.nextLine(); //start directory
        path = startDirectory;

        ab = new ArrayBag<>();

        searchFiles(startDirectory); //search files

        System.out.println(ab.size());

        System.out.println("Searching files and adding them to ArrayBag<File> ab...");

        PrintWriter pwTBills = createPrintWriter(path + "\\T-Bills.csv");
        PrintWriter pwNotes = createPrintWriter(path + "\\Notes.csv");
        PrintWriter pwBonds = createPrintWriter(path + "\\Bonds.csv");
        PrintWriter errors = createPrintWriter(path + "\\errors.csv");

        for (int i = 0; i < ab.size(); i++) {
            //process files (use selection)
            File curr = ab.get(i);
            if (curr.getName().contains("T-Bills")) {
                processTBills(curr, pwTBills, errors);
            } else if (curr.getName().contains("Bonds")) {
                processBonds(curr, pwBonds, errors);
            } else if (curr.getName().contains("Notes")) {
                processNotes(curr, pwNotes, errors);
            }
        }

        // Print processing statistics
        System.out.println(
                "Files processed: " + filesProcessed);
        System.out.println(
                "Rows processed: " + rowsProcessed);
        System.out.println(
                "Error lines: " + errorLines);
    }

}

//C:\Users\rwetz\Downloads\Lab106-data
