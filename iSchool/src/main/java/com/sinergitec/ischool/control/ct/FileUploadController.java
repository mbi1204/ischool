package com.sinergitec.ischool.control.ct;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sinergitec.ischool.model.ct.Cobro;

/**
 * Handles requests for the application file upload requests
 */
@Controller
public class FileUploadController {
	
	
	
	

	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	/**
	 * Upload single file using Spring Controller
	 */
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload(){
		return "upload";
	}
	
	 
	@RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
	public @ResponseBody String uploadFileHandler(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				byte[] delimiter = "\n".getBytes();				
				
				FileInputStream fileInputStream = null;
				
				 try
			      {
			         //convert file into array of bytes
			         fileInputStream = new FileInputStream(file.getOriginalFilename());
			         fileInputStream.read(bytes);
			         fileInputStream.close();
			         String[] result = new String(bytes).split(new String(delimiter));
			         
			         
			         for (int i = 0; i < result.length; i++) {
			        	 String[] a = new String(result[i]).split(new String(",".getBytes()));
			        	 
			        	 Cobro cobro = new Cobro(new String(result[i]).split(new String(",".getBytes())));
			        	 cobro.setFecha(cobro.getFecha().replaceAll("\\s", ""));
			        	 cobro.setCuenta(cobro.getCuenta().replaceAll("\\s", ""));
			        	 cobro.setHora(cobro.getHora().replaceAll("\\s", ""));
			        	 cobro.setSucursal(cobro.getSucursal().replaceAll("\\s", ""));
			        	 cobro.setDescripcion(cobro.getDescripcion().replaceAll("\\s", ""));
			        	 cobro.setCargoAbono(cobro.getCargoAbono().replaceAll("\\s", ""));
			        	 cobro.setImporte(cobro.getImporte().replaceAll("\\s", ""));
			        	 cobro.setSaldo(cobro.getSaldo().replaceAll("\\s", ""));
			        	 cobro.setReferencia(cobro.getReferencia().replaceAll("\\s", ""));
			        	 cobro.setConcepto(cobro.getConcepto().replaceAll("\\s", ""));
			        	 System.out.println(cobro.toString());			        	 
			        	
			         }          
			         
			         
			         

			      }
			      catch (Exception e)
			      {
			         e.printStackTrace();
			      }
					
				
				return "You successfully uploaded file=" + name;
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name + " because the file was empty.";
		}
	}

	/**
	 * Upload multiple file using Spring Controller
	 */
	@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
	public @ResponseBody String uploadMultipleFileHandler(@RequestParam("name") String[] names,
			@RequestParam("file") MultipartFile[] files) {

		if (files.length != names.length)
			return "Mandatory information missing";

		String message = "";
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			String name = names[i];
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location=" + serverFile.getAbsolutePath());

				message = message + "You successfully uploaded file=" + name + "<br />";
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		}
		return message;
	}
}
