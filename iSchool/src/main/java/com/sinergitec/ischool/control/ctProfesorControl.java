package com.sinergitec.ischool.control;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinergitec.ischool.model.ct.ctProfesor;
import com.sinergitec.ischool.service.ctProfesorService;



@Controller
public class ctProfesorControl {
	@Autowired
	private ctProfesorService serv;
	
	@RequestMapping(value = "/ctProfesor", method = RequestMethod.GET)
	public String list_ctProfesor(Model model) {
		
		
	
		model.addAttribute("ctProfesor", new ctProfesor());
		model.addAttribute("lista_ctProfesor", this.serv.list_ctProfesor());
		

		return "ctProfesor_List";
	}

	@RequestMapping(value = "/ctProfesor/add", method = RequestMethod.POST)
	public String add_ctProfesor(@ModelAttribute("ctProfesor") ctProfesor obj,
			ModelMap model) {

		
		java.util.Date date = new java.util.Date();
		obj.setDtFechaAlta(new Timestamp(date.getTime()));
		obj.setlActivo(true);

		
		this.serv.add_ctProfesor(obj);

		return "redirect:/ctProfesor";

	}

	@RequestMapping("/remove_ctProfesor/{cProfesor}")
	public String remove_ctProfesor(@PathVariable("cProfesor") String cProfesor) {

		
		this.serv.remove_ctProfesor(cProfesor);
		return "redirect:/ctUsuario";

	}

	@RequestMapping("/get_ctProfesor/{cProfesor}")
	public String get_ctProfesor(@PathVariable("cProfesor") String cProfesor,
			Model model) {
		
		

		System.out.print("Entro al get imb");
		model.addAttribute("ctProfesor", this.serv.get_ctProfesor(cProfesor));
		//model.addAttribute("actionUrl", "edit_ctUsuario/");
		//model.addAttribute("lista_ctPuesto", this.serv_ctPuesto.list_ctPuesto());

		return "ctProfesor_Form_Update";

	}

	@RequestMapping(value = "/ctProfesor/update", method = RequestMethod.POST)
	public String edit_ctProfesor(@ModelAttribute("ctProfesor") ctProfesor obj) {
		java.util.Date date = new java.util.Date();
		obj.setDtFechaAlta(new Timestamp(date.getTime()));
		
		
	

		this.serv.update_ctProfesor(obj);
		
	
		return "redirect:/ctProfesor";
	}

}
