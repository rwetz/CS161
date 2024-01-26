
/**
 *
 * @author Ryan Wetzstein
 * @version 1-16-2024 hourly employee subclass
 */
public class Hourly extends Employee {

    private int employeeCount;
    private String position;
    private double hourlyRate;

    /**
     *
     * @param id
     * @param name
     * @param position
     * @param hourlyRate
     */
    public Hourly(int id, String name, String position, double hourlyRate) {
        super(id, name);
        this.position = position;
        this.hourlyRate = hourlyRate;
        employeeCount++;
    }

    /**
     *
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     *
     * @param position sets position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     *
     * @return hourly rate
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     *
     * @param hourlyRate sets hourlyRate
     */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     *
     * @return contents of instance
     */
    @Override
    public String toString() {
        return super.toString() + ":" + getClass().getName() + "@" + position + ":" + hourlyRate;
    }

    /**
     *
     * @param o
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Hourly)) {
            return false;
        }

        Hourly h = (Hourly) o;

        return super.equals(h)
                && position.equals(h.position)
                && hourlyRate == h.hourlyRate;
    }
}
