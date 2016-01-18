package com.sinergitec.ischool.control.ct;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sinergitec.ischool.model.ct.AlumnoError;
import com.sinergitec.ischool.model.ct.ctAlumno;
import com.sinergitec.ischool.model.ct.ctCurso;
import com.sinergitec.ischool.model.ct.ctGrupo;
import com.sinergitec.ischool.model.ct.ctLocalidad;
import com.sinergitec.ischool.service.ct.ctAlumnoService;
import com.sinergitec.ischool.service.ct.ctGrupoDisponibleService;
import com.sinergitec.ischool.service.imp.ct.ctLocalidadServiceImp;

@Controller
public class ctAlumnoController {

	@Autowired
	private ctAlumnoService alumnoService;

	@Autowired
	private ctGrupoDisponibleService grupoService;

	@Autowired
	private ctLocalidadServiceImp localidadService;

	@RequestMapping(value = "/ctAlumno", method = RequestMethod.GET)
	public String alumno(Locale locale, Model model) {

		model.addAttribute("ctAlumno", new ctAlumno());
		model.addAttribute("Lista_Grupo", this.grupoService.list_ctGrupo());

		return "ctAlumnoForm";
	}

	@RequestMapping(value = "/ctAlumno/agregar", method = RequestMethod.POST)
	public ModelAndView addPerson(@ModelAttribute("ctAlumno") ctAlumno obj, RedirectAttributes redirectAttrs) {
		String vcError;
		
		ctAlumno objAlumno = new ctAlumno(); 
		
		AlumnoError alumnoError = new AlumnoError();

		ModelAndView miModelo = new ModelAndView("pdfView");

		

		JSONArray jsonArray = new JSONArray(obj.getcGrupo());
		List<ctGrupo> listaGrupo = new ArrayList<ctGrupo>();

		for (int i = 0; i < jsonArray.length(); i++) {

			ctGrupo objGrupo = new ctGrupo();
			ctCurso objCurso = new ctCurso();

			objGrupo.setiIdGrupo(Integer.parseInt(jsonArray.getJSONObject(i).getString("id_Grupo")));
			objGrupo.setcNombre(jsonArray.getJSONObject(i).getString("cNombre_Grupo"));
			objGrupo.setcHorario(jsonArray.getJSONObject(i).getString("cHorario"));
			objGrupo.setiIdCurso(Integer.parseInt(jsonArray.getJSONObject(i).getString("id_Curso")));
			objGrupo.setcDias(jsonArray.getJSONObject(i).getString("cDias"));
			objCurso.setcNombre(jsonArray.getJSONObject(i).getString("cNombre_Curso"));
			BigDecimal precio = new BigDecimal(jsonArray.getJSONObject(i).getString("dePrecio"));
			objCurso.setDePrecio(precio);
			objGrupo.setCurso(objCurso);
			listaGrupo.add(objGrupo);
		}

//		vcError = this.alumnoService.add_ctAlumno(obj, listaGrupo);
		alumnoError = this.alumnoService.add_ctAlumno(obj, listaGrupo);
		vcError = alumnoError.getError();
		objAlumno = alumnoError.getAlumno();
		
		
		
		System.out.println( vcError + "->"+vcError.isEmpty());

		
		if (vcError.isEmpty()) {
			System.out.println("if Empty ");
			miModelo.addObject("ctAlumno", objAlumno);
			miModelo.addObject("listaGrupo", listaGrupo);

			return miModelo;

		} else {
			
			redirectAttrs.addFlashAttribute("errors", vcError);
			return new ModelAndView(vcError);
		}

	}

	@RequestMapping(value = "/ctAlumno/getGrupo", method = RequestMethod.GET)
	public @ResponseBody ctGrupo getGrupo(int id) {

		ctGrupo obj = new ctGrupo();

		obj = this.grupoService.get_Grupo(id);

		return obj;
	}

	@RequestMapping(value = "/ctAlumno/getLocalidad")
	public @ResponseBody List<ctLocalidad> get_Localidad(String cCP) {
		List<ctLocalidad> lista = new ArrayList<ctLocalidad>();
		lista = this.localidadService.list_ctLocalidades(cCP);
		return lista;

	}

}