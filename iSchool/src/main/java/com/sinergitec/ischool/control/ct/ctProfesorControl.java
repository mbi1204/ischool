package com.sinergitec.ischool.control.ct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinergitec.ischool.model.ct.ctProfesor;
import com.sinergitec.ischool.service.ct.ctProfesorService;



@Controller
public class ctProfesorControl {

	@Autowired
	private ctProfesorService servProfesor;

	
	
	
	@RequestMapping(value = "/ctProfesor", method = RequestMethod.GET)
	public String list_ctProfesor(Model model) {
		
		
	
		model.addAttribute("ctProfesor", new ctProfesor());
		model.addAttribute("lista_ctProfesor", this.servProfesor.list_ctProfesor());
	
		

		return "ctProfesor_List";
	}

	@RequestMapping(value = "/ctProfesor/add", method = RequestMethod.POST)
	public String add_ctProfesor(@ModelAttribute("ctProfesor") ctProfesor obj,
			ModelMap model) {		
	 
		
		this.servProfesor.add_ctProfesor(obj);
		
		 
		return "ctProfesor";

	}

	@RequestMapping("/remove_ctProfesor/{cProfesor}")
	public String remove_ctProfesor(@PathVariable("cProfesor") int id) {

		
		this.servProfesor.remove_ctProfesor(id);
		return "redirect:/ctProfesor";

	}

	@RequestMapping("/get_ctProfesor/{cProfesor}")
	public String get_ctProfesor(@PathVariable("cProfesor") int id,
			Model model) {
		
		model.addAttribute("ctProfesor", this.servProfesor.get_ctProfesor(id));
	
		return "ctProfesor_Form_Update";

	}

	@RequestMapping(value = "/ctProfesor/update", method = RequestMethod.POST)
	public String edit_ctProfesor(@ModelAttribute("ctProfesor") ctProfesor obj) {
		
		
	

		this.servProfesor.update_ctProfesor(obj);
		
	
		return "redirect:/ctProfesor";
	}
	
	

}
