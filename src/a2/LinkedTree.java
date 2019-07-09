package a2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedTree<E> implements Tree<E>
{
    protected TreePosition<E> root;
    protected NodePositionalList<E> children;
    protected int size = 0;

    @Override
    public Position<E> root() {return root;}

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException
    {
        TreePosition<E> parent = null;
		try {
			parent = checkPosition(p);
		} catch (InvalidPositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
//        TreePosition<E> newT = checkPosition(p);

//        return newT.getChildren().size();
    	
    	try {
    		return checkPosition(p).getChildren().size();
    	} catch (InvalidPositionException ipe) {
    		ipe.printStackTrace();
    		return -1;
    	}
    }

    @Override
    public boolean isInternal(Position<E> p) throws IllegalArgumentException
    {
//        TreePosition<E> newT = checkPosition(p);

//        return numChildren(newT) > 0;
    	
    	try {
			return numChildren(checkPosition(p)) > 0;
		} catch (InvalidPositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }

    @Override
    public boolean isExternal(Position<E> p) throws IllegalArgumentException
    {
        TreePosition<E> newT;
		try {
			newT = checkPosition(p);
		} catch (InvalidPositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; //returns false if it don't work
		}

        return numChildren(newT) == 0;
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalArgumentException
    {
//        TreePosition<E> newT = checkPosition(p);
        
        
        try {
			return checkPosition(p).getParent() == null;
		} catch (InvalidPositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; //if it dont work
		}
    }

    @Override
    public int size() {return size;}

    @Override
    public boolean isEmpty() {return size == 0;}

    private TreePosition<E> checkPosition(Position<E> v) throws InvalidPositionException
    {
        if(v == null || !(v instanceof TreePosition))
            throw new InvalidPositionException("Position Invalid");
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
        root = createNode(e, null, new NodePositionalList());
        size = 1;
        return root;
    }

    protected TreePosition<E> createNode(E element, TreePosition<E> parent, PositionalList<Position<E>> children)
    {
    	size++;
    	return new TreeNode<E>(element, parent, children);
    }


    // we sure this is correct!!!!
    public void swapElements(Position<E> v, Position<E> w)
    {
    	E e1; //#StopVariableAbuse
    	
    	e1 = v.getElement();
    	try {
			checkPosition(v).setElement(w.getElement());
			checkPosition(w).setElement(e1);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


    // needs to be repurposed for use in toString() method!!!
    public static <E> String parenthesize(Tree<E> T, Position<E> p)
    {
    	String sTree = "";
        sTree += p.getElement();
        if(T.isInternal(p))
        {
            boolean firstTime = true;
            for(Position<E> c : T.children(p))
            {
                sTree += ((firstTime ? " (" : ", "));
                firstTime = false;
                parenthesize(T, c);
            }
            sTree += (")");
        }
        
        return sTree;
    }


    // TODO
    @Override
    public String toString()
    {
        return parenthesize(this, root());
    }
}
