package com.shankark.ds.impl;

import static org.junit.Assert.*;
import org.junit.Test;

import com.shankark.ds.Vector;

public class ArrayBasedVectorTest {

	@Test
	public void testSanity() throws Exception {
		Vector v = new ArrayBasedVector();
		assertTrue("Vector is not empty", v.isEmpty());
		assertEquals("Vector size doesn't match", 0, v.size());

		v.insertAtRank(0, "a");
		assertFalse("Element is NULL", (v.elementAtRank(0) == null));
		assertEquals("Element doesn't match", "a", v.elementAtRank(0));
		assertEquals("Vector size doesn't match", 1, v.size());

		v.removeAtRank(0);
		assertEquals("Vector size doesn't match", 0, v.size());
		assertTrue("Vector is not empty", v.isEmpty());
		assertEquals("Element exists", null, v.elementAtRank(0));

		v.insertAtRank(0, "a");
		v.insertAtRank(1, "b");
		v.insertAtRank(2, "c");
		v.insertAtRank(3, "d");

		assertEquals("Element doesn't match", "a", v.elementAtRank(0));
		assertEquals("Element doesn't match", "b", v.elementAtRank(1));
		assertEquals("Element doesn't match", "c", v.elementAtRank(2));
		assertEquals("Element doesn't match", "d", v.elementAtRank(3));
		assertEquals("Vector size doesn't match", 4, v.size());

		v.removeAtRank(1);
		assertEquals("Vector size doesn't match", 3, v.size());
		assertEquals("Element doesn't match", "a", v.elementAtRank(0));
		assertEquals("Element doesn't match", "c", v.elementAtRank(1));
		assertEquals("Element doesn't match", "d", v.elementAtRank(2));
	}

	@Test
	public void testOverflow() throws Exception {
		Vector v = new ArrayBasedVector(3);
		v.insertAtRank(0, "a");
		v.insertAtRank(1, "b");
		v.insertAtRank(2, "c");
		v.insertAtRank(3, "d");
		v.insertAtRank(4, "e");

		assertEquals("Vector size doesn't match", 5, v.size());
		assertEquals("Element doesn't match", "a", v.elementAtRank(0));
		assertEquals("Element doesn't match", "b", v.elementAtRank(1));
		assertEquals("Element doesn't match", "c", v.elementAtRank(2));
		assertEquals("Element doesn't match", "d", v.elementAtRank(3));
		assertEquals("Element doesn't match", "e", v.elementAtRank(4));

		v.removeAtRank(4);
		assertEquals("Element exists", null, v.elementAtRank(4));
		v.removeAtRank(1);
		assertEquals("Element doesn't match", "a", v.elementAtRank(0));
		assertEquals("Element doesn't match", "c", v.elementAtRank(1));
		assertEquals("Element doesn't match", "d", v.elementAtRank(2));
	}
}
