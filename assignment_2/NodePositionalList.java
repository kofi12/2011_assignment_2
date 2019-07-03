package assignment_2;

import java.util.Iterator;

public class NodePositionalList<E> implements PositionalList<E>, Iterable<Position<E>> {
	Dnode<E> head;
	Dnode<E> tail;
	private int size;

	// Replacing Dnode.java
	// ---------------- nested Dnode class ----------------
	private static class Dnode<E> implements Position<E> {

		private E element;
		// reference to the element stored at this node

		private Dnode<E> prev;
		// reference to the previous node in the list

		private Dnode<E> next;
		// reference to the subsequent node in the list

		public Dnode(E e, Dnode<E> p, Dnode<E> n) {
			element = e;
			prev = p;
			next = n;
		}

		public E getElement() throws IllegalStateException {
			if (next == null)
				// convention for defunct node
				throw new IllegalStateException("Position no longer valid");
			return element;
		}

		public Dnode<E> getPrev() {
			return prev;
		}

		public Dnode<E> getNext() {
			return next;
		}

		public void setElement(E e) {
			element = e;
		}

		public void setPrev(Dnode<E> p) {
			prev = p;
		}

		public void setNext(Dnode<E> n) {
			next = n;
		}
	} // ----------- end of nested Dnode class -----------

	/**
	 *
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 *
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 *
	 */
	@Override
	public Position<E> first() {
		if (isEmpty())
			return null;
		return head;
	}

	/**
	 *
	 */
	@Override
	public Position<E> last() {
		if (isEmpty())
			return null;
		return tail;
	}

	/**
	 *
	 */
	@Override
	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		Dnode<E> curr = head;
		while ((curr = curr.getNext()) != null) {

		}

		return null;
	}

	/**
	 *
	 */
	@Override
	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		return null;
	}

	/**
	 *
	 */
	@Override
	public Position<E> addFirst(E e) {
		return null;
	}

	/**
	 *
	 */
	@Override
	public Position<E> addLast(E e) {
		return null;
	}

	/**
	 *
	 */
	@Override
	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
		/*
		 * add before this position, means p.getPrev() is this node make a node
		 * node.prev is p.prev node.next is p p.prev is node
		 */

		Dnode<E> node = new Dnode<>(e, null, null);
		try { // Check if p is actually a Dnode
//    		checkPosition(p);
			node.setPrev(((Dnode<E>) (p)).getPrev());
		} catch (IllegalArgumentException iae) {
			iae.getStackTrace(); // Not sure if this is enough
		}

		return node;
	}

	/**
	 *
	 */
	@Override
	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
		return null;
	}

	/**
	 *
	 */
	@Override
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		return null;
	}

	/**
	 *
	 */
	@Override
	public E remove(Position<E> p) throws IllegalArgumentException {
		return null;
	}

	/**
	 *
	 */
	@Override
	public Iterator<Position<E>> iterator() {
		return null;
	}

	/**
	 * @return
	 */
	public Iterable<Position<E>> positions() {
		return null;
	}
}
