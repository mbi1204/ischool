package com.sinergitec.ischool.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.model.sg.ctPrograma;

public interface ctProgramaDao {

	public void add_ctPrograma(ctPrograma obj) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException;

	public void update_ctPrograma(ctPrograma obj) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException;

	public List<ctPrograma> list_ctPrograma() throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException, SQLException;

	public ctPrograma get_ctPrograma(int idMenu , int idPrograma) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException, SQLException;

	public void remove_ctPrograma(int idMenu, int idPrograma) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException;

}
