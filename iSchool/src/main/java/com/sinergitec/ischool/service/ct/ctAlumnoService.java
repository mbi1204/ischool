package com.sinergitec.ischool.service.ct;

import java.util.List;

import com.sinergitec.ischool.model.ct.ctAlumno;
import com.sinergitec.ischool.model.ct.ctGrupo;

public interface ctAlumnoService {

	public String add_ctAlumno(ctAlumno obj, List<ctGrupo> listaGrupo);

}
