package com.shankark.ds;

/**
 * Doubly ended queue.
 * 
 * @author shankarkumar
 *
 */
public interface Deque {

	/**
	 * Inserts an element at the beginning of the queue
	 * 
	 * @param o
	 *            Object
	 * @throws QueueFullException
	 *             if queue is full
	 */
	void insertFirst(Object o) throws QueueFullException;

	/**
	 * Inserts an element at the end of the queue
	 * 
	 * @param o
	 * @throws QueueFullException
	 *             if queue is full
	 */
	void insertLast(Object o) throws QueueFullException;;

	/**
	 * Removes an element from the beginning of the queue
	 * 
	 * @return Object
	 * @throws QueueEmptyException
	 *             if queue is empty
	 */
	Object removeFirst() throws QueueEmptyException;

	/**
	 * Removes an element from the end of the queue
	 * 
	 * @return Object
	 * @throws QueueEmptyException
	 *             if queue is empty
	 */
	Object removeLast() throws QueueEmptyException;;

	/**
	 * Returns a element from beginning of the queue.
	 * 
	 * @return Object
	 * @throws QueueEmptyException
	 *             if queue is empty
	 */
	Object first() throws QueueEmptyException;;

	/**
	 * Returns a element from end of the queue.
	 * 
	 * @return Object
	 * @throws QueueEmptyException
	 *             if queue is empty
	 */
	Object last() throws QueueEmptyException;;

	/**
	 * Returns size of the queue
	 * 
	 * @return Integer
	 */
	int size();

	/**
	 * Returns true if queue is empty otherwise false.
	 * 
	 * @return Boolean
	 */
	boolean isEmpty();
}
