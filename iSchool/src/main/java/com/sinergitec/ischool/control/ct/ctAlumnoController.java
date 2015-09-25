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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.model.ct.ctAlumno;
import com.sinergitec.ischool.model.ct.ctGrupo;
import com.sinergitec.ischool.service.ct.ctAlumnoService;
import com.sinergitec.ischool.service.ct.ctCursoService;
import com.sinergitec.ischool.service.ct.ctGrupoService;

@Controller
public class ctAlumnoController {

	@Autowired
	private ctAlumnoService alumnoService;

	@Autowired
	private ctGrupoService grupoService;

	@RequestMapping(value = "/ctAlumno", method = RequestMethod.GET)
	public String alumno(Locale locale, Model model) {

		model.addAttribute("ctAlumno", new ctAlumno());
		model.addAttribute("Lista_Grupo", this.grupoService.list_ctGrupo());

		return "ctAlumnoForm";
	}

	@RequestMapping(value = "/ctAlumno/agregar", method = RequestMethod.POST)
	public ModelAndView addPerson(@ModelAttribute("ctAlumno") ctAlumno obj) {
		

		
    	 ModelAndView miModelo = new ModelAndView("pdfView");
    	 
    	 miModelo.addObject("ctAlumno" ,  obj);
    	 
    	 
    	 
    	 

		
		//return new ModelAndView("pdfView", "listBooks", null);
    	 return miModelo;

	}

	// @RequestMapping(value = "/ctAlumno/agregar" , method =
	// RequestMethod.POST)
	// public ModelAndView addPerson(@ModelAttribute("ctAlumno") ctAlumno obj) {
	//
	// System.out.println("entro");
	//
	//
	//
	// // new person, add it
	// try {
	//
	// this.alumnoService.add_ctAlumno(obj);
	// } catch (Open4GLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	//
	// return new ModelAndView("pdfView", "listBooks", null);
	// }

	@RequestMapping(value = "/ctAlumno/getGrupo", method = RequestMethod.GET)
	public @ResponseBody ctGrupo getGrupo(int id) {

		System.out.println("entro");

		ctGrupo obj = new ctGrupo();

		obj = this.grupoService.get_Grupo(id);

		System.out.println("Nomre" + obj.getCurso().getcNombre());
		System.out.println("Precio" + obj.getCurso().getDePrecio());

		return obj;
	}

	@RequestMapping(value = "/pruebaxx", method = RequestMethod.GET)


	public String pruebaxx(String cUsuario, String dataArray1) {
		JSONArray jsonArray = new JSONArray(dataArray1);
		List<String> list = new ArrayList<String>();

		for (int i = 0; i < jsonArray.length(); i++) {
			
			String val = jsonArray.optString(i);
			System.out.println(jsonArray.getJSONObject(i).getString("firstName"));
			System.out.println(jsonArray.getJSONObject(i).getString("lastName"));

		}

		return "salio";
	}

}