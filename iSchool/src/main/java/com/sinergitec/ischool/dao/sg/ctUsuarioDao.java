package com.sinergitec.ischool.dao.sg;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.model.sg.ctUsuario;

public interface ctUsuarioDao {
	public String add_ctUsuario(String cUsuario,ctUsuario obj)
			throws RunTime4GLException, SystemErrorException, Open4GLException, IOException;

	public String update_ctUsuario(String cUsuario ,ctUsuario obj)
			throws RunTime4GLException, SystemErrorException, Open4GLException, IOException;

	public List<ctUsuario> list_ctUsuario()
			throws RunTime4GLException, SystemErrorException, Open4GLException, IOException, SQLException;

	public ctUsuario get_ctUsuario(String id)
			throws RunTime4GLException, SystemErrorException, Open4GLException, IOException, SQLException;

	public String remove_ctUsuario(String cUsuario ,String id)
			throws RunTime4GLException, SystemErrorException, Open4GLException, IOException;

	public String get_login(ctUsuario Obj)
			throws RunTime4GLException, SystemErrorException, Open4GLException, IOException;
	
	@SuppressWarnings("rawtypes")
	public  List<List>     getAllMenu(String cUsuario)
			throws RunTime4GLException, SystemErrorException, Open4GLException, IOException;

}
