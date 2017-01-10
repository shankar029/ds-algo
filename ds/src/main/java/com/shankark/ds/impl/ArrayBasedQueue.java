package com.shankark.ds.impl;

import com.shankark.ds.Queue;
import com.shankark.ds.QueueEmptyException;
import com.shankark.ds.QueueFullException;

/**
 * Queue implementation using Array.
 * 
 * @author shankarkumar
 *
 */
public class ArrayBasedQueue implements Queue {

	private static final int DEFAULT_SIZE = 1024;
	private Object[] a;
	private int n = 0;
	private int f = 0;
	private int r = 0;

	public ArrayBasedQueue() {
		this(DEFAULT_SIZE);
	}

	public ArrayBasedQueue(int size) {
		this.a = new Object[size];
	}

	public void enqueue(Object o) throws QueueFullException {
		if (a.length == n) {
			throw new QueueFullException("Queue is full");
		}
		a[r] = o;
		n++;
		r = (r + 1) % a.length;
	}

	public Object dequeue() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException("Queue is empty");
		}
		Object o = a[f];
		a[f] = null;
		n--;
		f = (f + 1) % a.length;
		return o;
	}

	public Object front() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException("Queue is empty");
		}
		return a[f];
	}

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return (n == 0);
	}

}
