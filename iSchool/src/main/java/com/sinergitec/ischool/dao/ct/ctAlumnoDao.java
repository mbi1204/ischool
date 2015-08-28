package com.sinergitec.ischool.dao.ct;

import java.io.IOException;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.model.ct.ctAlumno;;

public interface ctAlumnoDao {
	
	public void add_ctAlumno(ctAlumno obj) throws Open4GLException, IOException;
	
	public void update_ctAlumno(ctAlumno obj) throws Open4GLException, IOException;
	
	public void remove_Alumno(int id) throws RunTime4GLException, SystemErrorException, Open4GLException, IOException;
}
