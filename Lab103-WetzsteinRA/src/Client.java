
/**
 *
 * @author rwetz
 */
public class Client {

    public static void main(String[] args) {
        //instance
        ArrayBag<Player> mensTeam = new ArrayBag<>(2);

        //hardcode 8 players
        mensTeam.add(new Player("Zach Mathis", "Wide Reciever", 0));
        mensTeam.add(new Player("Braylon Henderson", "Wide Reciever", 1));
        mensTeam.add(new Player("Kellen Entz", "Wide Reciever", 2));
        mensTeam.add(new Player("RaJa Nelson", "Wide Reciever", 3));
        mensTeam.add(new Player("Jaylin Crumby", "Safety", 4));
        mensTeam.add(new Player("Owen Johnson", "Running Back", 5));
        mensTeam.add(new Player("Bryce Lance", "Wide Reciever", 6));
        mensTeam.add(new Player("Tyler Terhark", "Wide Reciever", 7));

        //print contents of team
        System.out.println("Mens Football Team Members: " + mensTeam);

        //remove a player
        Player removedPlayer = mensTeam.remove();
        System.out.println("Removed member: " + removedPlayer);

        //print new contents of team
        System.out.println("Mens Football Team Members after removal: " + mensTeam);

        //get fifth player
        Player fifthPlayer = mensTeam.get(4);

        //display contents
        System.out.println("The fifth player is: " + fifthPlayer);

        //hardcode add a new player
        mensTeam.add(new Player("Ryan Wetzstein", "Quarterback", 8));

        //printed contents with new player
        System.out.println("Mens Team after new player added");
        System.out.println(mensTeam);

        //remove player that was obtained in step 5
        mensTeam.remove(fifthPlayer);

        //print contents after removal
        System.out.println("Mens team after the fifth player was removed: " + mensTeam);

        //------------------------------------------------------------------------------//
        //create linked bag with courses
        Bag<String> courses = new ArrayBag<>();

        //populate courses with each of your courses
        courses.add("CSCI 161");
        courses.add("COMM 110");
        courses.add("CSCI 222");
        courses.add("MATH 166");

        //display contents
        System.out.println("My courses this semester are: " + courses);

        //remove random course
        String removedCourse = courses.remove();
        System.out.println("The course I removed is: " + removedCourse);

        //display contents
        System.out.println("My courses this semester after I removed a random course are: " + courses);
        //---------------------------------------------------------------------------------------------//

        //create linked bag
        LinkedBag<Player> womensTeam = new LinkedBag<>();

        //hardcode 8 players
        womensTeam.add(new Player("Abbie Draper", "Forward", 0));
        womensTeam.add(new Player("Leah Mackenzie", "Guard", 1));
        womensTeam.add(new Player("Abby Graham", "Guard", 2));
        womensTeam.add(new Player("Heaven Hamling", "Guard", 3));
        womensTeam.add(new Player("Taryn Hamling", "Guard", 4));
        womensTeam.add(new Player("Ellie Evans", "Guard", 5));
        womensTeam.add(new Player("Avery Koenan", "Forward", 6));
        womensTeam.add(new Player("Abby Schulte", "Guard", 7));

        //print contents of team
        System.out.println("Women's Basketball Team Members: " + womensTeam.toString());

        //remove a player
        Player removedFemalePlayer = womensTeam.remove();
        System.out.println("Removed player: " + removedFemalePlayer);

        //print contents of team
        System.out.println("Women's Basketball Team Members after removal: " + womensTeam);

        //get fifth player
        Player fifthFemalePlayer = womensTeam.get(4);

        //display contents
        System.out.println("The fifth player is: " + fifthFemalePlayer);

        //hardcode add a new player
        womensTeam.add(new Player("Izzy Rice", "Guard", 8));

        //printed contents with new player
        System.out.println("Women's Team after new player added is: " + womensTeam);

        //remove player that was obtained in step 5
        womensTeam.remove(fifthFemalePlayer);

        //print contents after removal
        System.out.println("Women's team after the fifth player was removed: " + womensTeam);

    }
}
