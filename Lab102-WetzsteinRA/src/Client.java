
import java.util.Random;

/**
 *
 * @author Ryan Wetzstein
 * @version 01-23-2024
 */
public class Client {

    /**
     * main method
     *
     * @param args
     */
    public static void main(String[] args) {

        //scores object
        Scores scoresObject = new Scores(16);

        //add 32 random numbers
        Random rand = new Random();
        for (int i = 0; i < 32; i++) {
            int randNum = rand.nextInt(21) - 10;
            scoresObject.add(randNum);

        }

        //tostring contents
        System.out.println(scoresObject.toString());

        //add 6 to array
        scoresObject.add(6);

        //REprint
        System.out.println(scoresObject.toString());

        //print size
        System.out.println("The size of the array is: " + scoresObject.size());

        //remove random
        int removedNum = scoresObject.remove();
        System.out.println("A random number was removed from the array. It was: " + removedNum);

        //find num at 15th position
        int num15 = scoresObject.get(15);
        System.out.println("The number at the 15th index is: " + num15);

        //print frequency of the removed number
        System.out.println("The number at the 15th index occurs " + scoresObject.getFrequencyOf(num15) + " times.");

        //remove first occurance
        scoresObject.remove(num15);
        System.out.println(num15 + " was removed from the array once.");

        //print frequency of the removed number again
        System.out.println("The number at the 15th index now occurs " + scoresObject.getFrequencyOf(num15) + " times.");

        //check if the list contains the number
        System.out.println("Whether or not the list contains the number at the 15th index is: " + scoresObject.contains(num15));

    }
}
