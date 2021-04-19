package com.mars.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("rover")
public class roversContollers {

	private static final Log LOG = LogFactory.getLog(roversContollers.class);

	@RequestMapping(value = "/guardar/{canal}/{firmaCanal}/{id}", method = RequestMethod.GET, produces = "application/json")
	public String doGuardar(@PathVariable String canal, @PathVariable String firmaCanal, @PathVariable String id) {

		LOG.info("ESTO ES UNA PRUEBA " + canal + "firmaCanal " + firmaCanal);

		return "POSITIVO";
	}

	@SuppressWarnings("resource")
	@PostMapping("/doUploadFile")
	public String doUploadFile(@RequestParam("file") MultipartFile file) {
		File data = null;
		String txtName = file.getOriginalFilename();
		String prefix = txtName.substring(txtName.lastIndexOf("."));
		try {
			ArrayList<String> dataList = new ArrayList<String>();
			data = File.createTempFile(txtName, prefix);
			file.transferTo(data);
			Scanner scan = new Scanner(data);

			while (scan.hasNextLine()) {
				dataList.add(scan.nextLine());
			}

			LOG.info("ESTO ES UNA PRUEBA " + dataList);

			return null; // scan.nextLine();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOG.error(e);
		}
		return null;
	}

}
