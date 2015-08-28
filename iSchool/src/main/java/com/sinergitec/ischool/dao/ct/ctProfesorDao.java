package com.sinergitec.ischool.dao.ct;

import java.io.IOException;
import com.progress.open4gl.Open4GLException;
import com.sinergitec.ischool.model.ct.ctProfesor;

public interface ctProfesorDao {
	
	public void add_ctProfesor(ctProfesor obj_ctProfesor) throws Open4GLException, IOException;
	
	public void update_ctProfesor(ctProfesor obj_ctProfesor) throws Open4GLException, IOException;
	
	public void remove_ctProfesor(int id) throws Open4GLException, IOException;
}
