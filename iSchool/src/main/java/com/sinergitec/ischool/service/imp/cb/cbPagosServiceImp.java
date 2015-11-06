package com.sinergitec.ischool.service.imp.cb;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.ischool.dao.cb.cbPagoDao;
import com.sinergitec.ischool.model.cb.cbPago;
import com.sinergitec.ischool.service.cb.cbPagosService;
@Service
public class cbPagosServiceImp implements cbPagosService {
	@Autowired
	private cbPagoDao Dao;

	@Override
	public String add_cbPagos(List<cbPago> List_cbPagos) {
		// TODO Auto-generated method stub
		String vcMensaje = null;
		
		try {
			vcMensaje = Dao.add_cbPagos(List_cbPagos);
		} catch (Open4GLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			vcMensaje =e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			vcMensaje =e.getMessage();
		}
		
		return vcMensaje;
	}

}
