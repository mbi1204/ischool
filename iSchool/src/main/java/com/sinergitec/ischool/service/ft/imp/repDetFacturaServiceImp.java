package com.sinergitec.ischool.service.ft.imp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.dao.ft.repDetFacturaDao;
import com.sinergitec.ischool.model.ft.ftDetFactura;
import com.sinergitec.ischool.service.ft.repDetFacturaService;

@Service
public class repDetFacturaServiceImp implements repDetFacturaService{
	
	@Autowired
	private repDetFacturaDao dao;

	@Override
	public List<ftDetFactura> list_ftDetFactura(int iFolio, int iSerie) {
		// TODO Auto-generated method stub
		List<ftDetFactura> lista =new ArrayList<ftDetFactura>();
		try {
			lista = dao.list_ftDetFactura(iFolio, iSerie);
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
		
		return lista;
	}

}
