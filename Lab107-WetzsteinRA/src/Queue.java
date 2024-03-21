
/**
 * Data Structures & Algorithms 6th Edition
 * Goodrick, Tamassia, Goldwasser
 * Code Fragments 6.1
 *
 * An implementation of a simple Queue interface.
 *
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 *
 * @author Ryan Wetzstein, transcribed by
 * @version 20240311
 * @param <E>
 */
public interface Queue<E> {

    /**
     * Returns the number of elements in the queue.
     *
     * @return
     */
    int size();

    /**
     * Tests whether the queue is empty.
     *
     * @return
     */
    boolean isEmpty();

    /**
     * Inserts an element at the rear of the queue.
     *
     * @param e
     */
    void enqueue(E e);

    /**
     * Returns, but does not remove, the first element of the queue (null if
     * empty).
     *
     * @return
     */
    E first();

    /**
     * Removes and returns the first element of the queue (null if empty).
     *
     * @return
     */
    E dequeue();
}
