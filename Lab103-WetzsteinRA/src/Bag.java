
/**
 * Represents a generic bag interface that defines common operations for a bag data structure.
 *
 * @param <E> The type of elements stored in the bag.
 * @author rwetz
 * @version generic bag interface 1-29-2023
 */
public interface Bag<E> {

    /**
     * Retrieves the number of items in the bag.
     *
     * @return The count of items in the bag.
     */
    public int size();

    /**
     * Checks if the bag is empty.
     *
     * @return true when the bag is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Removes all items from the bag.
     */
    public void clear();

    /**
     * Retrieves the frequency of a specific item in the bag.
     *
     * @param e The item to count.
     * @return The frequency of the specified item in the bag.
     */
    public int getFrequencyOf(E e);

    /**
     * Checks whether the bag contains a specific item.
     *
     * @param e The item to check for.
     * @return true if the bag contains the specified item, false otherwise.
     */
    public boolean contains(E e);

    /**
     * Adds an item to the next available position in the bag.
     *
     * @param e The item to add to the bag.
     */
    public void add(E e);

    /**
     * Removes the first occurrence of a specific item from the bag.
     *
     * @param e The item to remove.
     * @return The removed item, or null if the item is not in the bag or if
     * called on an empty bag.
     */
    public E remove(E e);

    /**
     * Removes a random entry from the bag.
     *
     * @return The removed entry, or null if the bag is empty.
     */
    public E remove();

    /**
     * Retrieves the element at the specified position in the bag.
     *
     * @param i The index of the element to retrieve.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E get(int i);

    /**
     * Returns a string representation of the contents of the bag.
     *
     * @return A string representation of the contents of the bag.
     */
    @Override
    public String toString();

    /**
     * Checks if the bag is equal to another object.
     *
     * @param o The object to compare with the bag.
     * @return true if the bags are equal based on their elements (i.e., same
     * elements in the same order), false otherwise.
     */
    @Override
    public boolean equals(Object o);
}
