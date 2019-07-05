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

    /* TODO
        change this to custom exception from the assignment
     */
    public Position<E> addRoot(E e) throws IllegalStateException
    {
        if(!isEmpty())
            throw new IllegalStateException("this tree is not empty");
        root = createNode(e, null, null);
        size = 1;
        return root;
    }

    protected TreePosition<E> createNode(E element, TreePosition<E> parent, PositionalList<Position<E>> children)
    {
        return new TreeNode<E>(element, parent, children);
    }


    //not sure if this is correct!!!!
    public void swapElements(Position<E> v, Position<E> w)
    {
        TreePosition<E> tempV = checkPosition(v);
        TreePosition<E> tempW = checkPosition(w);
        tempV.setElement(w.getElement());
        tempW.setElement(v.getElement());
    }


    // needs to be repurposed for use in toString() method!!!
    public static <E> void parenthesize(Tree<E> T, Position<E> p)
    {
        System.out.println(p.getElement());
        if(T.isInternal(p))
        {
            boolean firstTime = true;
            for(Position<E> c : T.children(p))
            {
                System.out.println((firstTime ? " (" : ", "));
                firstTime = false;
                parenthesize(T, c);
            }
            System.out.println(")");
        }
    }


    // TODO
    @Override
    public String toString()
    {
        return "LinkedTree{}";
    }
}
