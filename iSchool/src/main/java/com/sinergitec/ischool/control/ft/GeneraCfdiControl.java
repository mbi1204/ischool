package com.sinergitec.ischool.control.ft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinergitec.ischool.model.ft.CFDI;
import com.sinergitec.ischool.service.ft.GeneraCfdiService;

@Controller
public class GeneraCfdiControl {
	@Autowired
	private GeneraCfdiService service;

	@RequestMapping(value = "/GeneraCfdi/add")
	public @ResponseBody String getGeneraCfdi(int viFolio, int viSerie) {

		String response = null;
		response = service.generaCfdi(viSerie, viFolio);

		if (response.isEmpty() || response == null) {
			response = "Factura generada";

		}

		return response;
	}

	@RequestMapping(value = "GeneraCfdi/getPDF/{viFolio}&{viSerie}")
	public ResponseEntity<byte[]> getPDF(@PathVariable("viFolio") int viFolio, @PathVariable("viSerie") int viSerie) {

		CFDI obj = new CFDI();

		obj = service.getCFDI(viSerie, viFolio, "pdf");

		if (obj.getPDF() != null) {
			byte[] contents = obj.getPDF();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.parseMediaType("application/pdf"));
			String filename = obj.getUUID() + ".pdf";
			headers.setContentDispositionFormData(filename, filename);
			headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
			ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
			return response;

		} else {
			
			return null;
		}

	}

	@RequestMapping(value = "GeneraCfdi/getXML/{viFolio}&{viSerie}")
	public ResponseEntity<byte[]> getXML(@PathVariable("viFolio") int viFolio, @PathVariable("viSerie") int viSerie) {

		CFDI obj = new CFDI();

		obj = service.getCFDI(viSerie, viFolio, "xml");
		if (obj.getXML() != null) {
			byte[] contents = obj.getXML();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.parseMediaType("application/xml"));
			String filename = obj.getUUID() + ".xml";
			headers.setContentDispositionFormData(filename, filename);
			headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
			ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
			return response;

		} else {				
			
			return null;
		}

	}

}
