package com.sinergitec.ischool.dao.cb;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.ischool.model.cb.cbPago;


public interface cbPagoDao {
	public String add_cbPagos(List<cbPago> List_cbPagos) throws Open4GLException, IOException;
	
	public List<cbPago> list_cbPagoReporte(String ipcCaso, GregorianCalendar ipdtFechaIni, GregorianCalendar ipdtFechaFin, String ipcReferencia, String ipcConcepto) throws Open4GLException, IOException;

}
