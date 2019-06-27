package assignment_2;

public interface PositionalList<E>
{
    /**
     * @return
     */
    int size();

    /**
     * @return
     */
    boolean isEmpty();
    
    /**
     * @return
     */
    Position<E> first();

    /**
     * @return
     */
    Position<E> last();

    /**
     * @param p
     * @return
     * @throws IllegalArgumentException
     */
    Position<E> before(Position<E> p) throws IllegalArgumentException;

    /**
     * @param p
     * @return
     * @throws IllegalArgumentException
     */
    Position<E> after(Position<E> p) throws IllegalArgumentException;

    /**
     * @param e
     * @return
     */
    Position<E> addFirst(E e);

    /**
     * @param e
     * @return
     */
    Position<E> addLast(E e);

    /**
     * @param p
     * @param e
     * @return
     * @throws IllegalArgumentException
     */
    Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * @param p
     * @param e
     * @return
     * @throws IllegalArgumentException
     */
    Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * @param p
     * @param e
     * @return
     * @throws IllegalArgumentException
     */
    E set(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * @param p
     * @return
     * @throws IllegalArgumentException
     */
    E remove(Position<E> p) throws IllegalArgumentException;
}
