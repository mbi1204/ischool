package com.sinergitec.ischool.control.rep;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.progress.open4gl.Open4GLException;
import com.progress.ubroker.util.Request;
import com.sinergitec.ischool.model.ct.ctAlumno;
import com.sinergitec.ischool.model.ct.ctGrupo;

import com.sinergitec.ischool.service.ct.ctGrupoService;
import com.sinergitec.ischool.service.rep.repAlumnoGrupoService;

@Controller
public class repAlumnoGrupoControl {
	
	List<ctAlumno> list;

	@Autowired
	private repAlumnoGrupoService repService;

	@Autowired
	private ctGrupoService ctGrupoService;

	@RequestMapping(value = "/repAlumnoGrupo", method = RequestMethod.GET)
	public String grupo(Model model) throws Open4GLException, IOException {

		model.addAttribute("ctGrupo", new ctGrupo());
		model.addAttribute("lista_ctGrupo", this.ctGrupoService.list_ctGrupo());

		return "repAlumnoGrupo";
	}

	@RequestMapping(value = "/repAlumnoGrupo/getAlumnos", headers = "Accept=application/json")
	public @ResponseBody List<ctAlumno> list_repAlumnoGrupo(int iIdGrupo) {
		
		list = this.repService.list_ctAlumno(iIdGrupo);

		return list;
	}
	
	@RequestMapping(value = "/repAlumnoGrupo/pdf", method = RequestMethod.POST)
	public ModelAndView getList(@RequestParam("grupo") String grupo) {						
		
		ModelAndView miModelo = new ModelAndView("pdfViewRepAlumnoGrupo");
		
		miModelo.addObject("listaAlumno", list);
		miModelo.addObject("grupo", grupo);
		
		return miModelo;
	
	}


}
