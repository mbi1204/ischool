package com.sinergitec.ischool.service.ct;

import java.io.IOException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.ischool.model.ct.ctLocalidad;

public interface ctLocalidadService {
	
	public List<ctLocalidad> list_ctLocalidades(String cP) throws Open4GLException, IOException;
}
