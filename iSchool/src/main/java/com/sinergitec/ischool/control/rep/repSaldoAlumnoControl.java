package com.sinergitec.ischool.control.rep;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.ischool.model.cb.cbAlumnoSaldo;
import com.sinergitec.ischool.model.ct.ctGrupo;
import com.sinergitec.ischool.service.ct.ctGrupoService;
import com.sinergitec.ischool.service.rep.repSaldoAlumnoService;

@Controller
public class repSaldoAlumnoControl {
	
	List<cbAlumnoSaldo> list;
	
	@Autowired
	private repSaldoAlumnoService repService;
	
	@Autowired
	private ctGrupoService ctGrupoService;
	
	@RequestMapping(value = "/repSaldoAlumno", method = RequestMethod.GET)
	public String grupo(Model model) throws Open4GLException, IOException {

		model.addAttribute("ctGrupo", new ctGrupo());
		model.addAttribute("lista_ctGrupo", this.ctGrupoService.list_ctGrupo());

		return "repSaldoAlumno";
	}
	
	@RequestMapping(value = "/repSaldoAlumno/getAlumnos", headers = "Accept=application/json")
	public @ResponseBody List<cbAlumnoSaldo> list_repAlumnoGrupo(int iIdGrupo) {
		
		list = this.repService.list_cbAlumno(iIdGrupo);

		return list;
	}

}
