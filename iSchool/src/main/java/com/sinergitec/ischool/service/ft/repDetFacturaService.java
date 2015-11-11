package com.sinergitec.ischool.service.ft;

import java.util.List;
import com.sinergitec.ischool.model.ft.ftDetFactura;

public interface repDetFacturaService {
	
	public List<ftDetFactura> list_ftDetFactura(int iFolio, int iSerie);

}
