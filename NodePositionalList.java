package assignment_2;

import java.util.Iterator;

public class NodePositionalList<E> implements PositionalList<E>, Iterable<Position<E>>
{
    Dnode<E> head;
    Dnode<E> tail;
    private int size;

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public Position<E> first()
    {
        if(isEmpty())
            return null;
        return head;
    }

    @Override
    public Position<E> last()
    {
        if(isEmpty())
            return null;
        return tail;
    }

    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException
    {
        Dnode<E> curr = head;
        while((curr = curr.getNext()) != null)
        {

        }

        return null;
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException
    {
        return null;
    }

    @Override
    public Position<E> addFirst(E e)
    {
        return null;
    }

    @Override
    public Position<E> addLast(E e)
    {
        return null;
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException
    {
        return null;
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException
    {
        return null;
    }

    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException
    {
        return null;
    }

    @Override
    public E remove(Position<E> p) throws IllegalArgumentException
    {
        return null;
    }

    @Override
    public Iterator<Position<E>> iterator()
    {
        return null;
    }

    public Iterable<Position<E>> positions()
    {
        return null;
    }
}
