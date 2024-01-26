
/**
 *
 * @author Ryan Wetzstein
 * @version 01-16-2024 main method and client test for other classes
 */
public class Client {

    public static void main(String[] args) {

        Employee[] employeeList = new Employee[10];

        /**
         * populated employee array
         */
        employeeList[0] = new Salaried(
                7778867, "Al", "Manager", 60000);
        employeeList[1] = new Hourly(
                7778976, "Kelly", "Hostess", 25.75);
        employeeList[2] = new Salaried(
                7771382, "Peggy", "CEO", 120000);
        employeeList[3] = new Hourly(
                7774436, "Bud", "Busboy", 15.00);
        employeeList[4] = new Hourly(
                7775593, "Marcy", "Server", 10.00);
        employeeList[5] = new Hourly(
                7771122, "Jefferson", "Cook", 35.00);

        /**
         * for-loop prints out employees
         */
        for (Employee employeeList1 : employeeList) {
            if (employeeList1 == null) {
                System.out.println("null");
            } else if (employeeList1 != null) {
                System.out.println(employeeList1.toString());
            }
        }

        /**
         * adds raise to employees and prints
         */
        for (Employee e : employeeList) {
            if (e != null) {
                if (e instanceof Salaried s) {
                    double newSalary = s.getSalary() * 1.25;
                    s.setSalary((int) newSalary);
                    e = s;
                    System.out.println(s.toString());
                }
                if (e instanceof Hourly h) {
                    double newHourly = h.getHourlyRate() * 1.25;
                    h.setHourlyRate((int) newHourly);
                    e = h;
                    System.out.println(h.toString());
                }
            }
        }

        /**
         * explicit equals method testing salaried test
         */
        Employee e1 = new Salaried(7778867, "Al", "Manager", 60000);
        Employee e2 = new Salaried(7771382, "Sally", "CEO", 120000);
        Employee e3 = new Salaried(7771382, "Jane", "CEO", 120000);
        Employee e4 = new Salaried(7771382, "Jane", "CEO", 120000);

        Boolean test1 = e1.equals(e2);
        Boolean test2 = e3.equals(e4);

        /**
         * hourly test
         */
        Employee e5 = new Hourly(7778976, "Kelly", "Hostess", 25.75);
        Employee e6 = new Hourly(7775593, "Marcy", "Server", 10.00);
        Employee e7 = new Hourly(7778976, "Percy", "Host", 29.75);
        Employee e8 = new Hourly(7778976, "Percy", "Host", 29.75);

        Boolean test3 = e5.equals(e6);
        Boolean test4 = e7.equals(e8);

        /**
         * print results
         */
        System.out.println("Salaried test 1:" + test1);
        System.out.println("Salaried test 2:" + test2);
        System.out.println("Hourly test 1:" + test3);
        System.out.println("Hourly test 2:" + test4);

    }

}
