
import java.util.Random;

/**
 * A linked bag implementation that stores elements in a singly linked list.
 *
 * @param <E> The type of elements stored in the bag.
 * @author Ryan Wetzstein
 */
public class LinkedBag<E> implements Bag<E> {

    private SinglyLinkedList<E> list;

    // Default constructor
    /**
     * Constructs an empty LinkedBag with a new singly linked list.
     */
    public LinkedBag() {
        list = new SinglyLinkedList<>();
    }

    /**
     * Retrieves the number of elements in the bag.
     *
     * @return The size of the bag.
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Checks if the bag is empty.
     *
     * @return true if the bag is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        boolean flag = false;
        if (list.size() == 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * Clears all elements from the bag.
     */
    @Override
    public void clear() {
        list = new SinglyLinkedList<>();
    }

    /**
     * Retrieves the frequency of a specific element in the bag.
     *
     * @param e The element to count.
     * @return The frequency of the specified element in the bag.
     */
    @Override
    public int getFrequencyOf(E e) {
        int size = size();
        int freq = 0;
        for (int i = 0; i < size; i++) {
            E temp = list.removeFirst();
            if (temp.equals(e)) {
                freq++;
            }
            list.addLast(temp);
        }
        return freq;
    }

    /**
     * Checks if the bag contains a specific element.
     *
     * @param e The element to check for.
     * @return true if the bag contains the specified element, false otherwise.
     */
    @Override
    public boolean contains(E e) {
        int size = size();
        for (int i = 0; i < size; i++) {
            E temp = list.removeFirst();
            if (temp.equals(e)) {
                return true;
            }
            list.addLast(e);
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
        list.addLast(e);

    }

    /**
     * Removes a specific element from the bag.
     *
     * @param e The element to remove.
     * @return The removed element, or null if not found.
     */
    @Override
    public E remove(E e) {
        int size = size();
        boolean removed = false;
        E result = null;
        if (list.isEmpty()) {
            return null;
        }
        for (int i = 0; i < size; i++) {
            E temp = list.removeFirst();
            if (temp.equals(e) && !removed) {
                removed = true;
                result = temp;
            } else {
                list.addLast(temp);
            }
        }
        return result;
    }

    /**
     * Removes a random element from the bag.
     *
     * @return The removed element, or null if the bag is empty.
     */
    @Override
    public E remove() {
        int size = size();
        E result = null;

        if (list.isEmpty()) {
            return null;
        }

        Random rand = new Random();
        int randomIndex = rand.nextInt(size);

        for (int i = 0; i < size; i++) {
            E temp = list.removeFirst();
            if (i == randomIndex) {
                result = temp;
            } else {
                list.addLast(temp);
            }
        }

        return result;
    }

    /**
     * Retrieves the element at a specific index in the bag.
     *
     * @param i The index of the element to retrieve.
     * @return The element at the specified index.
     * @throws ArrayIndexOutOfBoundsException if the index is out of bounds.
     */
    @Override
    public E get(int i) {
        int size = size();
        E num = null;
        if (i < 0 || i > size()) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
        for (int j = 0; j < size; j++) {
            E temp = list.removeFirst();
            if (j == i) {
                num = temp;
            }
            list.addLast(temp);
        }
        return num;
    }

    /**
     * Returns a string representation of the bag.
     *
     * @return The string representation of the bag.
     */
    @Override
    public String toString() {
        int size = size();
        if (isEmpty()) {
            return "the bag is empty 0_0";

        }
        String result = "";

        for (int i = 0; i < size(); i++) {
            E temp = list.removeFirst();
            result += temp;
            list.addLast(temp);
        }
        
        return result + "\nThe size of the team is: " + size();

    }

    /**
     * Checks if the bag is equal to another object.
     *
     * @param o The object to compare for equality.
     * @return true if the bags are equal based on their elements, false
     * otherwise.
     */
    @Override
    public boolean equals(Object o) {
        boolean check = false;
        if (!(o instanceof LinkedBag)) {
            return false;
        }

        LinkedBag<E> e = (LinkedBag<E>) o;

        E temp1 = list.removeFirst();
        E temp2 = e.list.removeFirst();

        if (temp1.equals(temp2)) {
            check = true;
        }

        list.addLast(temp1);
        e.list.addLast(temp2);

        return check;
    }
}
