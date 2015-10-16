package com.sinergitec.ischool.service.imp.ct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.ischool.dao.ct.ctGrupoDao;
import com.sinergitec.ischool.model.ct.ctGrupo;
import com.sinergitec.ischool.service.ct.ctGrupoDisponibleService;

@Service
public class ctGrupoDisponibleServiceImp implements ctGrupoDisponibleService {

	@Autowired
	private ctGrupoDao ctGrupoDao;

	public List<ctGrupo> list_ctGrupo() {

		List<ctGrupo> Lista = new ArrayList<ctGrupo>();
		try {
			Lista = ctGrupoDao.list_ctGrupo();
		} catch (Open4GLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Lista;
	}

	@Override
	public ctGrupo get_Grupo(int id){
		
		ctGrupo obj = new ctGrupo();
		try {
			obj = ctGrupoDao.get_ctGrupo(id);
		} catch (Open4GLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

}
