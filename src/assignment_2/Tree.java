package assignment_2;

import java.util.Iterator;

public interface Tree<E> extends Iterable<E>
{
    // returns the position of the root of the tree or null if empty
    Position<E> root();

    // returns the position of the parent of the position p or null if empty
    Position<E> parent(Position<E> p) throws IllegalArgumentException;

    // returns an iterable collection containing the children of position p if any
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;

    // returns the number of children of position p
    int numChildren(Position<E> p) throws IllegalArgumentException;

    // returns true if position p has at least one child
    boolean isInternal(Position<E> p) throws IllegalArgumentException;

    // returns true if position p has no children
    boolean isExternal(Position<E> p) throws IllegalArgumentException;

    // returns true if position p is the root of the tree
    boolean isRoot(Position<E> p) throws IllegalArgumentException;

    // returns number of positions contained in the tree
    int size();

    // returns true if the tree contains no positions
    boolean isEmpty();

    // returns an iterator for all elements in the tree ( so that the tree itself is Iterable)
    Iterator<E> iterator();

    // returns an iterable collection of all the positions of the tree
    Iterable<Position<E>> positions();
}
