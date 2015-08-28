package com.sinergitec.ischool.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinergitec.ischool.model.ctPrograma;
import com.sinergitec.ischool.service.ctMenuService;
import com.sinergitec.ischool.service.ctProgramaService;

@Controller
public class ctProgramaControl {

	@Autowired
	private ctProgramaService serv;
	@Autowired
	private ctMenuService serv_ctMenu;

	public void setctProgramaService(ctProgramaService ps) {
		this.serv = ps;
	}

	@RequestMapping(value = "/ctPrograma", method = RequestMethod.GET)
	public String list_ctPrograma(Model model) {
		System.out.print("entro al lista");

		model.addAttribute("ctPrograma", new ctPrograma());
		model.addAttribute("lista_ctPrograma", this.serv.list_ctPrograma());
		

		return "ctPrograma_List";
	}

	@RequestMapping(value = "/ctPrograma/add", method = RequestMethod.POST)
	public String add_ctPrograma(@ModelAttribute("ctPrograma") ctPrograma obj,
			ModelMap model) {

		if (obj.getiIdPrograma() == 0) {
			// new person, add it
			obj.setlActivo(true);
			this.serv.add_ctPrograma(obj);

		} else {
			// existing person, call update
			System.out.print(obj.getiIdMenu());
			System.out.print(obj.getiIdPrograma());
			
			this.serv.update_ctPrograma(obj);

		}

		return "redirect:/ctPrograma";

	}

	@RequestMapping("/remove_ctPrograma/{iMenu}&{iPrograma} ")
	public String remove_ctPrograma(@PathVariable("iMenu") int iMenu,
			@PathVariable("iPrograma") int iPrograma) {

		this.serv.remove_ctPrograma(iMenu, iPrograma);
		return "redirect:/ctPrograma";
	}

	@RequestMapping("/get_ctPrograma/{iMenu}&{iPrograma}")
	public String get_ctPrograma(@PathVariable("iMenu") int iMenu,
			@PathVariable("iPrograma") int iPrograma, Model model) {

		model.addAttribute("ctPrograma", this.serv.get_ctPrograma(iMenu, iPrograma));
		model.addAttribute("lista_ctMenu", this.serv_ctMenu.list_ctMenu());
		model.addAttribute("vlHabila_menu", true);

		return "ctPrograma_Form";

	}

	@RequestMapping("/open_ctPrograma" )
	public String open_ctPrograma( Model model) {
		
		System.out.print("entro");
		model.addAttribute("ctPrograma", new ctPrograma());
		model.addAttribute("vlHabila_menu", false);
		model.addAttribute("lista_ctMenu", this.serv_ctMenu.list_ctMenu());
		return "ctPrograma_Form";

	}

	

}
