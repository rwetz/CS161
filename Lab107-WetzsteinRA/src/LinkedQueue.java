
/**
 * Data Structures & Algorithms 6th Edition
 * Goodrick, Tamassia, Goldwasser
 * Code Fragments 6.1
 *
 *   Realization of a FIFO queue as an adaptation of a SinglyLinkedList.
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
public class LinkedQueue<E> implements Queue<E> {

    private SinglyLinkedList<E> list = new SinglyLinkedList<>();     // an empty list

    public LinkedQueue() {
    }            // new queue relies on the initially empty list

    /**
     *
     * @return size of queue
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     *
     * @return if queue is empty or not
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * adds node to queue
     *
     * @param element
     */
    @Override
    public void enqueue(E element) {
        list.addLast(element);
    }

    /**
     *
     * @return first node on queue
     */
    @Override
    public E first() {
        return list.first();
    }

    /**
     *
     * @return dequeues and returns node
     */
    @Override
    public E dequeue() {
        return list.removeFirst();
    }
}
