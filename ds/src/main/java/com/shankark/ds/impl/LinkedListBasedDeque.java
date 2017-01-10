package com.shankark.ds.impl;

import com.shankark.ds.Deque;
import com.shankark.ds.QueueEmptyException;
import com.shankark.ds.QueueFullException;

/**
 * Implementation of Deque using doubly linked list.
 * 
 * @author shankarkumar
 *
 */
public class LinkedListBasedDeque implements Deque {

	/**
	 * Represents a node in doubly linked list.
	 * 
	 * @author shankarkumar
	 *
	 */
	private static class Node {
		private Object data;
		private Node next;
		private Node prev;

		Node(Object data, Node prev, Node next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}

	private static final int DEFAULT_SIZE = 1024;
	private int size;
	private int n;
	private Node head;
	private Node tail;

	public LinkedListBasedDeque() {
		this(DEFAULT_SIZE);
	}

	public LinkedListBasedDeque(int size) {
		this.size = size;
		this.head = new Node(null, null, null);
		this.tail = new Node(null, null, null);
	}

	public void insertFirst(Object o) throws QueueFullException {
		if (n == size) {
			throw new QueueFullException("Queue is full");
		}
		// new node's prev points to head and next points to first node
		Node node = new Node(o, head, head.next);
		if (head.next != null) { // if queue is not empty
			// first node's (head.next) prev points to new node
			head.next.prev = node;
		}
		// head's next point to new node
		head.next = node;
		n++;
	}

	public void insertLast(Object o) throws QueueFullException {
		if (n == size) {
			throw new QueueFullException("Queue is full");
		}
		// New node's prev points to last node (i.e, tail's prev) and next
		// points to tail
		Node node = new Node(o, tail.prev, tail);
		if (tail.prev != null) { // if queue is not empty
			// last node's (i.e, tail.prev) next points to new node
			tail.prev.next = node;
		}
		// tail's prev points to new node
		tail.prev = node;

	}

	public Object removeFirst() throws QueueEmptyException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object removeLast() throws QueueEmptyException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object first() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException("Queue is empty");
		}
		return head.next.data;
	}

	public Object last() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException("Queue is empty");
		}
		return tail.prev.data;
	}

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return (n == 0);
	}
}
