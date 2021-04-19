package com.mars.exception;

public class UnknownInstructionException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnknownInstructionException(char instruction) {
		super("Unknown instruction '" + instruction + "'!");
	}
}
