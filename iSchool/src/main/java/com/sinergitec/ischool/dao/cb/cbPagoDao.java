package com.sinergitec.ischool.dao.cb;

import java.io.IOException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.sinergitec.ischool.model.cb.cbPago;


public interface cbPagoDao {
	public String add_cbPagos(List<cbPago> List_cbPagos) throws Open4GLException, IOException;

}
