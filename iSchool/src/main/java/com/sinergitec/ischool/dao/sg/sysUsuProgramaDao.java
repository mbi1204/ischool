package com.sinergitec.ischool.dao.sg;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.model.sg.sysUsuPrograma;

public interface sysUsuProgramaDao {

	public void add_sysUsuPrograma(sysUsuPrograma obj) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException;

	public void update_sysUsuPrograma(sysUsuPrograma obj) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException;

	public List<sysUsuPrograma> list_sysUsuPrograma(String cUsuario, int iMenu , Boolean lTodos ) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException, SQLException;

	public sysUsuPrograma get_sysUsuPrograma(int id) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException, SQLException;

	public void remove_sysUsuPrograma(String cUsuario , int iMenu ,int Programa) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException;

}
