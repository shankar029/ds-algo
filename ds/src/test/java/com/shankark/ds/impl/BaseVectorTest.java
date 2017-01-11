package com.shankark.ds.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.shankark.ds.BoundaryViolationException;
import com.shankark.ds.Vector;

public abstract class BaseVectorTest {

	protected abstract Vector createVector();

	@Test
	public void testSanity() throws Exception {
		Vector v = createVector();
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

	@Test(expected = BoundaryViolationException.class)
	public void testInsertAtRankBoundaryViolation() throws Exception {
		Vector v = new ArrayBasedVector(3);
		v.insertAtRank(5, "a");
	}

	@Test(expected = BoundaryViolationException.class)
	public void testRemoveAtRankBoundaryViolation() throws Exception {
		Vector v = new ArrayBasedVector(3);
		v.removeAtRank(5);
	}

	@Test(expected = BoundaryViolationException.class)
	public void testElementAtRankBoundaryViolation() throws Exception {
		Vector v = new ArrayBasedVector(3);
		v.elementAtRank(5);
	}

	@Test(expected = BoundaryViolationException.class)
	public void testReplaceAtRankBoundaryViolation() throws Exception {
		Vector v = new ArrayBasedVector(3);
		v.replaceAtRank(5, "e");
	}
}
