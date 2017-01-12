package com.shankark.search;

/**
 * Binary search algorithm implementation. Searches for a element in a
 * ordered/sorted array.
 * <p>
 * Time complexity: Worst case - O(log n) <br/>
 * In each iteration, the range of items to searched is halved.
 * </p>
 * 
 * @author shankarkumar
 *
 */
public class BinarySearch {

	public BinarySearch() {
	}

	/**
	 * Returns the index of the value e in the sorted array elements.
	 * 
	 * @param elements
	 *            A sorted integer array
	 * @param e
	 *            Element to be searched
	 * @return Index of value element e in the array elements if found otherwise
	 *         -1
	 */
	public int search(int[] elements, int e) {
		if (elements == null || elements.length == 0) {
			throw new IllegalArgumentException("Array elements is NULL or doesn't contains value");
		}
		return search(elements, e, 0, elements.length - 1);
	}

	private int search(int[] a, int e, int low, int high) {
		if (low > high) {
			return -1;
		} else {
			int mid = (low + high) / 2;
			if (e == a[mid]) {
				return mid;
			} else if (e < a[mid]) {
				return search(a, e, low, mid - 1);
			} else {
				return search(a, e, mid + 1, high);
			}
		}
	}
}
