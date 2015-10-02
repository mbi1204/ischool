package com.sinergitec.ischool.control.rep;

import java.io.IOException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.ischool.model.ct.ctGrupo;
import com.sinergitec.ischool.service.ct.ctGrupoService;
import com.sinergitec.ischool.service.rep.repAlumnoGrupoService;

@Controller
public class repAlumnoGrupoControl {
	
	@Autowired
	private repAlumnoGrupoService repService;
	
	@Autowired
	private ctGrupoService ctGrupoService;
	
	@RequestMapping(value = "/ctGrupo", method = RequestMethod.GET)
	public String grupo(Model model) throws Open4GLException, IOException{
		
		model.addAttribute("ctGrupo", new ctGrupo());
		model.addAttribute("lista_ctGrupo", this.ctGrupoService.list_ctGrupo());
		
		return"ctGrupo_List";
	}
	
	
	

}
