
/**
 * Represents a bag implemented using an array to store elements.
 *
 * @param <E> The type of elements stored in the bag.
 * @author Ryan Wetzstein
 * @version 01-22-2024
 */
import java.util.Arrays;
import java.util.Random;

/**
 * Represents a bag implemented using an array to store elements.
 *
 * @param <E> The type of elements stored in the bag.
 * @author rwetz
 */
public class ArrayBag<E> implements Bag<E> {

    private E[] list;
    private int count;

    /**
     * Default constructor creating an empty ArrayBag with an initial capacity
     * of 2.
     */
    public ArrayBag() {
        list = (E[]) new Object[2];
        count = 0;
    }

    /**
     * Overloaded constructor creating an empty ArrayBag with a specified
     * initial capacity.
     *
     * @param newLength The initial capacity of the bag.
     */
    public ArrayBag(int newLength) {
        list = (E[]) new Object[newLength];
        count = 0;
    }

    /**
     * Retrieves the number of elements in the bag.
     *
     * @return The size of the bag.
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Checks if the bag is empty.
     *
     * @return true if the bag is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Clears all elements from the bag.
     */
    @Override
    public void clear() {
        list = (E[]) new Object[list.length];
        count = 0;
    }

    /**
     * Retrieves the frequency of a specific element in the bag.
     *
     * @param e The element to count.
     * @return The frequency of the specified element in the bag.
     */
    @Override
    public int getFrequencyOf(E e) {
        int frequency = 0;
        for (int i = 0; i < count; i++) {
            if (e.equals(list[i])) {
                frequency++;
            }
        }
        return frequency;
    }

    /**
     * Checks if the bag contains a specific element.
     *
     * @param e The element to check for.
     * @return true if the bag contains the specified element, false otherwise.
     */
    @Override
    public boolean contains(E e) {
        for (int i = 0; i < count; i++) {
            if (list[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds an element to the bag.
     *
     * @param e The element to add to the bag.
     */
    @Override
    public void add(E e) {
        if (size() == list.length) {
            // Create a new temporary array with double the length
            E temp[] = (E[]) new Object[list.length * 2];

            // Copy array data to the temporary array
            for (int i = 0; i < list.length; i++) {
                temp[i] = list[i];
            }

            // Update the reference to the new array
            list = temp;

            // Dereference temp
            temp = null;

            // Add the element to the next available slot
            list[size()] = e;
            count++;
        } else {
            // Add the element to the next available slot
            list[size()] = e;
            count++;
        }
    }

    /**
     * Removes the first occurrence of a specific element from the bag.
     *
     * @param e The element to remove.
     * @return The removed element, or null if not found.
     */
    @Override
    public E remove(E e) {
        int listIndex = -1;

        // Find the index of the removed element
        for (int i = 0; i < size(); i++) {
            if (e.equals(list[i])) {
                listIndex = i;
                break;
            }
        }

        // If the element exists, remove it
        if (listIndex > -1) {
            E removedElement = list[listIndex];

            // Shift elements to the left
            for (int j = listIndex; j < count - 1; j++) {
                list[j] = list[j + 1];
            }

            // Set the last position to null
//            list[count - 1] = null;

            // Decrement count
            count--;

            return removedElement;
        }

        return null;  // Return null if the element is not found
    }

    /**
     * Removes a random element from the bag.
     *
     * @return The removed element, or null if the bag is empty.
     */
    @Override
    public E remove() {
        if (list == null) {
            throw new IllegalStateException("The remove() method cannot be called on an empty list");
        }

        // Use random to generate a pseudorandom index
        Random rand = new Random();
        int randomIndex = rand.nextInt(count);

        // Remove the element from the random index
        E removedNum = list[randomIndex];

        // Move last element over
        list[randomIndex] = list[count - 1];

        // Set last pos to null
        list[count - 1] = null;

        // Decrement count
        count--;

        return removedNum;
    }

    /**
     * Retrieves the element at the specified index in the bag.
     *
     * @param i The index of the element to retrieve.
     * @return The element at the specified index.
     * @throws ArrayIndexOutOfBoundsException if the index is out of bounds.
     */
    @Override
    public E get(int i) {
        if (i < 0 || i >= count) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
        return list[i];
    }

    /**
     * Returns a string representation of the bag.
     *
     * @return The string representation of the bag.
     */
    @Override
    public String toString() {
        String result = "[";

        for (int i = 0; i < count; i++) {
            result += list[i];

            if (i < count - 1) {
                result += ", ";
            }
        }

        result += "]\nCount = " + count;
        return result;
    }

    /**
     * Checks if the bag is equal to another object.
     *
     * @param o The object to compare with the bag.
     * @return true if the bags are equal based on their elements, false
     * otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof ArrayBag)) {
            return false;
        }

        ArrayBag<E> scores = (ArrayBag<E>) o;

        if (count != scores.count) {
            return false;
        }

        for (int i = 0; i < count; i++) {
            if (!list[i].equals(scores.list[i])) {
                return false;
            }
        }
        return true;
    }
}
