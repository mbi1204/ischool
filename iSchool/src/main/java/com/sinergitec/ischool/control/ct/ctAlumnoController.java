package com.sinergitec.ischool.control.ct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.model.ct.ctAlumno;
import com.sinergitec.ischool.service.ct.ctAlumnoService;
import com.sinergitec.ischool.service.ct.ctGrupoService;


@Controller
public class ctAlumnoController {

	@Autowired
	private ctAlumnoService alumnoService;
	
	@Autowired
	private ctGrupoService grupoService;
	
	

	@RequestMapping(value = "/ctAlumno", method = RequestMethod.GET)
	public String alumno(Locale locale, Model model) {
		
		model.addAttribute("ctAlumno" , new ctAlumno());		
		model.addAttribute("Lista_Grupo" , this.grupoService.list_ctGrupo());		

		return "ctAlumnoForm";
	}

	@RequestMapping(value = "/ctAlumno/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("ctAlumno") ctAlumno obj)
			throws RunTime4GLException, SystemErrorException, Open4GLException, IOException {

		if (obj.getiIdAlumno() == 0) {
			// new person, add it
			try {

				this.alumnoService.add_ctAlumno(obj);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			// existing person, call update

		}

		return "ctAlumno";

	}

	@RequestMapping(value = "/edit/{cNombre}")
	public String editPerson(@PathVariable("cNombre") String cCveCia, Model modelo) {

		// this.alumnoService.eliminarAlumno(iCliente);

		return "ctAlumno";
	}

	@RequestMapping(value = "/remove/{cCveCia},{iCliente}", method = RequestMethod.GET)
	public String doActions(@PathVariable("cCveCia") String cCveCia, @PathVariable("iCliente") int iCliente,
			Model modelo) {

		// this.alumnoService.eliminarAlumno(iCliente);

		return "ctAlumno";
	}

	@RequestMapping(value = "/pruebaxx" , method = RequestMethod.GET)
	
//	public @ResponseBody String pruebaxx(String cUsuario ,@RequestParam("dataArray")  ArrayList<String> dataArray) {
	
	
	public  String pruebaxx(String cUsuario , String dataArray1 ) {		
		
		System.out.println("Entro aqui--->"  + cUsuario);
		System.out.println("Array1--->"       + dataArray1);
		
		
		JSONArray jsonArray = new JSONArray(dataArray1);
		
		System.out.println(jsonArray.length());
		
		
		List<String> list = new ArrayList<String>();
		
		for (int i=0; i<jsonArray.length(); i++) {
		  //  System.out.println(jsonArray.getJSONObject(i));
		   // System.out.println(  jsonArray.get(i).toString());
		   // System.out.println(  jsonArray.get(i));
		    
		    String val = jsonArray.optString(i);
		    
		    System.out.println( jsonArray.getJSONObject(i).getString("firstName"));
		    System.out.println( jsonArray.getJSONObject(i).getString("lastName"));
		    
		}
		
	
		
		

		return "salio";
	}

}
