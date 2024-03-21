
/**
 * Data Structures & Algorithms 6th Edition
 * Goodrick, Tamassia, Goldwasser
 * Code Fragments 6.1
 *
 * A linked-based implementation of a simple Stack.
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
public class LinkedStack<E> implements Stack<E> {

    private SinglyLinkedList<E> list = new SinglyLinkedList<>();    // an empty list

    public LinkedStack() {
    }            // new stack relies on the initially empty list

    /**
     *
     * @return size of stack
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     *
     * @return if stack is empty or not
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * pushes tray off stack
     *
     * @param element
     */
    @Override
    public void push(E element) {
        list.addFirst(element);
    }

    /**
     *
     * @return top tray of stack
     */
    @Override
    public E top() {
        return list.first();
    }

    /**
     *
     * @return pop tray off stack and return it
     */
    @Override
    public E pop() {
        return list.removeFirst();
    }
}
