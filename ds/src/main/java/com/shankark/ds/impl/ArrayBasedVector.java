package com.shankark.ds.impl;

import java.util.Arrays;

import com.shankark.ds.BoundaryViolationException;
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

	/**
	 * Time complexity: Worst case : O(1)
	 */
	public Object elementAtRank(int rank) throws BoundaryViolationException {
		checkForBoundaryCondition(rank);

		return a[rank];
	}

	/**
	 * Time complexity: Worst case : O(1)
	 */
	public void replaceAtRank(int rank, Object e) throws BoundaryViolationException {
		checkForBoundaryCondition(rank);

		a[rank] = e;
	}

	/**
	 * Time complexity: Worst case : O(n)
	 * <p>
	 * In worst case, all the elements may have to shift right.
	 * </p>
	 */
	public void insertAtRank(int rank, Object e) throws BoundaryViolationException {
		checkForBoundaryCondition(rank);

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

	/**
	 * Time complexity: Worst case : O(n)
	 * <p>
	 * In worst case, all the elements may have to shift left.
	 * </p>
	 */
	public void removeAtRank(int rank) throws BoundaryViolationException {
		checkForBoundaryCondition(rank);

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
	private void checkForBoundaryCondition(int rank) throws BoundaryViolationException {
		if (rank < 0 || rank > size()) {
			throw new BoundaryViolationException("Rank [" + rank + "] is out of the vector boundary");
		}
	}

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
