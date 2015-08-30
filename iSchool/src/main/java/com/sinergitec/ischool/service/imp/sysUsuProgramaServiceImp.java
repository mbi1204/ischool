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
import com.sinergitec.ischool.dao.sg.sysUsuProgramaDao;
import com.sinergitec.ischool.model.sg.sysUsuPrograma;
import com.sinergitec.ischool.service.sysUsuProgramaService;


@Service
public class sysUsuProgramaServiceImp implements sysUsuProgramaService {
	@Autowired
	private sysUsuProgramaDao dao;

	@Override
	public void add_sysUsuPrograma(sysUsuPrograma obj) {
		// TODO Auto-generated method stub
		
		
		
		
		try {
			dao.add_sysUsuPrograma(obj);
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
	public void update_sysUsuPrograma(sysUsuPrograma obj) {
		// TODO Auto-generated method stub
		
		try {
			dao.update_sysUsuPrograma(obj);
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
	public List<sysUsuPrograma> list_sysUsuPrograma(String cUsuario ,int iPrograma, Boolean lActivo) {
		// TODO Auto-generated method stub
		
		List<sysUsuPrograma> Lista =new ArrayList<sysUsuPrograma>();
	
		try {
			Lista=	 dao.list_sysUsuPrograma(cUsuario,iPrograma, lActivo);
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
	public sysUsuPrograma get_sysUsuPrograma(int id) {
		// TODO Auto-generated method stub
		sysUsuPrograma obj = new sysUsuPrograma();
		
		try {
			obj = dao.get_sysUsuPrograma(id);
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
	public void remove_sysUsuPrograma(String cUsuario ,int iMenu, int iPrograma) {
		// TODO Auto-generated method stub
		try {
			dao.remove_sysUsuPrograma(cUsuario, iMenu,iPrograma);
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
