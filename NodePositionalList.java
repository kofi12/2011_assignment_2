package assignment_2;

import java.util.Iterator;

public class NodePositionalList<E> implements PositionalList<E>, Iterable<E>
{
    
	private DNode<E> head; 
    private DNode<E> tail;
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
        return p.getPrev();
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException
    {
        return p.getNext();
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
    
    private DNode<E> validate(Position<E p>) throws IllegalArgumentException
    {
    	if(!(p instanceof DNode)) throw new IllegalArgumentException("Invalid p");
    	Dnode<E> node = (DNode<E>) p;
    	if(node.getNext() == null)
    		throw new IllegalArgumentException("p is no longer in the list");
    	return node;
    }
    
    private Position<E> position(Node<E> node)
    {
    	if(node == head || node == tail)
    		return null;
    	return node;
    }
    
    protected Position<E> checkPosition(Position<E> v) throws InvalidPositionException
    {
    	if(v == null || !(v instanceof DNode))
    		throw new InvalidPositionException("The position is invalid");
    	return v;
    }
}
