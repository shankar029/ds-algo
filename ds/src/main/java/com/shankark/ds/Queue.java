package com.shankark.ds;

/**
 * A Queue data structure.
 * 
 * @author shankarkumar
 *
 */
public interface Queue {

	/**
	 * Inserts an element into queue
	 * 
	 * @param Object
	 * @throws QueueFullException
	 *             If queue is full
	 */
	void enqueue(Object o) throws QueueFullException;

	/**
	 * Removes an element from the queue
	 * 
	 * @return Object
	 * @throws QueueEmptyException
	 *             if queue is empty
	 */
	Object dequeue() throws QueueEmptyException;

	/**
	 * Returns front element of the queue
	 * 
	 * @return Object
	 * @throws QueueEmptyException
	 *             if queue is empty
	 */
	Object front() throws QueueEmptyException;

	/**
	 * Returns the size of the queue
	 * 
	 * @return Number of elements in the queue
	 */
	int size();

	/**
	 * Returns true if queue is empty otherwise false.
	 * 
	 * @return Boolean
	 */
	boolean isEmpty();
}
