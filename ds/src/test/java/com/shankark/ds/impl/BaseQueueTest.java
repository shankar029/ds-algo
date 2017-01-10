package com.shankark.ds.impl;

import org.junit.Test;

import com.shankark.ds.Queue;
import com.shankark.ds.QueueEmptyException;
import com.shankark.ds.QueueFullException;

import junit.framework.Assert;

public abstract class BaseQueueTest {

	protected abstract Queue createQueue();

	protected abstract Queue createQueue(int size);

	@Test
	public void testSanity() throws Exception {
		Queue q = createQueue(5);
		Assert.assertTrue("Queue is not empty", q.isEmpty());
		Assert.assertEquals("Size of queue not equal to 0", 0, q.size());

		q.enqueue("a");
		Assert.assertFalse("Queue is empty", q.isEmpty());
		Assert.assertEquals("Size of queue not equal to 1", 1, q.size());

		Object o = q.dequeue();
		Assert.assertNotNull("Dequeued object is NULL", o);
		Assert.assertEquals("Dequeued object doesn't match", "a", o);
		Assert.assertTrue("Queue is not empty", q.isEmpty());
		Assert.assertEquals("Size of queue not equal to 0", 0, q.size());

	}

	@Test
	public void testFIFO() throws Exception {
		Queue q = createQueue(5);
		q.enqueue("a");
		q.enqueue("b");
		q.enqueue("c");
		q.enqueue("d");
		q.enqueue("e");

		Assert.assertEquals("Size of queue not equal to 5", 5, q.size());
		Assert.assertEquals("First object doesn't match", "a", q.dequeue());
		Assert.assertEquals("Second object doesn't match", "b", q.dequeue());
		Assert.assertEquals("Third object doesn't match", "c", q.dequeue());
		Assert.assertEquals("Fourth object doesn't match", "d", q.dequeue());
		Assert.assertEquals("Fifth object doesn't match", "e", q.dequeue());
		Assert.assertTrue("Queue is not empty", q.isEmpty());
		Assert.assertEquals("Size of queue not equal to 0", 0, q.size());
	}

	@Test(expected = QueueFullException.class)
	public void testQueueFullException() throws Exception {
		Queue q = createQueue(5);
		q.enqueue("a");
		q.enqueue("b");
		q.enqueue("c");
		q.enqueue("d");
		q.enqueue("e");
		q.enqueue("f");
	}

	@Test(expected = QueueEmptyException.class)
	public void testQueueEmptyException() throws Exception {
		Queue q = createQueue(5);
		q.dequeue();
	}

	@Test(expected = QueueEmptyException.class)
	public void testFrontQueueEmptyException() throws Exception {
		Queue q = createQueue(5);
		q.front();
	}

	@Test
	public void testFront() throws Exception {
		Queue q = createQueue(5);
		q.enqueue("a");
		q.enqueue("b");

		Assert.assertEquals("Front object doesn't match", "a", q.front());
		Assert.assertEquals("Size of the queue doesn't match", 2, q.size());
	}

	@Test
	public void testQueueOverflow() throws Exception {
		Queue q = createQueue(5);
		q.enqueue("a");
		q.enqueue("b");
		q.enqueue("c");
		q.enqueue("d");
		q.enqueue("e");

		Assert.assertEquals("Dequeued object doesn't match", "a", q.dequeue());
		q.enqueue("f");
		Assert.assertEquals("Dequeued object doesn't match", "b", q.dequeue());
		q.enqueue("g");
		Assert.assertEquals("Size of the queue doesn't match", 5, q.size());

	}

}
