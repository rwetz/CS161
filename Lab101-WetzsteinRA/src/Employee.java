
/**
 *
 * @author Ryan Wetzstein
 * @version 01-14-2024 Employee class.
 */
public class Employee {

    private static int employeeCount = 0;
    private int id;
    private String name;

    /**
     * Constructor for the Employee class
     *
     * @param id
     * @param name
     */
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
        employeeCount++;
    }

    /**
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id sets id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name sets name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return number of times the Employee constructor called
     */
    public int getEmployeeCount() {
        return employeeCount;
    }

    /**
     *
     * @return contents of Employee instance
     */
    @Override
    public String toString() {
        return getClass().getName() + "@" + id + ":" + name + ":" + employeeCount;
    }

    /**
     *
     * @param o object to be compared
     * @return true if objects equal
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee e = (Employee) o;

        return id == e.id
                && name.equals(e.name);
    }

}
