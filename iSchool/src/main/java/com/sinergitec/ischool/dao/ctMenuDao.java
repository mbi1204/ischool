package com.sinergitec.ischool.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.model.ctMenu;

public interface ctMenuDao {

	public void add_ctMenu(ctMenu obj) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException;

	public void update_ctMenu(ctMenu obj) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException;

	public List<ctMenu> list_ctMenu() throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException, SQLException;

	public ctMenu get_ctMenu(int id) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException, SQLException;

	public void remove_ctMenu(int id) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException;

}
