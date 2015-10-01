package com.sinergitec.ischool.service.imp.ct;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.ischool.dao.ct.ctLocalidadDao;
import com.sinergitec.ischool.model.ct.ctLocalidad;
import com.sinergitec.ischool.service.ct.ctLocalidadService;

@Service
public class ctLocalidadServiceImp implements ctLocalidadService {
	
	@Autowired
	private ctLocalidadDao ctLocalidadDao;
	
	public List<ctLocalidad> list_ctLocalidades(String cP) throws Open4GLException, IOException{
		
		return ctLocalidadDao.list_ctLocalidad(cP);
	}

}
