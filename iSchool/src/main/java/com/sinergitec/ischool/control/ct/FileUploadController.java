package com.sinergitec.ischool.control.ct;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sinergitec.ischool.model.cb.cbPago;

/**
 * Handles requests for the application file upload requests
 */
@Controller
public class FileUploadController {

	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	/**
	 * Upload single file using Spring Controller
	 */

	@RequestMapping(value = "/cbCargaPagos", method = RequestMethod.GET)
	public String upload() {
		return "cbCargaPagos";
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	// public @ResponseBody String uploadFileHandler(@RequestParam("file")
	// MultipartFile file) {
	public String uploadFileHandler(@RequestParam("file") MultipartFile file, Model model) {

		String vcMensaje  ,vcFecha = null ,vcHora = null;
		ArrayList<cbPago> listPago = new ArrayList<cbPago>();
		

		if (!file.isEmpty()) {

			try {
				byte[] bytes = file.getBytes();
				byte[] delimiter = "\n".getBytes();

				try {

					String[] result = new String(bytes).split(new String(delimiter));
					Calendar cal = GregorianCalendar.getInstance();
					

					/* inicia en uno por el encabezado */

					for (int i = 1; i < result.length; i++) {
						String[] a = new String(result[i]).split(new String(",".getBytes()));

						cbPago obj = new cbPago();

						for (int j = 0; j < a.length; j++) {
							/* 0 Cuenta */
							if (j == 0) {
								obj.setcCuenta(a[j].replaceAll("\\s", ""));
							} else if (j == 1) { /* fecha */
								vcFecha = a[j].replaceAll("\\s", "");
							} else if (j == 2) { /* hora  */							
								vcHora = a[j].replaceAll("\\s", "");
							} else if (j == 3) {/* sucursal */
								obj.setcSucursal(a[j].replaceAll("\\s", ""));
							} else if (j == 4) { /* Descripcion */
								obj.setcDescripcion(a[j].replaceAll("\\s", ""));
							} else if (j == 5) { /* Cargo/Abono */
								
							} else if (j == 6) { /* Importe */
								obj.setDeMontoPago(new BigDecimal(a[j].replaceAll("\\s", "")));
							} else if (j == 7) { /* Saldo */
								
							} else if (j == 8) { /* Referencia */
								obj.setcReferencia(a[j].replaceAll("\\s", ""));
							} else if (j == 9) { /* Concepto/ ReferenciaInterbancaria	 */
								obj.setcConcepto(a[j].replaceAll("\\s", ""));

							}

						}
						
						
						cal.set(Calendar.DAY_OF_MONTH,  Integer.parseInt( vcFecha.substring(1, 2)));// I might have the wrong
						cal.set(Calendar.MONTH,         Integer.parseInt( vcFecha.substring(3, 4)));// -1 as month is zero-based
						cal.set(Calendar.YEAR,          Integer.parseInt( vcFecha.substring(5, 8)));
						cal.set(Calendar.HOUR, 12);
						cal.set(Calendar.MINUTE, 20);
						
						obj.setDtFechaPago( new Timestamp(cal.getTimeInMillis()));
						
						listPago.add(obj);

					}

					for (cbPago lista : listPago) {
						System.out.println(lista.toString());
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				vcMensaje = "Archivo Cargado con éxito ";
			} catch (Exception e) {
				vcMensaje = "ERROR - Cargar El Archivo" + e.getMessage();
			}
		} else {
			vcMensaje = "ERROR - El archivo se encuentra vacío.";
		}

		model.addAttribute("vlMensaje", vcMensaje);

		return "Mensaje";
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
