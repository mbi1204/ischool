package com.sinergitec.ischool.dao.ct;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.model.ct.ctCurso;;

public interface ctCursoDao {
	
	public void add_ctCurso(ctCurso obj_ctCurso) throws Open4GLException, IOException;
	
	public void update_ctCurso(ctCurso obj_ctCurso) throws Open4GLException, IOException;
	
	public void remove_ctCurso(int id) throws Open4GLException, IOException;
	
	public List<ctCurso> list_ctCurso() throws Open4GLException, IOException;
	
	public ctCurso get_ctPuesto(int id) throws RunTime4GLException, SystemErrorException, Open4GLException, IOException, SQLException;
}
