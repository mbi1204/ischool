package com.sinergitec.ischool.service.imp.ct;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.dao.ct.ctAlumnoDao;
import com.sinergitec.ischool.model.ct.ctAlumno;
import com.sinergitec.ischool.service.ct.ctAlumnoService;

@Service
public class ctAlumnoServiceImp implements ctAlumnoService {
	
	@Autowired
	private ctAlumnoDao ctAlumnoDao;
	
	public void add_ctAlumno(ctAlumno obj) throws Open4GLException, IOException{
		this.ctAlumnoDao.add_ctAlumno(obj);
	}
	
	public void update_ctAlumno(ctAlumno obj) throws Open4GLException, IOException{
		this.ctAlumnoDao.update_ctAlumno(obj);
	}
	
	public void remove_ctAlumno(int id) throws RunTime4GLException, SystemErrorException, Open4GLException, IOException{
		this.ctAlumnoDao.remove_ctAlumno(id);
	}
}
