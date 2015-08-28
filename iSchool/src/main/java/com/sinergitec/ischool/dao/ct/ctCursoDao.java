package com.sinergitec.ischool.dao.ct;

import java.io.IOException;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.ischool.model.ct.ctCurso;;

public interface ctCursoDao {
	public void add_ctCurso(ctCurso obj_ctCurso) throws Open4GLException, IOException;
	
	public void update_ctCurso(ctCurso obj_ctCurso) throws Open4GLException, IOException;
	
	public void remove_ctCurso(int id) throws Open4GLException, IOException;
}
