package com.sinergitec.ischool.service.imp.sg;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.dao.sg.ctUsuarioDao;
import com.sinergitec.ischool.model.sg.ctUsuario;
import com.sinergitec.ischool.service.sg.ctUsuarioService;
@Service
public class ctUsuarioServiceImp implements ctUsuarioService {

	@Autowired
	private ctUsuarioDao dao;
	
	@Override
	public void add_ctUsuario(ctUsuario obj) {
		// TODO Auto-generated method stub
		try {
			dao.add_ctUsuario(obj);
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
	public void update_ctUsuario(ctUsuario obj) {
		// TODO Auto-generated method stub
		
		try {
			dao.update_ctUsuario(obj);
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
	public List<ctUsuario> list_ctUsuario() {
		// TODO Auto-generated method stub
		List<ctUsuario> Lista =new ArrayList<ctUsuario>();
		try {
			Lista = dao.list_ctUsuario();
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
	public ctUsuario get_ctUsuario(String id) {
		// TODO Auto-generated method stub
		
		ctUsuario obj = new ctUsuario();
		try {
			obj = dao.get_ctUsuario(id);
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
	public void remove_ctUsuario(String id) {
		// TODO Auto-generated method stub
		
		try {
			dao.remove_ctUsuario(id);
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
	public String get_login(ctUsuario Obj) {
		// TODO Auto-generated method stub
		
		String vcRespuesta = null;
		
		try {
			vcRespuesta = dao.get_login(Obj);
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
		
		return vcRespuesta;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<List> getAllMenu(String cUsuario) {
		
		List<List>   lista      = new ArrayList<List>();
		// TODO Auto-generated method stub
		try {
			lista = dao.getAllMenu(cUsuario);
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
		
		return lista;
	}

}
