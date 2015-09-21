package com.sinergitec.ischool.service.imp.ct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.ischool.dao.ct.ctGrupoDao;
import com.sinergitec.ischool.model.ct.ctGrupo;
import com.sinergitec.ischool.service.ct.ctGrupoService;
@Service
public class ctGrupoServiceImp implements ctGrupoService {
	
	@Autowired
	private ctGrupoDao ctGrupoDao;

	public void add_ctGrupo(ctGrupo obj_Grupo){
		try {
			this.ctGrupoDao.add_ctGrupo(obj_Grupo);
		} catch (Open4GLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update_ctGrupo(ctGrupo obj_ctGrupo){
		try {
			this.ctGrupoDao.update_ctGrupo(obj_ctGrupo);
		} catch (Open4GLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remove_ctGrupo(int id){
		try {
			this.ctGrupoDao.remove_ctGrupo(id);
		} catch (Open4GLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<ctGrupo> list_ctGrupo(){
		
		List<ctGrupo> Lista =new ArrayList<ctGrupo>();
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
