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
	 */
	Object elementAtRank(int rank);

	/**
	 * Replaces element at the specified rank.
	 * 
	 * @param rank
	 *            Rank at which to replace element
	 * @param e
	 *            Element to be replaced with
	 */
	void replaceAtRank(int rank, Object e);

	/**
	 * Inserts element at the specified rank.
	 * 
	 * @param rank
	 *            Rank at which to insert element
	 * @param e
	 *            Element to be inserted.
	 */
	void insertAtRank(int rank, Object e);

	/**
	 * Removes an element at the specified rank.
	 * 
	 * @param rank
	 *            Rank at which element to be removed
	 */
	void removeAtRank(int rank);

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
