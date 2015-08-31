package com.sinergitec.ischool.dao.ct;

import java.io.IOException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.ischool.model.ct.ctGrupo;
import com.sinergitec.ischool.model.ct.ctProfesor;

public interface ctProfesorDao {

	public void add_ctProfesor(ctProfesor obj_ctProfesor) throws Open4GLException, IOException;

	public void update_ctProfesor(ctProfesor obj_ctProfesor) throws Open4GLException, IOException;

	public void remove_ctProfesor(int id) throws Open4GLException, IOException;

	public List<ctProfesor> list_ctProfesor() throws Open4GLException, IOException;

	public ctProfesor get_ctProfesor(int id) throws Open4GLException, IOException;
}
