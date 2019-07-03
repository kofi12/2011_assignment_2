package assignment_2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ElementIterator<E> implements Iterator<E>
{
    NodePositionalList<E> list;
    private DNode firstNode = (DNode<E>)list.first();
    private DNode current = null;

    public ElementIterator()
    {

    }

    @Override
    public boolean hasNext()
    {
        return current != list.last();
    }

    @Override
    public E next() throws NoSuchElementException
    {
        if(current == null)
        {
            current = firstNode;
            return  (E) current.getElement();
        }
        else if(current.getNext() == null)
            throw new NoSuchElementException("No next element");
        current = current.getNext();
        return (E) current.getElement();
    }

    @Override
    public void remove() throws UnsupportedOperationException
    {

    }
}
