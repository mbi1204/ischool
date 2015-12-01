package com.sinergitec.ischool.service.imp.cb;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
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

	@Override
	public List<cbPago> list_cbPagoReporte(String ipcCaso, GregorianCalendar ipdtFechaIni,
			GregorianCalendar ipdtFechaFin, String ipcReferencia, String ipcConcepto) {
		// TODO Auto-generated method stub
		List<cbPago> Lista =new ArrayList<cbPago>();
		try {
			Lista = Dao.list_cbPagoReporte(ipcCaso, ipdtFechaIni, ipdtFechaFin, ipcReferencia, ipcConcepto);
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
		}		
		
		return Lista;
	}

}
