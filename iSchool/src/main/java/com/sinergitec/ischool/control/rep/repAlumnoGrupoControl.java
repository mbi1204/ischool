package com.sinergitec.ischool.control.rep;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.ischool.model.ct.ctAlumno;
import com.sinergitec.ischool.model.ct.ctGrupo;

import com.sinergitec.ischool.service.ct.ctGrupoService;
import com.sinergitec.ischool.service.rep.repAlumnoGrupoService;

@Controller
public class repAlumnoGrupoControl {

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

		List<ctAlumno> list = new ArrayList<ctAlumno>();
		list = this.repService.list_ctAlumno(iIdGrupo);

		return list;
	}

}