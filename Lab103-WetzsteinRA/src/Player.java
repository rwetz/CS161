
/**
 * Represents a player in a sports team.
 * This class includes information such as name, position, and jersey number for a player.
 *
 * @author Ryan Wetzstein
 */
public class Player {

    /**
     * The name of the player.
     */
    String name;

    /**
     * The position of the player.
     */
    String position;

    /**
     * The jersey number of the player.
     */
    int jNumber;

    /**
     * Default constructor initializing default values for a player.
     */
    public Player() {
        name = "Ryan Wetzstein";
        position = "Point Guard";
        jNumber = 0;
    }

    /**
     * Overloaded Constructor creating a player with specified attributes.
     *
     * @param name The name of the player.
     * @param position The position of the player.
     * @param jNumber The jersey number of the player.
     */
    public Player(String name, String position, int jNumber) {
        this.name = name;
        this.position = position;
        this.jNumber = jNumber;
    }

    // Getters
    /**
     * Retrieves the name of the player.
     *
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the position of the player.
     *
     * @return The position of the player.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Retrieves the jersey number of the player.
     *
     * @return The jersey number of the player.
     */
    public int getJNumber() {
        return jNumber;
    }

    // Setters
    /**
     * Sets the name of the player.
     *
     * @param name The name to set for the player.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the position of the player.
     *
     * @param position The position to set for the player.
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Sets the jersey number of the player.
     *
     * @param jNumber The jersey number to set for the player.
     */
    public void setJNumber(int jNumber) {
        this.jNumber = jNumber;
    }

    /**
     * Returns a string representation of the player, including name, position,
     * and jersey number.
     *
     * @return String contents of the player.
     */
    @Override
    public String toString() {
        return """
               
               Player: """ + name + ", Position: " + position + ", Jersey Number: " + jNumber;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o The object to compare for equality.
     * @return true if the objects are equal based on their name, position, and
     * jersey number; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Player)) {
            return false;
        }

        Player otherPlayer = (Player) o;

        boolean sameName = this.name.equals(otherPlayer.name);
        boolean samePosition = this.position.equals(otherPlayer.position);
        boolean sameJNumber = this.jNumber == otherPlayer.jNumber;

        // Return true if all relevant fields are equal
        return sameName && samePosition && sameJNumber;
    }
}
