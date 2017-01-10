package com.shankark.ds;

/**
 * This exception will be thrown when a pop operation is performed on a stack
 * when it is empty.
 * 
 * @author shankarkumar
 *
 */
public class StackEmptyException extends Exception {

	private static final long serialVersionUID = -4019979919369898226L;

	public StackEmptyException(String message) {
		super(message);
	}

}
