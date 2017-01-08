package com.shankark.ds;

/**
 * A Stack data structure.
 * 
 * @author shankarkumar
 *
 */
public interface Stack {

	/**
	 * Inserts an object into stack.
	 * 
	 * @param o
	 */
	void push(Object o);

	/**
	 * Removes and returns recently inserted element from the stack.
	 * 
	 * @return Object
	 * @throws StackEmptyException
	 *             If stack is empty
	 */
	Object pop() throws StackEmptyException;

	/**
	 * Returns recently inserted element from the stack.
	 * 
	 * @return Object
	 * @throws StackEmptyException
	 *             If stack is empty
	 */
	Object top() throws StackEmptyException;

	/**
	 * Returns <code>TRUE</code> if stack is empty otherwise <code>FALSE</code>.
	 * 
	 * @return Boolean
	 */
	boolean isEmpty();

	/**
	 * Returns size of the stack
	 * 
	 * @return Integer
	 */
	int size();
}
