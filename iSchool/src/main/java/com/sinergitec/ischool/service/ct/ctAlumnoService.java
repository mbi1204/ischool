package com.sinergitec.ischool.service.ct;

import java.io.IOException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.ischool.model.ct.AlumnoError;
import com.sinergitec.ischool.model.ct.ctAlumno;
import com.sinergitec.ischool.model.ct.ctGrupo;

public interface ctAlumnoService {

	public AlumnoError add_ctAlumno(ctAlumno obj, List<ctGrupo> listaGrupo);
	
	public ctAlumno get_ctAlumno(int id);
	
	public void update_ctAlumno(ctAlumno obj) throws Open4GLException, IOException;

}
