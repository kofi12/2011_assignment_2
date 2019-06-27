package assignment_2;

public interface Position<E>
{

    /**
     * Returns the element stored in position.
     * @return element stored at this position.
     * @throws IllegalStateException
     */
    E getElement() throws IllegalStateException;
}
