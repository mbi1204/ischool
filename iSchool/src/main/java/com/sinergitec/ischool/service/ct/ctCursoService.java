package com.sinergitec.ischool.service.ct;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.model.ct.ctCurso;

public interface ctCursoService {
	
	public void add_ctCurso(ctCurso c) throws Open4GLException, IOException;
	
	public void update_ctCurso(ctCurso c) throws Open4GLException, IOException;
	
	public void remove_ctCurso(int c) throws Open4GLException, IOException;
	
	public List<ctCurso> listaCurso() throws Open4GLException, IOException;

	public ctCurso get_Curso(int id) throws RunTime4GLException, SystemErrorException, Open4GLException, IOException, SQLException;
}
