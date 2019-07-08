package assignment_2;

public interface TreePosition<E> extends Position<E>
{
    public void setElement(E e);

    public PositionalList<Position<E>> getChildren();

    public void setChildren(PositionalList<Position<E>> c);

    public TreePosition<E> getParent();

    public void setParent(TreePosition<E> v);
}
