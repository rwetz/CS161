
/**
 * Data Structures & Algorithms 6th Edition
 * Goodrick, Tamassia, Goldwasser
 * Code Fragments 6.1
 *
 * An array-based implementation of a simple Stack.
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
public class ArrayStack<E> implements Stack<E> {

    public static final int CAPACITY = 1000;  // default array capacity
    private E[] data;                         // generic array used for storage
    private int t = -1;                       // index of the top element in stack

    public ArrayStack() {
        this(CAPACITY);
    }                                       // constructs stack with default capacity

    public ArrayStack(int capacity) {       // constructs stack with given capacity
        data = (E[]) new Object[capacity];  // safe cast; compiler may give warning

    }

    /**
     *
     * @return size of stack
     */
    @Override
    public int size() {
        return (t + 1);
    }

    /**
     *
     * @return if stack is empty
     */
    @Override
    public boolean isEmpty() {
        return (t == -1);
    }

    /**
     * pushes tray off stack
     *
     * @param e
     * @throws IllegalStateException
     */
    @Override
    public void push(E e) throws IllegalStateException {
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full");
        }

        data[++t] = e;                        // increment t before storing new item
    }

    /**
     *
     * @return tray at top of stack
     */
    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return data[t];
    }

    /**
     *
     * @return pop tray off stack and return it
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E answer = data[t];
        data[t] = null; // dereference to help garbage collection
        t--;
        return answer;
    }

}
