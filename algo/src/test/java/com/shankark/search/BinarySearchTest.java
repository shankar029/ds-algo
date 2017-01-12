package com.shankark.search;

import org.junit.Test;

import static junit.framework.Assert.*;

public class BinarySearchTest {

	@Test
	public void testSearch() throws Exception {
		BinarySearch b = new BinarySearch();
		int i = b.search(new int[] { 2, 3, 6, 8, 9, 10 }, 2);
		assertEquals("Index doesn't match", 0, i);

		i = b.search(new int[] { 2, 3, 6, 8, 9, 10 }, 10);
		assertEquals("Index doesn't match", 5, i);

		i = b.search(new int[] { 2, 3, 6, 8, 9, 10 }, 6);
		assertEquals("Index doesn't match", 2, i);

		i = b.search(new int[] { 2, 3, 6, 8, 9, 10 }, 3);
		assertEquals("Index doesn't match", 1, i);

		i = b.search(new int[] { 2, 3, 6, 8, 9, 10 }, 9);
		assertEquals("Index doesn't match", 4, i);

		i = b.search(new int[] { 2, 3, 6, 8, 9, 10, 14 }, 8);
		assertEquals("Index doesn't match", 3, i);

		i = b.search(new int[] { 2, 3, 6, 8, 9, 10 }, 15);
		assertEquals("Index doesn't match", -1, i);

		i = b.search(new int[] { 2 }, 2);
		assertEquals("Index doesn't match", 0, i);

		i = b.search(new int[] { 2 }, 1);
		assertEquals("Index doesn't match", -1, i);
		
		i = b.search(new int[] { 2, 2 }, 2);
		assertEquals("Index doesn't match", 0, i);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSearchCaseNullArray() throws Exception {
		BinarySearch b = new BinarySearch();
		b.search(null, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSearchCaseEmptyArray() throws Exception {
		BinarySearch b = new BinarySearch();
		b.search(new int[] {}, 1);
	}
}
