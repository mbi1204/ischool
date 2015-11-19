package com.sinergitec.ischool.service.cb;

import java.util.GregorianCalendar;
import java.util.List;

import com.sinergitec.ischool.model.cb.cbPago;

public interface cbPagosService {
	public String add_cbPagos(List<cbPago> List_cbPagos);
	
	public List<cbPago> list_cbPagoReporte(String ipcCaso, GregorianCalendar ipdtFechaIni, GregorianCalendar ipdtFechaFin, String ipcReferencia, String ipcConcepto);

}
