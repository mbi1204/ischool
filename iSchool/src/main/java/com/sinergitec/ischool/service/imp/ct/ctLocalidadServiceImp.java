package com.sinergitec.ischool.service.imp.ct;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
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
	
	public List<ctLocalidad> list_ctLocalidades(String cCP) {
		
		List<ctLocalidad> lista = new ArrayList<ctLocalidad>(); 
		
		try {
			lista = ctLocalidadDao.list_ctLocalidad(cCP);
		} catch (Open4GLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

}
