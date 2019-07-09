package a2;

public class TreeNode<E> implements TreePosition<E>
{
    private E element;
    private TreePosition<E> parent;
    private PositionalList<Position<E>> children;

    public TreeNode(E e, TreePosition<E> p, PositionalList<Position<E>> c)
    {
        element = e;
        parent = p;
        children = c;
    }

    @Override
    public void setElement(E e)
    {
        element = e;
    }

    @Override
    public PositionalList<Position<E>> getChildren()
    {
        return children;
    }

    @Override
    public void setChildren(PositionalList<Position<E>> c)
    {
        children = c;
    }

    @Override
    public TreePosition<E> getParent()
    {
        return parent;
    }

    @Override
    public void setParent(TreePosition<E> v)
    {
        parent = v;
    }

    @Override
    public E getElement() throws IllegalStateException
    {
        return element;
    }
}
