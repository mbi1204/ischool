package com.sinergitec.ischool.service.ct;

import java.io.IOException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.ischool.model.ct.ctGrupo;

public interface ctGrupoService {
	
	public void add_ctGrupo(ctGrupo obj_Grupo) throws Open4GLException, IOException;
	
	public void update_ctGrupo(ctGrupo obj_ctGrupo) throws Open4GLException, IOException;
	
	public void remove_ctGrupo(int id) throws Open4GLException, IOException;
	
	public List<ctGrupo> list_ctGrupo() throws Open4GLException, IOException;
	
	public ctGrupo get_Grupo(int g) throws Open4GLException, IOException;
}
 