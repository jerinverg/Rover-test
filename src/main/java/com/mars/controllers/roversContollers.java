package com.mars.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mars.model.Program;
import com.mars.to.InstructionsTO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("rover")
public class roversContollers {

	private static final Log LOG = LogFactory.getLog(roversContollers.class);
	private String dimensions;
	private String roverInformation;
	private String roverMove;

	@SuppressWarnings("resource")
	@PostMapping("/doUploadFile")
	public ArrayList<String> doUploadFile(@RequestParam("file") MultipartFile file) {
		File data = null;
		Program program;
		Scanner scan;
		String txtName = file.getOriginalFilename();
		String prefix = txtName.substring(txtName.lastIndexOf("."));
		try {
			data = File.createTempFile(txtName, prefix);
			file.transferTo(data);
			program = new Program();
			scan = new Scanner(data);
			while (scan.hasNextLine()) {

				setDimensions(scan.nextLine());
				setRoverInformation(scan.nextLine());
				setRoverMove(scan.nextLine());

			}
			ArrayList<String> result =  program.releaseRover(getDimensions(), getRoverInformation(), getRoverMove());

			LOG.info("ESTO ES UNA PRUEBA "+ result);

			return result; // scan.nextLine();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOG.error(e);
		}
		return null;
	}
	
	@PostMapping("/doUploadData")
	public ArrayList<String> doUploadData( @RequestBody InstructionsTO instructionsTO) {
		
		Program program;

		try {
			
			program = new Program();
		
			ArrayList<String> result =  program.releaseRover(instructionsTO.getPlateau(), instructionsTO.getDropInfo(), instructionsTO.getInstructions());

			return  result; 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOG.error(e);
		}
		return null;
	}
	
	
	
	
	
	
	

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public String getRoverInformation() {
		return roverInformation;
	}

	public void setRoverInformation(String roverInformation) {
		this.roverInformation = roverInformation;
	}

	public String getRoverMove() {
		return roverMove;
	}

	public void setRoverMove(String roverMove) {
		this.roverMove = roverMove;
	}

}
