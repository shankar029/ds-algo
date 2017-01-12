package com.shankark.search;

/**
 * Implementation of linear search. Search array need not be required to in
 * sorted order.
 * <p>
 * Worst case time complexity - O(n). <br />
 * In worst case, we may have to check all the elements in the array if the
 * element doesn't exists or element is in the last position in the array.
 * </p>
 * 
 * @author shankarkumar
 *
 */
public class LinearSearch {

	/**
	 * Searches for the element e in array a linearly.
	 * 
	 * @param a
	 *            Integer search array
	 * @param e
	 *            Element to be searched
	 * @return Index of element e in array if found otherwise -1
	 */
	public int search(int[] a, int e) {
		if (a == null || a.length == 0) {
			throw new IllegalArgumentException("Search array is null or empty");
		}
		int j = 0;
		while (j < a.length && a[j] != e) {
			++j;
		}
		if (j < a.length) {
			return j;
		} else {
			return -1;
		}
	}
}
