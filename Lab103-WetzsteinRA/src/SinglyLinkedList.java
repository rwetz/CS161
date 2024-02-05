
/**
 * SinglyLinkedList Class
 * Code Fragments 3.14, 3.15
 * from
 * Data Structures & Algorithms, 6th edition
 * by Michael T. Goodrich, Roberto Tamassia & Michael H. Goldwasser
 * Wiley 2014
 * Transcribed by
 *
 * @author Ryan Wetzstein
 * @version 1312024
 */
/**
 * A singly linked list implementation.
 *
 * @param <E> the type of elements stored in the list
 */
public class SinglyLinkedList<E> {

    private static class Node<E> {

        private final E element; // reference to the element stored at this node
        private Node<E> next;    // reference to the subsequent node in the list

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    } //----------- end of nested Node class -----------

    // instance variables of the SinglyLinkedList
    private Node<E> head = null; // head node of the list (or null if empty)
    private Node<E> tail = null; // last node of the list (or null if empty)
    private int size = 0;        // number of nodes in the list

    /**
     * Constructs an initially empty list.
     */
    public SinglyLinkedList() {
    }

    // access methods
    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the first element in the list without removing it.
     *
     * @return the first element in the list, or null if the list is empty
     */
    public E first() {
        return isEmpty() ? null : head.getElement();
    }

    /**
     * Returns the last element in the list without removing it.
     *
     * @return the last element in the list, or null if the list is empty
     */
    public E last() {
        return isEmpty() ? null : tail.getElement();
    }

    // update methods
    /**
     * Adds an element to the front of the list.
     *
     * @param e the element to be added
     */
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param e the element to be added
     */
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    /**
     * Removes and returns the first element in the list.
     *
     * @return the first element in the list, or null if the list is empty
     */
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()) {
            tail = null;
        }
        return answer;
    }
}
