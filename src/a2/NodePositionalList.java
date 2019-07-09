package a2;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
        return position(head.getNext());
    }

    @Override
    public Position<E> last()
    {

        return position(tail.getPrev());
    }

    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException
    {
        DNode<E> newNode = validate(p);
        return position(newNode.getPrev());
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException
    {
        DNode<E> newNode = validate(p);
        return position(newNode.getNext());
    }

    @Override
    public Position<E> addFirst(E e)
    {
        return addBetween(e, head, head.getNext());
    }

    @Override
    public Position<E> addLast(E e)
    {
        return addBetween(e, tail.getPrev(), tail);
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException
    {
        DNode<E> node = validate(p);
    	return addBetween(e, node.getPrev(), node);
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException
    {
        DNode<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException
    {
        DNode<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }

    @Override
    public E remove(Position<E> p) throws IllegalArgumentException
    {
        DNode<E> node = validate(p);
        DNode<E> predecessor = node.getPrev();
        DNode<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        E answer = node.getElement();
        node.setElement(null);
        node.setPrev(null);
        node.setNext(null);
        return answer;
    }

    @Override
    public Iterator<E> iterator()
    {
        return new ElementIterator(); // TODO
    }

    private DNode<E> validate(Position<E> p) throws IllegalArgumentException
    {
    	if(!(p instanceof DNode)) throw new IllegalArgumentException("Invalid p");
    	DNode<E> node = (DNode<E>) p;
    	if(node.getNext() == null)
    		throw new IllegalArgumentException("p is no longer in the list");
    	return node;
    }
    
    private Position<E> position(DNode<E> node)
    {
    	if(node == head || node == tail)
    		return null;
    	return node;
    }
    
    protected Position<E> checkPosition(Position<E> v)
    {
    	if(v == null || !(v instanceof DNode))
    		System.out.println("The position is invalid");
    	return v;
    }

    private Position<E> addBetween(E e, DNode<E> pred, DNode<E> succ)
    {
        DNode<E> newest = new DNode<E>(e, pred, succ);
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        return newest;
    }

    private class PositionIterator implements Iterator<Position<E>>
    {
        private Position<E> cursor = first();
        private Position<E> recent = null;

        @Override
        public boolean hasNext()
        {
            return cursor != null;
        }

        public Position<E> next() throws NoSuchElementException
        {
            if (cursor == null) throw new NoSuchElementException("nothing left");
            recent = cursor;
            cursor =  after(cursor);
            return recent;
        }

        public void remove() throws UnsupportedOperationException
        {

        }
    }
    
    private class PositionIterable implements Iterable<Position<E>>
    {
        public Iterator<Position<E>> iterator()
        {
            return new PositionIterator();
        }
    }
    
    public Iterable<Position<E>> positions()
    {
        return new PositionIterable();
    }
    
    private class ElementIterator implements Iterator<E>
    {
        Iterator<Position<E>> posIterator = new PositionIterator();

        public boolean hasNext()
        {
            return posIterator.hasNext();
        }

        public E next()
        {
            return posIterator.next().getElement();
        }
    }
}
