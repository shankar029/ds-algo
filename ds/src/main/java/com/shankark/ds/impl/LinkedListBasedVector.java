package com.shankark.ds.impl;

import com.shankark.ds.BoundaryViolationException;
import com.shankark.ds.Vector;

/**
 * Implementation of vector data structure using doubly linked list.
 * 
 * @author shankarkumar
 *
 */
public class LinkedListBasedVector implements Vector {

	/**
	 * Doubly linked list node.
	 * 
	 * @author shankarkumar
	 *
	 */
	private static class DLNode {
		private Object data;
		private DLNode prev;
		private DLNode next;

		public DLNode(Object data, DLNode prev, DLNode next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}

	private int n = 0;
	private DLNode head;
	private DLNode tail;

	public LinkedListBasedVector() {
		this.head = new DLNode(null, null, null);
		this.tail = new DLNode(null, null, null);
	}

	/**
	 * Time complexity: Worst case : O(n)
	 * <p>
	 * Worst case of nodeAtRank() is O(n)
	 * </p>
	 */
	public Object elementAtRank(int rank) throws BoundaryViolationException {
		checkForBoundaryCondition(rank);

		return nodeAtRank(rank).data;
	}

	/**
	 * Time complexity: Worst case : O(n)
	 * <p>
	 * Worst case of nodeAtRank() is O(n)
	 * </p>
	 */
	public void replaceAtRank(int rank, Object e) throws BoundaryViolationException {
		checkForBoundaryCondition(rank);
		nodeAtRank(rank).data = e;
	}

	/**
	 * Time complexity: Worst case : O(n)
	 * <p>
	 * Worst case of nodeAtRank() is O(n)
	 * </p>
	 */
	public void insertAtRank(int rank, Object e) throws BoundaryViolationException {
		checkForBoundaryCondition(rank);

		DLNode node = new DLNode(e, null, null);
		if (isEmpty()) {
			head.next = node;
			tail.prev = node;

			node.prev = head;
			node.next = tail;
		} else {
			DLNode next = nodeAtRank(rank);
			DLNode prev = next.prev;
			node.prev = prev;
			node.next = next;

			prev.next = node;
			next.prev = node;
		}
		++n;
	}

	/**
	 * Time complexity: Worst case : O(n)
	 * <p>
	 * Worst case of nodeAtRank() is O(n)
	 * </p>
	 */
	public void removeAtRank(int rank) throws BoundaryViolationException {
		checkForBoundaryCondition(rank);

		DLNode node = nodeAtRank(rank);
		if (node == null) {
			return;
		}
		DLNode next = node.next;
		DLNode prev = node.prev;

		prev.next = next;
		next.prev = prev;
		node.prev = node.next = null; // GC
		--n;
	}

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return (n == 0);
	}

	// ----------- private methods ------------
	/**
	 * Time complexity: Worst case : O(n)
	 * <p>
	 * In worst case, this api may have to travel through all the elements in
	 * the list.
	 * </p>
	 * 
	 */
	private DLNode nodeAtRank(int rank) throws BoundaryViolationException {
		DLNode node = head.next;
		for (int i = 0; i < rank; i++) {
			node = node.next;
		}
		
//		if (rank < (n / 2)) {
//			node = head.next;
//			for (int i = 0; i < rank; i++) {
//				node = node.next;
//			}
//		} else {
//			node = tail.prev;
//			for (int i = (n - 1); i > rank; i--) {
//				node = node.prev;
//			}
//		}
		return node;
	}

	private void checkForBoundaryCondition(int rank) throws BoundaryViolationException {
		if (rank < 0 || rank > size()) {
			throw new BoundaryViolationException("Rank [" + rank + "] is out of the vector boundary");
		}
	}
}
