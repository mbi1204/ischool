package com.sinergitec.ischool.dao.ct;

import java.io.IOException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.ischool.model.ct.ctLocalidad;

public interface ctLocalidadDao {
	
	public List<ctLocalidad> list_ctLocalidad(String cCP) throws Open4GLException, IOException;
	
}
