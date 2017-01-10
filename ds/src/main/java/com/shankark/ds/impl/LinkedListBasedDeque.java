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
		Node node = new Node(o, head, null);
		if (isEmpty()) {
			head.next = node;
			tail.prev = node;
			node.next = tail;
		} else {
			node.next = head.next;
			head.next = node;
			node.next.prev = node;
		}
		n++;
	}

	public void insertLast(Object o) throws QueueFullException {
		if (n == size) {
			throw new QueueFullException("Queue is full");
		}

		Node node = new Node(o, null, tail);
		if (isEmpty()) {
			head.next = node;
			tail.prev = node;
			node.prev = head;
		} else {
			node.prev = tail.prev;
			node.prev.next = node;
			tail.prev = node;
		}
		n++;
	}

	public Object removeFirst() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException("Queue is empty");
		}

		Node first = head.next;
		if (size == 1) {
			head.next = null;
			tail.prev = null;
		} else {
			head.next = first.next;
			first.next.prev = head;
		}
		first.next = null; // GC
		first.prev = null; // GC
		n--;
		return first.data;
	}

	public Object removeLast() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException("Queue is empty");
		}

		Node last = tail.prev;
		if (size == 1) {
			head.next = null;
			tail.prev = null;
		} else {
			tail.prev = last.prev;
			last.prev.next = tail;
		}
		last.next = null; // GC
		last.prev = null; // GC
		n--;
		return last.data;
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
