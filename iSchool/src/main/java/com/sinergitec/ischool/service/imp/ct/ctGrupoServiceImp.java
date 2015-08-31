package com.sinergitec.ischool.service.imp.ct;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.ischool.dao.ct.ctGrupoDao;
import com.sinergitec.ischool.model.ct.ctGrupo;
import com.sinergitec.ischool.service.ct.ctGrupoService;

public class ctGrupoServiceImp implements ctGrupoService {
	
	@Autowired
	private ctGrupoDao ctGrupoDao;

	public void add_ctGrupo(ctGrupo obj_Grupo) throws Open4GLException, IOException{
		this.ctGrupoDao.add_ctGrupo(obj_Grupo);
	}
	
	public void update_ctGrupo(ctGrupo obj_ctGrupo) throws Open4GLException, IOException{
		this.ctGrupoDao.update_ctGrupo(obj_ctGrupo);
	}
	
	public void remove_ctGrupo(int id) throws Open4GLException, IOException{
		this.ctGrupoDao.remove_ctGrupo(id);
	}
}
