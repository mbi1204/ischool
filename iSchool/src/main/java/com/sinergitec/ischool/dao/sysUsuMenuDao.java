package com.sinergitec.ischool.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.model.sysUsuMenu;

public interface sysUsuMenuDao {

	public void add_sysUsuMenu(sysUsuMenu obj) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException;

	public void update_sysUsuMenu(sysUsuMenu obj) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException;

	public List<sysUsuMenu> list_sysUsuMenu(String cUsuario, Boolean lTodos ) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException, SQLException;

	public sysUsuMenu get_sysUsuMenu(int id) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException, SQLException;

	public void remove_sysUsuMenu(String cUsuario , int iMenu) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException;

}
