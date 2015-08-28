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
import com.sinergitec.ischool.dao.sg.ctPuestoDao;
import com.sinergitec.ischool.model.sg.ctPuesto;
import com.sinergitec.ischool.service.ctPuestoService;


@Service
public class ctPuestoServiceImp implements ctPuestoService {
	@Autowired
	private ctPuestoDao dao;

	@Override
	public void add_ctPuesto(ctPuesto obj) {
		// TODO Auto-generated method stub
		
		
		
		
		try {
			dao.add_ctPuesto(obj);
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
	public void update_ctPuesto(ctPuesto obj) {
		// TODO Auto-generated method stub
		
		try {
			dao.update_ctPuesto(obj);
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
	public List<ctPuesto> list_ctPuesto() {
		// TODO Auto-generated method stub
		
		List<ctPuesto> Lista =new ArrayList<ctPuesto>();
	
		try {
			Lista=	 dao.list_ctPuesto();
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
	public ctPuesto get_ctPuesto(int id) {
		// TODO Auto-generated method stub
		ctPuesto obj = new ctPuesto();
		
		try {
			obj = dao.get_ctPuesto(id);
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
	public void remove_ctPuesto(int id) {
		// TODO Auto-generated method stub
		try {
			dao.remove_ctPuesto(id);
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
