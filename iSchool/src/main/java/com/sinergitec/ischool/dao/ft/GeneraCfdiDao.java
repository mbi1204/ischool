package com.sinergitec.ischool.dao.ft;

import java.io.IOException;
import java.sql.SQLException;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.model.ft.CFDI;

public interface GeneraCfdiDao {
	public String generaCfdi(int viSerie , int viFolio )throws RunTime4GLException, SystemErrorException, Open4GLException, IOException, SQLException;
	public CFDI getCFDI (int viSerie , int viFolio, String cOpcion)throws RunTime4GLException, SystemErrorException, Open4GLException, IOException, SQLException; 
	
	

	

}
