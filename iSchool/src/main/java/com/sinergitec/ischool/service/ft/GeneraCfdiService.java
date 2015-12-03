package com.sinergitec.ischool.service.ft;

import com.sinergitec.ischool.model.ft.CFDI;

public interface GeneraCfdiService {
	public String generaCfdi(int viSerie , int viFolio );
	public CFDI getCFDI (int viSerie , int viFolio, String cOpcion);

}
