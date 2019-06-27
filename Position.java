package assignment_2;

public interface Position<E>
{
    E getElement() throws IllegalStateException;
}