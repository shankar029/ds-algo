package com.shankark.ds;

/**
 * Thrown to indicate when an index or a rank violates the boundary conditions
 * of certain structure (vector).
 * 
 * @author shankarkumar
 *
 */
public class BoundaryViolationException extends Exception {

	private static final long serialVersionUID = 8273375808221277810L;

	public BoundaryViolationException(String message) {
		super(message);
	}
}
