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
import com.sinergitec.ischool.model.ct.ctAlumno;
import com.sinergitec.ischool.model.ct.ctGrupo;
import com.sinergitec.ischool.model.ft.ftFacturaAlumno;
import com.sinergitec.ischool.service.ct.ctGrupoService;
import com.sinergitec.ischool.service.rep.repFacturaService;

@Controller
public class repFacturaControl {
	
	List<ftFacturaAlumno> list;
	
	@Autowired
	private repFacturaService repService;
	
	@Autowired
	private ctGrupoService ctGrupoService;
	
	@RequestMapping(value = "/repFactura", method = RequestMethod.GET)
	public String grupo(Model model) throws Open4GLException, IOException {

		model.addAttribute("ctGrupo", new ctGrupo());
		model.addAttribute("lista_ctGrupo", this.ctGrupoService.list_ctGrupo());

		return "repFactura";
	}
	
	@RequestMapping(value = "/repFactura/getAlumnos", headers = "Accept=application/json")
	public @ResponseBody List<ftFacturaAlumno> list_repAlumnoGrupo(int iIdGrupo) {
		
		list = this.repService.list_ftFactura(iIdGrupo);
		for (ftFacturaAlumno ftFacturaAlumno : list) {
			System.out.println("control");
			System.out.println(ftFacturaAlumno.getDeSubtotal());
		}

		return list;
	}

}
