package com.sinergitec.ischool.service.ft.imp;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.dao.ft.GeneraCfdiDao;
import com.sinergitec.ischool.model.ft.CFDI;
import com.sinergitec.ischool.service.ft.GeneraCfdiService;
@Service
public class GeneraCfdiServiceImp implements GeneraCfdiService {
	
	@Autowired
	private GeneraCfdiDao dao;

	@Override
	public String generaCfdi(int viSerie, int viFolio) {
		// TODO Auto-generated method stub
		String vcMensaje;
		try {
			vcMensaje = dao.generaCfdi(viSerie, viFolio);
		} catch (RunTime4GLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			vcMensaje = e.getMessage();
		} catch (SystemErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			vcMensaje = e.getMessage();
		} catch (Open4GLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			vcMensaje = e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			vcMensaje = e.getMessage();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			vcMensaje = e.getMessage();
		}
		
		return vcMensaje;
	}

	@Override
	public CFDI getCFDI(int viSerie, int viFolio, String cOpcion) {
		// TODO Auto-generated method stub
		CFDI obj = new CFDI();
		
		try {
			obj = dao.getCFDI(viSerie, viFolio, cOpcion);
		} catch (RunTime4GLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Open4GLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

}
