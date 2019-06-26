package assignment_2;

public class Dnode<E> implements Position<E>
{
    private E element;
    private Dnode<E> prev;
    private Dnode<E> next;

    public Dnode(E e, Dnode<E> p, Dnode<E> n)
    {
        element = e;
        prev = p;
        next = n;
    }

    public Dnode()
    {
        element = null;
        prev = null;
        next = null;
    }

    public Dnode<E> getPrev()
    {
        return prev;
    }

    public void setPrev(Dnode<E> prev)
    {
        this.prev = prev;
    }

    public Dnode<E> getNext()
    {
        return next;
    }

    public void setNext(Dnode<E> next)
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
