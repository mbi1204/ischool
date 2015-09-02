package com.sinergitec.ischool.service.sg;

import java.util.List;

import com.sinergitec.ischool.model.sg.ctUsuario;


public interface ctUsuarioService {
	public void add_ctUsuario(ctUsuario obj);

	public void update_ctUsuario(ctUsuario obj);

	public List<ctUsuario> list_ctUsuario();

	public ctUsuario get_ctUsuario(String id);

	public void remove_ctUsuario(String id);

}
