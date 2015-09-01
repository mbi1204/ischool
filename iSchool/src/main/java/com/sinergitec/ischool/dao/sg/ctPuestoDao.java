package com.sinergitec.ischool.dao.sg;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.model.sg.ctPuesto;

public interface ctPuestoDao {

	public void add_ctPuesto(ctPuesto obj) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException;

	public void update_ctPuesto(ctPuesto obj) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException;

	public List<ctPuesto> list_ctPuesto() throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException, SQLException;

	public ctPuesto get_ctPuesto(int id) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException, SQLException;

	public void remove_ctPuesto(int id) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException;

}
