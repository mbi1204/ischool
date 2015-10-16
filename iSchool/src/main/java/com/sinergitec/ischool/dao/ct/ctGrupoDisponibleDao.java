package com.sinergitec.ischool.dao.ct;

import java.io.IOException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.ischool.model.ct.ctGrupo;

public interface ctGrupoDisponibleDao {

	public List<ctGrupo> list_ctGrupo() throws Open4GLException, IOException;
	
	public ctGrupo get_ctGrupo(int id) throws Open4GLException, IOException;

}
