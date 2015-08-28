package com.sinergitec.ischool.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinergitec.ischool.model.sg.ctMenu;
import com.sinergitec.ischool.service.ctMenuService;

@Controller
public class ctMenuControl {

	@Autowired
	private ctMenuService serv;

	public void setctMenuService(ctMenuService ps) {
		this.serv = ps;
	}

	@RequestMapping(value = "/ctMenu", method = RequestMethod.GET)
	public String list_ctMenu(Model model) {
		System.out.print("entro al lista");

		model.addAttribute("ctMenu", new ctMenu());
		model.addAttribute("lista_ctMenu", this.serv.list_ctMenu());
		return "ctMenu_List";
	}

	@RequestMapping(value = "/ctMenu/add", method = RequestMethod.POST)
	public String add_ctMenu(@ModelAttribute("ctMenu") ctMenu obj,
			ModelMap model) {
		
		System.out.print("entro");
		if (obj.getiIdMenu() == 0) {
			// new person, add it
			obj.setlActivo(true);
			this.serv.add_ctMenu(obj);
			
			
			
		} else {
			// existing person, call update
			
			this.serv.update_ctMenu(obj);
			
		}

		return "redirect:/ctMenu";

	}

	@RequestMapping("/remove_ctMenu/{id}")
	public String remove_ctMenu(@PathVariable("id") int id) {

		this.serv.remove_ctMenu(id);
		return "redirect:/ctMenu";
	}
	
	@RequestMapping("/get_ctMenu/{id}")
	public String get_ctMenu(@PathVariable("id") int id,	Model model) {

		model.addAttribute("ctMenu", this.serv.get_ctMenu(id));		
		

		return "ctMenu_Form";

	}
	
	
	 @RequestMapping("/edit_ctMenu/{id}")
	    public String edit_ctMenu(@PathVariable("id") int id, Model model){
		 
	        model.addAttribute("ctMenu", this.serv.get_ctMenu(id));
	        model.addAttribute("lista_ctMenu", this.serv.list_ctMenu());
	        return "ctMenu";
	    }

}
