
import java.util.Iterator;

/**
 *
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @version 20240312
 * @author Ryan Wetzstein, transcribed by
 * @param <E> Type of elements stored in the list.
 */
/** An interface for a tree where nodes can have an arbitrary number of children.
 * @param <E> */
public interface Tree<E> extends Iterable<E> {

    /**
     *
     * @return root node
     */
    Position<E> root();

    /**
     *
     * @param p
     * @return parent node of position p
     * @throws IllegalArgumentException
     */
    Position<E> parent(Position<E> p) throws IllegalArgumentException;

    /**
     *
     * @param p
     * @return children of position p
     * @throws IllegalArgumentException
     */
    Iterable<Position<E>> children(Position<E> p)
            throws IllegalArgumentException;

    /**
     *
     * @param p
     * @return number of children of position p
     * @throws IllegalArgumentException
     */
    int numChildren(Position<E> p) throws IllegalArgumentException;

    /**
     *
     * @param p
     * @return if node is internal or not
     * @throws IllegalArgumentException
     */
    boolean isInternal(Position<E> p) throws IllegalArgumentException;

    /**
     *
     * @param p
     * @return if node is external or not
     * @throws IllegalArgumentException
     */
    boolean isExternal(Position<E> p) throws IllegalArgumentException;

    /**
     *
     * @param p
     * @return if node is root or not
     * @throws IllegalArgumentException
     */
    boolean isRoot(Position<E> p) throws IllegalArgumentException;

    /**
     *
     * @return size of tree
     */
    int size();

    /**
     *
     * @return if tree is empty
     */
    boolean isEmpty();

    /**
     *
     * @return
     */
    @Override
    Iterator<E> iterator();

    /**
     *
     * @return
     */
    Iterable<Position<E>> positions();
}
