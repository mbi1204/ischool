package com.sinergitec.ischool.dao.ct;

import java.io.IOException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.ischool.model.ct.ctGrupo;

public interface ctGrupoDao {
	
	public void add_ctGrupo(ctGrupo obj_Grupo) throws Open4GLException, IOException;
	
	public void update_ctGrupo(ctGrupo obj_ctGrupo) throws Open4GLException, IOException;
	
	public void remove_ctGrupo(int id) throws Open4GLException, IOException;
	
	public List<ctGrupo> list_ctGrupo() throws Open4GLException, IOException;
	
	public ctGrupo get_ctGrupo(int id) throws Open4GLException, IOException;
}
