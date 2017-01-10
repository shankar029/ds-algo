package com.shankark.ds.impl;

import org.junit.Test;

import com.shankark.ds.Deque;
import com.shankark.ds.QueueEmptyException;
import com.shankark.ds.QueueFullException;

import static junit.framework.Assert.*;

public class LinkedListBasedDequeTest {

	@Test
	public void testSanity() throws Exception {
		Deque dq = new LinkedListBasedDeque();

		assertTrue("Deque is not empty", dq.isEmpty());
		assertEquals("Deque size is not 0", 0, dq.size());

		dq.insertFirst("a");
		assertFalse("Deque is empty", dq.isEmpty());
		assertEquals("Deque size is not 1", 1, dq.size());

		dq.insertLast("b");
		assertEquals("Deque size is not 2", 2, dq.size());
		assertEquals("Deque first element doesn't match", "a", dq.removeFirst());
		assertEquals("Deque size is not 1", 1, dq.size());
		assertEquals("Deque second element doesn't match", "b", dq.removeFirst());
		assertTrue("Deque is not empty", dq.isEmpty());
	}

	@Test(expected = QueueFullException.class)
	public void testInsertFirstQueueFull() throws Exception {
		Deque dq = new LinkedListBasedDeque(2);
		dq.insertFirst("a");
		dq.insertFirst("b");
		dq.insertFirst("c");
	}

	@Test
	public void testInsertFirst() throws Exception {
		Deque dq = new LinkedListBasedDeque();
		dq.insertFirst("a");
		dq.insertFirst("b");
		dq.insertFirst("c");
		dq.insertFirst("d");
		assertEquals("Deque first element doesn't match", "d", dq.removeFirst());
		assertEquals("Deque second element doesn't match", "c", dq.removeFirst());
		assertEquals("Deque third element doesn't match", "b", dq.removeFirst());
		assertEquals("Deque fourth element doesn't match", "a", dq.removeFirst());
		assertTrue("Deque is not empty", dq.isEmpty());

		dq.insertFirst("a");
		dq.insertFirst("b");
		dq.insertFirst("c");
		dq.insertFirst("d");
		assertEquals("Deque first element doesn't match", "a", dq.removeLast());
		assertEquals("Deque second element doesn't match", "b", dq.removeLast());
		assertEquals("Deque third element doesn't match", "c", dq.removeLast());
		assertEquals("Deque fourth element doesn't match", "d", dq.removeLast());
		assertTrue("Deque is not empty", dq.isEmpty());
	}

	@Test(expected = QueueFullException.class)
	public void testInsertLastQueueFull() throws Exception {
		Deque dq = new LinkedListBasedDeque(2);
		dq.insertLast("a");
		dq.insertLast("b");
		dq.insertLast("c");
	}

	@Test
	public void testInsertLast() throws Exception {
		Deque dq = new LinkedListBasedDeque();
		dq.insertLast("a");
		dq.insertLast("b");
		dq.insertLast("c");
		dq.insertLast("d");
		assertEquals("Deque first element doesn't match", "a", dq.removeFirst());
		assertEquals("Deque second element doesn't match", "b", dq.removeFirst());
		assertEquals("Deque third element doesn't match", "c", dq.removeFirst());
		assertEquals("Deque fourth element doesn't match", "d", dq.removeFirst());
		assertTrue("Deque is not empty", dq.isEmpty());

		dq.insertLast("a");
		dq.insertLast("b");
		dq.insertLast("c");
		dq.insertLast("d");

		assertEquals("Deque first element doesn't match", "d", dq.removeLast());
		assertEquals("Deque second element doesn't match", "c", dq.removeLast());
		assertEquals("Deque third element doesn't match", "b", dq.removeLast());
		assertEquals("Deque fourth element doesn't match", "a", dq.removeLast());
		assertTrue("Deque is not empty", dq.isEmpty());
	}

	@Test(expected = QueueEmptyException.class)
	public void testRemoveFirstQueueEmpty() throws Exception {
		Deque dq = new LinkedListBasedDeque();
		dq.removeFirst();
	}

	@Test(expected = QueueEmptyException.class)
	public void testRemoveLastQueueEmpty() throws Exception {
		Deque dq = new LinkedListBasedDeque();
		dq.removeLast();
	}

	@Test(expected = QueueEmptyException.class)
	public void testFirstQueueEmpty() throws Exception {
		Deque dq = new LinkedListBasedDeque();
		dq.first();
	}

	@Test
	public void testFirst() throws Exception {
		Deque dq = new LinkedListBasedDeque();
		dq.insertLast("a");
		dq.insertLast("b");
		assertEquals("First element doesn't match", "a", dq.first());
		assertEquals("first() removed the element", 2, dq.size());
	}

	@Test
	public void testLast() throws Exception {
		Deque dq = new LinkedListBasedDeque();
		dq.insertLast("a");
		dq.insertLast("b");
		assertEquals("Last element doesn't match", "b", dq.last());
		assertEquals("last() removed the element", 2, dq.size());
	}

	@Test(expected = QueueEmptyException.class)
	public void testLastQueueEmpty() throws Exception {
		Deque dq = new LinkedListBasedDeque();
		dq.last();
	}
}
