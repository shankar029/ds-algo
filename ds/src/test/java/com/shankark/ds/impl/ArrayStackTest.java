package com.shankark.ds.impl;

import org.junit.Test;

import com.shankark.ds.Stack;
import com.shankark.ds.StackEmptyException;

import junit.framework.Assert;

public class ArrayStackTest {

	@Test
	public void testSanity() throws Exception {
		Stack s = new ArrayStack();
		Assert.assertTrue("Stack is not empty", s.isEmpty());
		s.push("First");
		Assert.assertFalse("Stack is not empty", s.isEmpty());
		Assert.assertEquals("Stack size is not 1", 1, s.size());

		Object t = s.top();
		Assert.assertNotNull("Top element is NULL", t);
		Assert.assertEquals("Top element doesn't match", "First", t);

		Assert.assertEquals("Stack size is not 1", 1, s.size());

		Object p = s.pop();
		Assert.assertNotNull("Stack element is NULL", p);
		Assert.assertEquals("Popped element is not First", "First", p);
	}

	@Test
	public void testValidateLIFO() throws Exception {
		Stack s = new ArrayStack();
		s.push("First");
		s.push("Second");
		s.push("Third");
		s.push("Fourth");

		Assert.assertEquals("Stack size is not 4", 4, s.size());

		Object p = s.pop();
		Assert.assertNotNull("Stack element is NULL", p);
		Assert.assertEquals("Popped element is not Fourth", "Fourth", p);

		p = s.pop();
		Assert.assertNotNull("Stack element is NULL", p);
		Assert.assertEquals("Popped element is not Third", "Third", p);

		s.push("Three");
		p = s.pop();
		Assert.assertNotNull("Stack element is NULL", p);
		Assert.assertEquals("Popped element is not Three", "Three", p);

		p = s.pop();
		Assert.assertNotNull("Stack element is NULL", p);
		Assert.assertEquals("Popped element is not Second", "Second", p);

		p = s.pop();
		Assert.assertNotNull("Stack element is NULL", p);
		Assert.assertEquals("Popped element is not First", "First", p);

		s.push("One");
		p = s.pop();
		Assert.assertNotNull("Stack element is NULL", p);
		Assert.assertEquals("Popped element is not One", "One", p);

	}

	@Test(expected = StackEmptyException.class)
	public void testStackEmptyForPop() throws Exception {
		Stack s = new ArrayStack();
		s.pop();
	}

	@Test(expected = StackEmptyException.class)
	public void testStackEmptyForTop() throws Exception {
		Stack s = new ArrayStack();
		s.top();
	}

	@Test
	public void testStackOverflow() throws Exception {
		Stack s = new ArrayStack(5);
		s.push("a");
		s.push("b");
		s.push("c");
		s.push("d");
		s.push("e");
		Assert.assertEquals("Stack size is not equal to 5", 5, s.size());

		s.push("f");
		Assert.assertEquals("Stack size is not equal to 6", 6, s.size());

		Object p = s.pop();
		Assert.assertEquals("Popped element is not f", "f", p);
		Assert.assertEquals("Stack size is not equal to 5", 5, s.size());
	}
}
