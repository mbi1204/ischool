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
import com.sinergitec.ischool.dao.sysUsuMenuDao;
import com.sinergitec.ischool.model.sg.sysUsuMenu;
import com.sinergitec.ischool.service.sysUsuMenuService;


@Service
public class sysUsuMenuServiceImp implements sysUsuMenuService {
	@Autowired
	private sysUsuMenuDao dao;

	@Override
	public void add_sysUsuMenu(sysUsuMenu obj) {
		// TODO Auto-generated method stub
		
		
		
		
		try {
			dao.add_sysUsuMenu(obj);
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
	public void update_sysUsuMenu(sysUsuMenu obj) {
		// TODO Auto-generated method stub
		
		try {
			dao.update_sysUsuMenu(obj);
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
	public List<sysUsuMenu> list_sysUsuMenu(String cUsuario , Boolean lActivo) {
		// TODO Auto-generated method stub
		
		List<sysUsuMenu> Lista =new ArrayList<sysUsuMenu>();
	
		try {
			Lista=	 dao.list_sysUsuMenu(cUsuario, lActivo);
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
	public sysUsuMenu get_sysUsuMenu(int id) {
		// TODO Auto-generated method stub
		sysUsuMenu obj = new sysUsuMenu();
		
		try {
			obj = dao.get_sysUsuMenu(id);
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
	public void remove_sysUsuMenu(String cUsuario ,int iMenu) {
		// TODO Auto-generated method stub
		try {
			dao.remove_sysUsuMenu(cUsuario, iMenu);
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
