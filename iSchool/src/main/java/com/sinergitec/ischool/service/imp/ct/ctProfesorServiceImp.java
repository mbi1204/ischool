package com.sinergitec.ischool.service.imp.ct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.dao.ct.ctProfesorDao;
import com.sinergitec.ischool.model.ct.ctProfesor;
import com.sinergitec.ischool.service.ct.ctProfesorService;
@Service
public class ctProfesorServiceImp implements ctProfesorService {

	@Autowired
	private ctProfesorDao dao;
	
	@Override
	public void add_ctProfesor(ctProfesor obj) {
		// TODO Auto-generated method stub
		try {
			dao.add_ctProfesor(obj);
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
	public void update_ctProfesor(ctProfesor obj) {
		// TODO Auto-generated method stub
		
		try {
			dao.update_ctProfesor(obj);
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
	public List<ctProfesor> list_ctProfesor() {
		// TODO Auto-generated method stub
		List<ctProfesor> Lista =new ArrayList<ctProfesor>();
		
		
		try {
			Lista = dao.list_ctProfesor();
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
		
		
		return Lista;
	}

	@Override
	public ctProfesor get_ctProfesor(int id) {
		// TODO Auto-generated method stub
		
		ctProfesor obj = new ctProfesor();
		try {
			obj = dao.get_ctProfesor(id);
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
		
		
		return obj;
	}

	@Override
	public void remove_ctProfesor(int id) {
		// TODO Auto-generated method stub
		
		try {
			dao.remove_ctProfesor(id);
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
