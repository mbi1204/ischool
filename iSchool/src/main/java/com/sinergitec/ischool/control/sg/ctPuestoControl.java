package com.sinergitec.ischool.control.sg;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinergitec.ischool.model.sg.ctPuesto;
import com.sinergitec.ischool.service.sg.ctPuestoService;

@Controller
public class ctPuestoControl {

	@Autowired
	private ctPuestoService serv;

	public void setCtPuestoService(ctPuestoService ps) {
		this.serv = ps;
	}

	@RequestMapping(value = "/ctPuesto", method = RequestMethod.GET)
	public String list_ctPuesto(Model model) {
		System.out.print("entro al lista");

		model.addAttribute("ctPuesto", new ctPuesto());
		model.addAttribute("lista_ctPuesto", this.serv.list_ctPuesto());
		return "ctPuesto_List";
	}

	@RequestMapping(value = "/ctPuesto/add", method = RequestMethod.POST)
	public String add_ctPuesto(@ModelAttribute("ctPuesto") ctPuesto obj,
			ModelMap model) {
		if (obj.getiIdPuesto() == 0) {
			// new person, add it
			obj.setlActivo(true);
			this.serv.add_ctPuesto(obj);
			
			
			
		} else {
			// existing person, call update
			
			this.serv.update_ctPuesto(obj);
			
		}

		return "redirect:/ctPuesto";

	}

	@RequestMapping("/remove_ctPuesto/{id}")
	public String remove_ctPuesto(@PathVariable("id") int id) {

		this.serv.remove_ctPuesto(id);
		return "redirect:/ctPuesto";
	}
	
	@RequestMapping("/get_ctPuesto/{id}")
	public String get_ctPuesto(@PathVariable("id") int id,	Model model) {
				

		model.addAttribute("ctPuesto", this.serv.get_ctPuesto(id));		
		

		return "ctPuesto_Form";

	}
	
	
	 @RequestMapping("/edit_ctPuesto/{id}")
	    public String edit_ctPuesto(@PathVariable("id") int id, Model model){
		 
	        model.addAttribute("ctPuesto", this.serv.get_ctPuesto(id));
	        model.addAttribute("lista_ctPuesto", this.serv.list_ctPuesto());
	        return "ctPuesto";
	    }

}
