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
import com.sinergitec.ischool.dao.rep.repFacturaDao;
import com.sinergitec.ischool.model.ft.ftFacturaAlumno;
import com.sinergitec.ischool.service.rep.repFacturaService;

@Service
public class repFacturaServiceImp implements repFacturaService{
	
	@Autowired
	private repFacturaDao dao;

	@Override
	public List<ftFacturaAlumno> list_ftFactura(int idGrupo) {
		// TODO Auto-generated method stub
		List<ftFacturaAlumno> Lista =new ArrayList<ftFacturaAlumno>();
		try {
			Lista = dao.list_ftFactura(idGrupo);
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
