package com.shankark.search;

import org.junit.Test;

import junit.framework.Assert;

public class LinearSearchTest {

	@Test
	public void testSearch() throws Exception {
		LinearSearch s = new LinearSearch();
		Assert.assertEquals("Index doesn't match ", 0, s.search(new int[] { 5, 2, 4, 6, 9 }, 5));
		Assert.assertEquals("Index doesn't match ", 4, s.search(new int[] { 5, 2, 4, 6, 9 }, 9));
		Assert.assertEquals("Index doesn't match ", 2, s.search(new int[] { 5, 2, 4, 6, 9 }, 4));
		Assert.assertEquals("Index doesn't match ", -1, s.search(new int[] { 5, 2, 4, 6, 9 }, 8));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSearchCaseNullArray() throws Exception {
		LinearSearch s = new LinearSearch();
		s.search(null, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSearchCaseEmptyArray() throws Exception {
		LinearSearch s = new LinearSearch();
		s.search(new int[] {}, 1);
	}

}
