package com.sinergitec.ischool.service.ct;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.model.ct.AlumnoError;
import com.sinergitec.ischool.model.ct.ctAlumno;
import com.sinergitec.ischool.model.ct.ctGrupo;

public interface ctAlumnoService {

	public AlumnoError add_ctAlumno(ctAlumno obj, List<ctGrupo> listaGrupo);
	
	public ctAlumno get_ctAlumno(int id)throws RunTime4GLException, SystemErrorException, Open4GLException, IOException, SQLException;

}
