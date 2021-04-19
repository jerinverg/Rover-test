package com.mars.exception;

import com.mars.utils.Plateau;
import com.mars.utils.Position;

public class PositionNotOnPlateauException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Plateau plateau;
	private Position position;
	
	public PositionNotOnPlateauException(Plateau plateau, Position position) {
		super("Position is not on the plateau!");
		
		this.plateau = plateau;
		this.position = position;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public Position getPosition() {
		return position;
	}
}
