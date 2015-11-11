package com.sinergitec.ischool.dao.ft;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.model.ft.ftDetFactura;

public interface repDetFacturaDao {
	
	public List<ftDetFactura> list_ftDetFactura(int iFolio, int iSerie)
			throws RunTime4GLException, SystemErrorException, Open4GLException, IOException, SQLException;

}
