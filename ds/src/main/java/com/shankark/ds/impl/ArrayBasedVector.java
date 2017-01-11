package com.shankark.ds.impl;

import java.util.Arrays;

import com.shankark.ds.Vector;

/**
 * An implementation of vector data structure using array.
 * 
 * @author shankarkumar
 *
 */
public class ArrayBasedVector implements Vector {

	private static final int DEFAULT_INITIAL_SIZE = 10;
	private int size;
	private int n;
	private Object[] a;

	public ArrayBasedVector() {
		this(DEFAULT_INITIAL_SIZE);
	}

	public ArrayBasedVector(int initialSize) {
		this.size = initialSize;
		this.a = new Object[size];
	}

	public Object elementAtRank(int rank) {
		return a[rank];
	}

	public void replaceAtRank(int rank, Object e) {
		a[rank] = e;
	}

	public void insertAtRank(int rank, Object e) {
		if (size >= n) {
			increaseCapacity(size * 2);
		}
		if (a[rank] != null) { // if already there is an element at rank
			// move them all to right by one position
			for (int i = (n - 1); i >= rank; i--) {
				a[i + 1] = a[i];
			}
		}
		a[rank] = e;
		++n;
	}

	public void removeAtRank(int rank) {
		// move all the element to left by one position from rank
		for (int i = rank; i < n; i++) {
			a[i] = a[i + 1];
		}
		--n;
	}

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return (n == 0);
	}

	@Override
	public String toString() {
		return Arrays.toString(a);
	}

	// --------- private methods ----------------
	private void increaseCapacity(int newSize) {
		Object[] t = new Object[newSize];
		copy(a, t);
		a = t;
	}

	private void copy(Object[] src, Object[] dest) {
		if (src != null && dest != null) {
			for (int i = 0; i < src.length; i++) {
				dest[i] = src[i];
			}
		}
	}

}
