package com.sinergitec.ischool.dao.ct;

import java.io.IOException;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.ischool.model.ct.ctGrupo;

public interface ctGrupoDao {
	
	public void agregarGrupo(ctGrupo obj_Grupo) throws Open4GLException, IOException;
	
	public void editarGrupo(ctGrupo obj_ctGrupo) throws Open4GLException, IOException;
	
	public void eliminarGrupo(int id) throws Open4GLException, IOException;
}
