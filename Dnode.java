package assignment_2;

public class DNode<E> implements Position<E>
{
    private E element;
    private DNode<E> prev;
    private DNode<E> next;

    public DNode(E e, DNode<E> p, DNode<E> n)
    {
        element = e;
        prev = p;
        next = n;
    }

    public DNode()
    {
        element = null;
        prev = null;
        next = null;
    }

    public DNode<E> getPrev()
    {
        return prev;
    }

    public void setPrev(DNode<E> prev)
    {
        this.prev = prev;
    }

    public DNode<E> getNext()
    {
        return next;
    }

    public void setNext(DNode<E> next)
    {
        this.next = next;
    }

    public void setElement(E element)
    {
        this.element = element;
    }

    @Override
    public E getElement() throws IllegalStateException
    {
        return null;
    }
}
