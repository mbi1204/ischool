package com.sinergitec.ischool.service.rep.imp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.dao.rep.repSaldoAlumnoDao;
import com.sinergitec.ischool.model.cb.cbAlumnoSaldo;
import com.sinergitec.ischool.model.ct.ctAlumno;
import com.sinergitec.ischool.service.rep.repSaldoAlumnoService;

public class repSaldoAlumnoServiceImp implements repSaldoAlumnoService {
	
	@Autowired
	private repSaldoAlumnoDao dao;

	@Override
	public List<cbAlumnoSaldo> list_cbAlumno(int idGrupo) {
		// TODO Auto-generated method stub
		List<cbAlumnoSaldo> Lista =new ArrayList<cbAlumnoSaldo>();
		try {
			Lista = dao.list_cbAlumno(idGrupo);
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
