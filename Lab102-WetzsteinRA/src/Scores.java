
/**
 *
 * @author Ryan Wetzstein
 * @version 01-22-2024
 */
import java.util.Random;

public class Scores {

    private int[] list;
    private int count;

    /**
     * default constructor
     */
    public Scores() {
        list = new int[2];
        count = 0;
    }

    /**
     * overloaded constructor
     *
     * @param newLength
     */
    public Scores(int newLength) {
        list = new int[newLength];
        count = 0;
    }

    /**
     *
     * @return a count of numbers in Scores class
     */
    public int size() {
        return count;
    }

    /**
     *
     * @return true when scores is empty
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * method that removes all the numbers from Scores class
     */
    public void clear() {
        list = new int[list.length];
        count = 0;
    }

    /**
     *
     * @param num
     * @return a count the number of times the number num exists in Scores class
     */
    public int getFrequencyOf(int num) {
        int frequency = 0;
        for (int i = 0; i < count; i++) {
            if (num == list[i]) {
                frequency++;
            }
        }
        return frequency;
    }

    /**
     *
     * @param num
     * @return true when the num is contained in Scores class.
     */
    public boolean contains(int num) {
        for (int i = 0; i < count; i++) {
            if (list[i] == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * method that always adds to the “next available” slot in the array.
     *
     * @param num
     */
    public void add(int num) {
        if (size() == list.length) {
            //new temp array
            int temp[] = new int[list.length * 2];

            //copy array data
            for (int i = 0; i < list.length; i++) {
                temp[i] = list[i];
            }
            //swap refs
            list = temp;

            //deref temp
            temp = null;

            //ADD NUMBER
            list[size()] = num;
            count++;
            System.out.println(size());
        } else {
            if (size() != list.length) {

                list[size()] = num;
                count++;

            }
        }
    }

    /**
     * method that removes the first occurrence of the number num from list.
     *
     * @param num
     */
    public void remove(int num) {
        //set index to impossible index spot
        int listIndex = -1;

        //iterate over and find index of removed num
        for (int i = 0; i < count; i++) {
            if (list[i] == num) {
                listIndex = i;
                continue;
            } else {
                continue;
            }

        }

        //if it exists, take it out
        if (listIndex > -1) {
            if (listIndex < count - 1) {
                for (int i = listIndex; i < count - 1; i++) {
                    list[i] = list[i + 1];
                }
            }
        }

        //set count correctly
        count--;
    }

    /**
     *
     * @return a removed random number from the list array,
     */
    public int remove() {
        if (list == null) {
            throw new IllegalStateException("The remove() method cannot be called on an empty list");
        }

        //use random to generate psuedorandom index 
        Random rand = new Random();
        int randomIndex = rand.nextInt(count);

        //remove the number from random index
        int removedNum = list[randomIndex];

        //shift elements to left
        for (int i = 0; i < count - 1; i++) {
            list[i] = list[i + 1];
        }

        //decrement count 
        count--;

        return removedNum;
    }

    /**
     *
     * @param i
     * @return the number at the ith index position in the list
     */
    public int get(int i) {
        if (i < 0 || i >= count) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
        return list[i];
    }

    /**
     *
     * @return a String of the contents of Scores class
     */
    @Override
    public String toString() {
        String scoresContents = "";
        String tempVar = "";
        for (int i = 0; i < list.length; i++) {
            tempVar += list[i] + ", ";
        }
        scoresContents = getClass().getName() + "@" + " " + tempVar + ":" + " Count = " + count;
        return scoresContents;
    }

    /**
     *
     * @param o The object to compare with the Scores class.
     * @return true if the parameter o exactly matches the contents of Scores
     * class.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Scores)) {
            return false;
        }

        Scores scores = (Scores) o;

        if (count != scores.count) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            if (list[i] != scores.list[i]) {
                return false;
            }
        }
        return true;
    }
}
