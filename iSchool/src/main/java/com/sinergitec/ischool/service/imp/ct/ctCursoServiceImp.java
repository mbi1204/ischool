package com.sinergitec.ischool.service.imp.ct;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.dao.ct.ctCursoDao;
import com.sinergitec.ischool.model.ct.ctCurso;
import com.sinergitec.ischool.service.ct.ctCursoService;

@Service
public class ctCursoServiceImp implements ctCursoService {
	
	@Autowired
	private ctCursoDao ctCursosDao;
	
	public void add_ctCurso(ctCurso c) throws Open4GLException, IOException{
		this.ctCursosDao.add_ctCurso(c);
	}
	
	public void update_ctCurso(ctCurso c) throws Open4GLException, IOException{
		this.ctCursosDao.update_ctCurso(c);
	}
	
	public void remove_ctCurso(int c) throws Open4GLException, IOException{
		this.ctCursosDao.remove_ctCurso(c);
	}
	
	public List<ctCurso> list_ctCurso() throws Open4GLException, IOException{
		List<ctCurso> Lista =new ArrayList<ctCurso>();
		Lista = ctCursosDao.list_ctCurso();
		return Lista;
	}
	
	public ctCurso get_Curso(int id) throws RunTime4GLException, SystemErrorException, Open4GLException, IOException, SQLException{
		
		ctCurso obj = new ctCurso();
		obj = ctCursosDao.get_ctPuesto(id);
		return obj;
	}
	
}
