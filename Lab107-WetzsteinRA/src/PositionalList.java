
/**
 * Interface for positional lists.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @version 20240312
 * @author Ryan Wetzstein, transcribed by
 * @param <E> Type of elements stored in the list.
 */
public interface PositionalList<E> {

    /**
     * Returns the number of elements in the list.
     *
     * @return Number of elements in the list.
     */
    int size();

    /**
     * Checks whether the list is empty.
     *
     * @return True if the list is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the first position in the list (or null if empty).
     *
     * @return The first position in the list, or null if empty.
     */
    Position<E> first();

    /**
     * Returns the last position in the list (or null if empty).
     *
     * @return The last position in the list, or null if empty.
     */
    Position<E> last();

    /**
     * Returns the position immediately before the given position.
     *
     * @param p The position to get the element before.
     * @return The position before the given position, or null if p is the first
     * position.
     * @throws IllegalArgumentException if p is not a valid position in the
     * list.
     */
    Position<E> before(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the position immediately after the given position.
     *
     * @param p The position to get the element after.
     * @return The position after the given position, or null if p is the last
     * position.
     * @throws IllegalArgumentException if p is not a valid position in the
     * list.
     */
    Position<E> after(Position<E> p) throws IllegalArgumentException;

    /**
     * Inserts an element at the front of the list.
     *
     * @param e The element to insert.
     * @return The newly created position holding the inserted element.
     */
    Position<E> addFirst(E e);

    /**
     * Inserts an element at the back of the list.
     *
     * @param e The element to insert.
     * @return The newly created position holding the inserted element.
     */
    Position<E> addLast(E e);

    /**
     * Inserts an element before the given position.
     *
     * @param p The position to insert before.
     * @param e The element to insert.
     * @return The newly created position holding the inserted element.
     * @throws IllegalArgumentException if p is not a valid position in the
     * list.
     */
    Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * Inserts an element after the given position.
     *
     * @param p The position to insert after.
     * @param e The element to insert.
     * @return The newly created position holding the inserted element.
     * @throws IllegalArgumentException if p is not a valid position in the
     * list.
     */
    Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * Replaces the element stored at a given position and returns the old
     * element.
     *
     * @param p The position of the element to replace.
     * @param e The new element to store.
     * @return The element previously stored at the position.
     * @throws IllegalArgumentException if p is not a valid position in the
     * list.
     */
    E set(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * Removes the element at a given position and returns it.
     *
     * @param p The position of the element to remove.
     * @return The element that was removed.
     * @throws IllegalArgumentException if p is not a valid position in the
     * list.
     */
    E remove(Position<E> p) throws IllegalArgumentException;
}
