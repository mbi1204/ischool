package com.sinergitec.ischool.control.ft;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.ischool.model.ct.ctAlumno;
import com.sinergitec.ischool.model.ct.ctGrupo;
import com.sinergitec.ischool.model.ct.ctLocalidad;
import com.sinergitec.ischool.model.ft.ftDetFactura;
import com.sinergitec.ischool.model.ft.ftFacturaAlumno;
import com.sinergitec.ischool.service.ct.ctAlumnoService;
import com.sinergitec.ischool.service.ct.ctGrupoService;
import com.sinergitec.ischool.service.ft.repDetFacturaService;
import com.sinergitec.ischool.service.ft.repFacturaService;
import com.sinergitec.ischool.service.imp.ct.ctLocalidadServiceImp;

@Controller
public class repFacturaControl {
	
	List<ftFacturaAlumno> list;
	
	@Autowired
	private repFacturaService repService;
	
	@Autowired
	private repDetFacturaService repDetService;
	
	@Autowired
	private ctGrupoService ctGrupoService;
	
	@Autowired
	private ctAlumnoService ctAlumnoService;
	
	@Autowired
	private ctLocalidadServiceImp localidadService;
	
	
	@RequestMapping(value = "/repFactura", method = RequestMethod.GET)
	public String grupo(Model model) throws Open4GLException, IOException {

		model.addAttribute("ctGrupo", new ctGrupo());
		model.addAttribute("lista_ctGrupo", this.ctGrupoService.list_ctGrupo());
		model.addAttribute("ctAlumno", new ctAlumno());		

		return "repFactura";
	}
	
	@RequestMapping(value = "/repFactura/getAlumnos", headers = "Accept=application/json")
	public @ResponseBody List<ftFacturaAlumno> list_repAlumnoGrupo(int iIdGrupo) {
		
		list = this.repService.list_ftFactura(iIdGrupo);		

		return list;
	}
	
	@RequestMapping(value = "/repFactura/detalle", headers = "Accept=application/json")
	public @ResponseBody List<ftDetFactura> list_ftDetFactura(int iFolio, int iSerie){		
		
		List<ftDetFactura> lista = new ArrayList<ftDetFactura>();
		lista = repDetService.list_ftDetFactura(iFolio, iSerie);
		return lista;		
	}
	
	@RequestMapping(value = "/repFactura/alumno/{iAlumno}", method = RequestMethod.GET)
	public String get_alumno(@PathVariable("iAlumno") int iAlumno, Model model) throws Open4GLException, IOException{		
		
		ctAlumno obj = new ctAlumno();
				
		obj=this.ctAlumnoService.get_ctAlumno(iAlumno);	
		
		model.addAttribute("ctAlumno", obj);
		
		return "ctAlumno_dialog";
	}
	
	@RequestMapping(value = "/repFactura/editar", method = RequestMethod.POST)
	public String update_alumno(@ModelAttribute("ctAlumno") ctAlumno obj) throws Open4GLException, IOException{
		
		ctAlumnoService.update_ctAlumno(obj);
		
		return "redirect:/repFactura";
	}
	
	@RequestMapping(value = "/repFactura/getLocalidad")
	public @ResponseBody List<ctLocalidad> get_Localidad(String cCP) {
		List<ctLocalidad> lista = new ArrayList<ctLocalidad>();
		lista = this.localidadService.list_ctLocalidades(cCP);
		System.out.println("entro");
		return lista;

	}

}
