package com.sinergitec.ischool.service.rep.imp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.dao.rep.repAlumnoGrupoDao;
import com.sinergitec.ischool.model.ct.ctAlumno;
import com.sinergitec.ischool.service.rep.repAlumnoGrupoService;

@Service
public class repAlumnoGrupoServiceImp implements repAlumnoGrupoService {
	
	@Autowired
	private repAlumnoGrupoDao dao;

	@Override
	public List<ctAlumno> list_ctAlumno(int idGrupo) {
		// TODO Auto-generated method stub
		
		List<ctAlumno> Lista =new ArrayList<ctAlumno>();
		try {
			Lista = dao.list_ctAlumno(idGrupo);
		} catch (RunTime4GLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Open4GLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return Lista;
		
	}

}
