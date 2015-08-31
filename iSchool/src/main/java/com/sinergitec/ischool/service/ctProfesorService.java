package com.sinergitec.ischool.service;

import java.util.List;

import com.sinergitec.ischool.model.ct.ctProfesor;
import com.sinergitec.ischool.model.sg.ctUsuario;


public interface ctProfesorService {

	public void add_ctProfesor (ctProfesor obj);
	
	public void update_ctProfesor(ctProfesor obj) ;
	
	public List<ctProfesor> list_ctProfesor();
	
	public void remove_ctProfesor(String id) ;
	
	public ctProfesor get_ctProfesor(String id);
}