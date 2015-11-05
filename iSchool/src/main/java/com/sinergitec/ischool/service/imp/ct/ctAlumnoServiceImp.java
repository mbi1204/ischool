package com.sinergitec.ischool.service.imp.ct;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.ischool.dao.ct.ctAlumnoDao;
import com.sinergitec.ischool.model.ct.ctAlumno;
import com.sinergitec.ischool.model.ct.ctGrupo;
import com.sinergitec.ischool.service.ct.ctAlumnoService;

@Service
public class ctAlumnoServiceImp implements ctAlumnoService {

	@Autowired
	private ctAlumnoDao ctAlumnoDao;

	public String   add_ctAlumno(ctAlumno obj, List<ctGrupo> listaGrupo) {
		String vcError = null;
		try {
			vcError = this.ctAlumnoDao.add_ctAlumno(obj, listaGrupo);
			
		} catch (Open4GLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			vcError   = e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			vcError   = e.getMessage();
		}
		
		return vcError;
	}

}
