package com.sinergitec.ischool.service.imp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.dao.ctProgramaDao;
import com.sinergitec.ischool.model.sg.ctPrograma;
import com.sinergitec.ischool.service.ctProgramaService;


@Service
public class ctProgramaServiceImp implements ctProgramaService {
	@Autowired
	private ctProgramaDao dao;

	@Override
	public void add_ctPrograma(ctPrograma obj) {
		// TODO Auto-generated method stub
		
		
		
		
		try {
			dao.add_ctPrograma(obj);
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
		}
		
		
	}

	@Override
	public void update_ctPrograma(ctPrograma obj) {
		// TODO Auto-generated method stub
		
		try {
			dao.update_ctPrograma(obj);
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
		}

	}

	@Override
	public List<ctPrograma> list_ctPrograma() {
		// TODO Auto-generated method stub
		
		List<ctPrograma> Lista =new ArrayList<ctPrograma>();
	
		try {
			Lista=	 dao.list_ctPrograma();
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

	@Override
	public ctPrograma get_ctPrograma(int iMenu ,int iPrograma) {
		// TODO Auto-generated method stub
		ctPrograma obj = new ctPrograma();
		
		try {
			obj = dao.get_ctPrograma(iMenu, iPrograma);
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
		
		
		
		return obj;
	}

	@Override
	public void remove_ctPrograma(int iMenu ,int iPrograma) {
		// TODO Auto-generated method stub
		try {
			dao.remove_ctPrograma(iMenu, iPrograma);
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
		}

	}

}
