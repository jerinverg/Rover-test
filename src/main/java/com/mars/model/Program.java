package com.mars.model;

import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mars.controllers.roversContollers;
import com.mars.enumerate.Instruction;
import com.mars.utils.Instructions;
import com.mars.utils.Plateau;
import com.mars.utils.Rover;


public class Program {

	private static final Log LOG = LogFactory.getLog(roversContollers.class);

	public ArrayList<String> releaseRover(String dimensions, String roverInformation, String roverMove) {
		
		ArrayList<String> dataList = new ArrayList<String>();

		Plateau plateau = createPlateauFromDimensions(dimensions);

		int i = 0;
		while (true) {
			i++;

			String name = "Rover " + i;

			try {
				Rover rover = dropRover(name, plateau, roverInformation);

				Instruction[] instructionsCollection = new Instructions(roverMove).getInstructions();
				rover.processInstructions(instructionsCollection);
				dataList.add(rover.reportStatus());
				return dataList;
			} catch (Exception ex) {
				LOG.error(ex);
			}
		}

	}

	private static Rover dropRover(String id, Plateau plateau, String dropInfo) {
		Rover rover = new Rover(id);
		rover.dropRover(plateau, dropInfo);
		return rover;
	}

	private static Plateau createPlateauFromDimensions(String dimensions) {
		String[] parts = dimensions.split(" ");
		int dimX = Integer.parseInt(parts[0]);
		int dimY = Integer.parseInt(parts[1]);
		return new Plateau(dimX, dimY);
	}
}
