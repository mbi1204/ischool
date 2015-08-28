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

import com.sinergitec.ischool.model.sg.ctPuesto;
import com.sinergitec.ischool.model.sg.ctUsuario;
import com.sinergitec.ischool.service.ctPuestoService;
import com.sinergitec.ischool.service.ctUsuarioService;

@Controller
public class ctUsuarioControl {
	@Autowired
	private ctUsuarioService serv;
	@Autowired
	private ctPuestoService serv_ctPuesto; 

	@RequestMapping(value = "/ctUsuario", method = RequestMethod.GET)
	public String list_ctUsuario(Model model) {
		
		
	
		model.addAttribute("ctUsuario", new ctUsuario());
		model.addAttribute("lista_ctUsuario", this.serv.list_ctUsuario());
		model.addAttribute("lista_ctPuesto", this.serv_ctPuesto.list_ctPuesto());

		return "ctUsuario_List";
	}

	@RequestMapping(value = "/ctUsuario/add", method = RequestMethod.POST)
	public String add_ctUsuario(@ModelAttribute("ctUsuario") ctUsuario obj,
			ModelMap model) {

		
		java.util.Date date = new java.util.Date();
		obj.setDtFechaAlta(new Timestamp(date.getTime()));
		obj.setlActivo(true);

		this.serv.add_ctUsuario(obj);

		return "redirect:/ctUsuario";

	}

	@RequestMapping("/remove_ctUsuario/{cUsuario}")
	public String remove_ctUsuario(@PathVariable("cUsuario") String cUsuario) {

		this.serv.remove_ctUsuario(cUsuario);
		return "redirect:/ctUsuario";

	}

	@RequestMapping("/get_ctUsuario/{cUsuario}")
	public String get_ctUsuario(@PathVariable("cUsuario") String cUsuario,
			Model model) {
		
		

		System.out.print("Entro al get imb");
		model.addAttribute("ctUsuario", this.serv.get_ctUsuario(cUsuario));
		//model.addAttribute("actionUrl", "edit_ctUsuario/");
		model.addAttribute("lista_ctPuesto", this.serv_ctPuesto.list_ctPuesto());

		return "ctUsuario_Form_Update";

	}

	@RequestMapping(value = "/ctUsuario/update", method = RequestMethod.POST)
	public String edit_ctUsuario(@ModelAttribute("ctUsuario") ctUsuario obj) {
		java.util.Date date = new java.util.Date();
		obj.setDtFechaAlta(new Timestamp(date.getTime()));
		
		
	

		this.serv.update_ctUsuario(obj);
		
	
		return "redirect:/ctUsuario";
	}

}
