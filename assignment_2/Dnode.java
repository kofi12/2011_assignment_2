package assignment_2;

/**
 * @author chungcl
 *
 * @param <E>
 */
/**
 * @author chungcl
 *
 * @param <E>
 */
public class Dnode<E> implements Position<E>
{
    private E element;
    private Dnode<E> prev;
    private Dnode<E> next;

    /**
     * @param e
     * @param p
     * @param n
     */
    public Dnode(E e, Dnode<E> p, Dnode<E> n)
    {
        element = e;
        prev = p;
        next = n;
    }

    /**
     * 
     */
    public Dnode()
    {
    	this(null, null, null);
    }

    /**
     * @param e
     */
    public Dnode( E e ) {
    	this( e, null, null);
    }
    
    /**
     * @return
     */
    public Dnode<E> getPrev()
    {
        return prev;
    }

    /**
     * @param prev
     */
    public void setPrev(Dnode<E> prev)
    {
        this.prev = prev;
    }

    /**
     * @return
     */
    public Dnode<E> getNext()
    {
        return next;
    }

    /**
     * @param next
     */
    public void setNext(Dnode<E> next)
    {
        this.next = next;
    }

    /**
     * @param element
     */
    public void setElement(E element)
    {
        this.element = element;
    }

    
    /**
     *
     */
    public E getElement() throws IllegalStateException
    {
        return null;
    }
}
