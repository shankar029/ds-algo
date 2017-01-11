package com.shankark.ds.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.shankark.ds.Vector;

public class ArrayBasedVectorTest extends BaseVectorTest {

	@Override
	protected Vector createVector() {
		return new ArrayBasedVector();
	}

	@Test
	public void testOverflow() throws Exception {
		Vector v = new ArrayBasedVector(3);
		v.insertAtRank(0, "a");
		v.insertAtRank(1, "b");
		v.insertAtRank(2, "c");
		v.insertAtRank(3, "d");
		v.insertAtRank(2, "e");

		assertEquals("Vector size doesn't match", 5, v.size());
		assertEquals("Element doesn't match", "a", v.elementAtRank(0));
		assertEquals("Element doesn't match", "b", v.elementAtRank(1));
		assertEquals("Element doesn't match", "e", v.elementAtRank(2));
		assertEquals("Element doesn't match", "c", v.elementAtRank(3));
		assertEquals("Element doesn't match", "d", v.elementAtRank(4));

		v.removeAtRank(4);
		assertEquals("Element exists", null, v.elementAtRank(4));
		v.removeAtRank(1);
		assertEquals("Element doesn't match", "a", v.elementAtRank(0));
		assertEquals("Element doesn't match", "e", v.elementAtRank(1));
		assertEquals("Element doesn't match", "c", v.elementAtRank(2));
	}

}
