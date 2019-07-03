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
public class DNode<E> implements Position<E>
{
    private E element;
    private DNode<E> prev;
    private DNode<E> next;

    /**
     * Constructor for DNode.
     * 
     * @param e Some element
     * @param p The previous node
     * @param n The next node
     */
    public DNode(E e, DNode<E> p, DNode<E> n)
    {
        element = e;
        prev = p;
        next = n;
    }

    /**
     * Constructor for DNode. Makes a DNode with null elements and null prev and next links.
     */
    public DNode()
    {
    	this(null, null, null);
    }

    /**
     * @param e
     */
    public DNode( E e ) {
    	this( e, null, null);
    }
    
    /**
     * @return
     */
    public DNode<E> getPrev()
    {
        return prev;
    }

    /**
     * @param prev
     */
    public void setPrev(DNode<E> prev)
    {
        this.prev = prev;
    }

    /**
     * @return
     */
    public DNode<E> getNext()
    {
        return next;
    }

    /**
     * @param next
     */
    public void setNext(DNode<E> next)
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
