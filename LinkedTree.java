package assignment_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedTree<E> implements Tree<E>
{
    protected TreePosition<E> root;
    protected NodePositionalList<E> children;
    protected int size;

    @Override
    public Position<E> root() {return root;}

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException
    {
        TreePosition<E> parent = checkPosition(p);

        return parent.getParent();
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException
    {
        return children.positions();
    }

    @Override
    public int numChildren(Position<E> p) throws IllegalArgumentException
    {
        TreePosition<E> newT = checkPosition(p);

        return newT.getChildren().size();
    }

    @Override
    public boolean isInternal(Position<E> p) throws IllegalArgumentException
    {
        TreePosition<E> newT = checkPosition(p);

        return numChildren(newT) > 0;
    }

    @Override
    public boolean isExternal(Position<E> p) throws IllegalArgumentException
    {
        TreePosition<E> newT = checkPosition(p);

        return numChildren(newT) == 0;
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalArgumentException
    {
        TreePosition<E> newT = checkPosition(p);

        return newT.getParent() == null;
    }

    @Override
    public int size() {return size;}

    @Override
    public boolean isEmpty() {return size == 0;}

    private TreePosition<E> checkPosition(Position<E> v)
    {
        if(v == null || !(v instanceof TreePosition))
            ;
        return (TreePosition<E>) v;
    }

    private class TreeElementIterator implements Iterator<E>
    {
        Iterator<Position<E>> posIterator = positions().iterator();

        @Override
        public boolean hasNext() {return posIterator.hasNext();}

        @Override
        public E next() {return posIterator.next().getElement();}
    }

    @Override
    public Iterator<E> iterator() {return new TreeElementIterator();}

    @Override
    public Iterable<Position<E>> positions() {return preorder();}

    public Iterable<Position<E>> preorder()
    {
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty())
            preorderSubtree(root(), snapshot);
        return snapshot;
    }

    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot )
    {
        snapshot.add(p);
        for(Position<E> c : children(p))
            preorderSubtree(c, snapshot);
    }
}
