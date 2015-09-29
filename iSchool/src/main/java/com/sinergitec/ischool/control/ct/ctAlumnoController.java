package com.sinergitec.ischool.control.ct;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.model.ct.ctAlumno;
import com.sinergitec.ischool.model.ct.ctCurso;
import com.sinergitec.ischool.model.ct.ctGrupo;
import com.sinergitec.ischool.service.ct.ctAlumnoService;
import com.sinergitec.ischool.service.ct.ctCursoService;
import com.sinergitec.ischool.service.ct.ctGrupoService;

@Controller
public class ctAlumnoController {

	@Autowired
	private ctAlumnoService alumnoService;	

	@Autowired
	private ctGrupoService grupoService;

	@RequestMapping(value = "/ctAlumno", method = RequestMethod.GET)
	public String alumno(Locale locale, Model model) {

		model.addAttribute("ctAlumno", new ctAlumno());
		model.addAttribute("Lista_Grupo", this.grupoService.list_ctGrupo());

		return "ctAlumnoForm";
	}

	@RequestMapping(value = "/ctAlumno/agregar", method = RequestMethod.POST)
	public ModelAndView addPerson(@ModelAttribute("ctAlumno") ctAlumno obj) {
		ModelAndView miModelo = new ModelAndView("pdfView");

		JSONArray jsonArray = new JSONArray(obj.getcGrupo());
		List<ctGrupo> listaGrupo = new ArrayList<ctGrupo>();

		for (int i = 0; i < jsonArray.length(); i++) {

			// ctGrupo obj_Grupo = new ctGrupo();

			// obj_Grupo.setiIdGrupo((jsonArray.getJSONObject(i).getString("id_Grupo"));
			// obj_Grupo.setcNombre(jsonArray.getJSONObject(i).getString("cNombre_Grupo"));

			ctGrupo objGrupo = new ctGrupo();
			ctCurso objCurso = new ctCurso();

			objGrupo.setiIdGrupo(Integer.parseInt(jsonArray.getJSONObject(i).getString("id_Grupo")));
			objGrupo.setcNombre(jsonArray.getJSONObject(i).getString("cNombre_Grupo"));
			objGrupo.setcHorario(jsonArray.getJSONObject(i).getString("cHorario"));
			objCurso.setcNombre(jsonArray.getJSONObject(i).getString("cNombre_Curso"));
			BigDecimal precio = new BigDecimal(jsonArray.getJSONObject(i).getString("dePrecio"));
			objCurso.setDePrecio(precio);
			objGrupo.setCurso(objCurso);
			listaGrupo.add(objGrupo);
		}
		
		
		this.alumnoService.add_ctAlumno(obj, listaGrupo);

		miModelo.addObject("ctAlumno", obj);
		miModelo.addObject("listaGrupo", listaGrupo);

		return miModelo;

	}

	@RequestMapping(value = "/ctAlumno/getGrupo", method = RequestMethod.GET)
	public @ResponseBody ctGrupo getGrupo(int id) {

		ctGrupo obj = new ctGrupo();

		obj = this.grupoService.get_Grupo(id);

		return obj;
	}

	@RequestMapping(value = "/pruebaxx", method = RequestMethod.GET)

	public String pruebaxx(String cUsuario, String dataArray1) {
		JSONArray jsonArray = new JSONArray(dataArray1);
		List<String> list = new ArrayList<String>();

		for (int i = 0; i < jsonArray.length(); i++) {

			String val = jsonArray.optString(i);
			System.out.println(jsonArray.getJSONObject(i).getString("firstName"));
			System.out.println(jsonArray.getJSONObject(i).getString("lastName"));

		}

		return "salio";
	}

}