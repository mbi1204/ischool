package com.sinergitec.ischool.dao.ct;

import java.io.IOException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.model.ct.ctAlumno;
import com.sinergitec.ischool.model.ct.ctGrupo;;

public interface ctAlumnoDao {

	public void add_ctAlumno(ctAlumno obj, List<ctGrupo> listaGrupo) throws Open4GLException, IOException;

	public void update_ctAlumno(ctAlumno obj) throws Open4GLException, IOException;

	public void remove_ctAlumno(int id) throws RunTime4GLException, SystemErrorException, Open4GLException, IOException;
}
