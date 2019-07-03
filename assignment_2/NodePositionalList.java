package assignment_2;

import java.util.Iterator;

public class NodePositionalList<E> implements PositionalList<E>, Iterable<Position<E>> {
	DNode<E> head;
	DNode<E> tail;
	private int size;

	// Replacing DNode.java
	// ---------------- nested DNode class ----------------
	private static class DNode<E> implements Position<E> {

		private E element;
		// reference to the element stored at this node

		private DNode<E> prev;
		// reference to the previous node in the list

		private DNode<E> next;
		// reference to the subsequent node in the list

		public DNode(E e, DNode<E> p, DNode<E> n) {
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

		public DNode<E> getPrev() {
			return prev;
		}

		public DNode<E> getNext() {
			return next;
		}

		public void setElement(E e) {
			element = e;
		}

		public void setPrev(DNode<E> p) {
			prev = p;
		}

		public void setNext(DNode<E> n) {
			next = n;
		}
	} // ----------- end of nested DNode class -----------

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
		DNode<E> curr = head;
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

		DNode<E> node = new DNode<>(e, null, null);
		try { // Check if p is actually a DNode
//    		checkPosition(p);
			node.setPrev(((DNode<E>) (p)).getPrev());
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
