package com.shankark.ds;

/**
 * A Vector data structure which supports insertion, deletion and searching of
 * the elements at specified rank.
 * 
 * @author shankarkumar
 *
 */
public interface Vector {

	/**
	 * Returns an element which is at the specified rank
	 * 
	 * @param rank
	 *            Rank at which to insert element
	 * @return Object
	 * @throws BoundaryViolationException
	 *             if rank is out of bound
	 */
	Object elementAtRank(int rank) throws BoundaryViolationException;

	/**
	 * Replaces element at the specified rank.
	 * 
	 * @param rank
	 *            Rank at which to replace element
	 * @param e
	 *            Element to be replaced with
	 * @throws BoundaryViolationException
	 *             if rank is out of bound
	 */
	void replaceAtRank(int rank, Object e) throws BoundaryViolationException;

	/**
	 * Inserts element at the specified rank.
	 * 
	 * @param rank
	 *            Rank at which to insert element
	 * @param e
	 *            Element to be inserted.
	 * @throws BoundaryViolationException
	 *             if rank is out of bound
	 */
	void insertAtRank(int rank, Object e) throws BoundaryViolationException;

	/**
	 * Removes an element at the specified rank.
	 * 
	 * @param rank
	 *            Rank at which element to be removed
	 * @throws BoundaryViolationException
	 *             if rank is out of bound
	 */
	void removeAtRank(int rank) throws BoundaryViolationException;

	/**
	 * Returns the size of the vector
	 * 
	 * @return Integer
	 */
	int size();

	/**
	 * Returns true of vector is empty otherwise false.
	 * 
	 * @return boolean
	 */
	boolean isEmpty();
}
