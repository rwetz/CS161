
/**
 *
 * @author Ryan Wetzstein
 * @version 01-14-2024 salaried employee subclass.
 */
public class Salaried extends Employee {

    private int employeeCount;
    private String title;
    private int salary;

    /**
     *
     * @param id
     * @param name
     * @param title
     * @param salary
     */
    public Salaried(int id, String name, String title, int salary) {
        super(id, name);
        this.title = title;
        this.salary = salary;
        employeeCount++;
    }

    /**
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title sets title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     *
     * @param salary sets salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     *
     * @return contents of instance
     */
    @Override
    public String toString() {
        return super.toString() + ":" + getClass().getName() + "@" + title + ":" + salary;
    }

    /**
     *
     * @param o
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Salaried)) {
            return false;
        }

        Salaried s = (Salaried) o;

        return super.equals(s)
                && title.equals(s.title)
                && salary == s.salary;
    }
}
