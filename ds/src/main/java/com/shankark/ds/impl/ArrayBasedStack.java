package com.shankark.ds.impl;

import com.shankark.ds.Stack;
import com.shankark.ds.StackEmptyException;

/**
 * An array implementation of Stack data structure. <br>
 * 
 * This implementation of stack increase the array size when it is full. Array
 * size is increased by double the current size.
 * 
 * @author shankarkumar
 *
 */
public class ArrayBasedStack implements Stack {
	private static final int DEFAULT_INITIAL_SIZE = 1024;
	private int size = 0;
	private Object[] a;
	private int top = -1;

	public ArrayBasedStack() {
		this(DEFAULT_INITIAL_SIZE);
	}

	public ArrayBasedStack(int initialSize) {
		this.size = initialSize;
		this.a = new Object[size];
	}

	public void push(Object o) {
		if ((top + 1) == size) {
			// if array is full, increase the capacity
			ensureCapacity();
		}
		a[++top] = o;
	}

	public Object pop() throws StackEmptyException {
		if (top == -1) {
			throw new StackEmptyException("Stack is empty");
		}
		Object o = a[top];
		a[top] = null;
		top--;
		return o;
	}

	public Object top() throws StackEmptyException {
		if (top == -1) {
			throw new StackEmptyException("Stack is empty");
		}
		return a[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public int size() {
		return (top + 1);
	}

	// ------------ private methods --------------

	private void ensureCapacity() {
		Object[] temp = new Object[size * 2];
		copy(a, temp);
		a = temp;
	}

	private void copy(Object[] src, Object[] dest) {
		if (src != null && dest != null) {
			for (int i = 0; i < src.length; i++) {
				dest[i] = src[i];
			}
		}
	}
}
