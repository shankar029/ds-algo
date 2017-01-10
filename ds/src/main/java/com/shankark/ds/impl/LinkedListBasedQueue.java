package com.shankark.ds.impl;

import com.shankark.ds.Queue;
import com.shankark.ds.QueueEmptyException;
import com.shankark.ds.QueueFullException;

/**
 * Queue data structure implementation using linked list.
 * 
 * @author shankarkumar
 *
 */
public class LinkedListBasedQueue implements Queue {

	/**
	 * Represents a node in linked list.
	 * 
	 * @author shankarkumar
	 *
	 */
	private static class Node {
		private Object data;
		private Node next;

		Node(Object data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private static final int DEFAULT_SIZE = 1024;
	private Node head;
	private Node tail;
	private int n;
	private int size;

	public LinkedListBasedQueue() {
		this(DEFAULT_SIZE);
	}

	public LinkedListBasedQueue(int size) {
		this.size = size;
	}

	public void enqueue(Object o) throws QueueFullException {
		if (n == size) {
			throw new QueueFullException("Queue is full");
		}

		Node node = new Node(o, null);
		if (isEmpty()) { // head & tail will be null
			head = tail = node;
		} else {
			tail.next = node; // chain the linked list
			tail = node; // move the tail pointer to the new node
		}
		n++;
	}

	public Object dequeue() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException("Queue is empty");
		}
		Node node = head;
		head = head.next; // move the head pointer to next node
		node.next = null; // GC
		n--;
		return node.data;
	}

	public Object front() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException("Queue is empty");
		}
		return head.data;
	}

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return (n == 0);
	}

}
