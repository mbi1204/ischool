package com.sinergitec.ischool.model;

import java.util.Vector;

public class cbDetallePago {
	private int iIdPago;
	private String cObs;
	private String cClavePago;
	private String cRefencia;
	private int iIdFormaPago;
	private boolean lEstatus;
	byte[] Id;
	
	public int getiIdPago() {
		return iIdPago;
	}
	public void setiIdPago(int iIdPago) {
		this.iIdPago = iIdPago;
	}
	public String getcObs() {
		return cObs;
	}
	public void setcObs(String cObs) {
		this.cObs = cObs;
	}
	public String getcClavePago() {
		return cClavePago;
	}
	public void setcClavePago(String cClavePago) {
		this.cClavePago = cClavePago;
	}
	public String getcRefencia() {
		return cRefencia;
	}
	public void setcRefencia(String cRefencia) {
		this.cRefencia = cRefencia;
	}
	public int getiIdFormaPago() {
		return iIdFormaPago;
	}
	public void setiIdFormaPago(int iIdFormaPago) {
		this.iIdFormaPago = iIdFormaPago;
	}
	public boolean getlEstatus() {
		return lEstatus;
	}
	public void setlEstatus(boolean lEstatus) {
		this.lEstatus = lEstatus;
	}
	public byte[] getId() {
		return Id;
	}
	public void setId(byte[] id) {
		Id = id;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getVectorDatos(){
		Vector vector = new Vector();
		/*Timestamp conversion = Timestamp.valueOf(this.getDtFechaNac()+" 00:00:00.000000");
		Date date= new java.util.Date();
		this.setDtFechaIns(new Timestamp(date.getTime()));*/
		
		vector.add(this.getiIdPago());
		vector.add(this.getcObs());
		vector.add(this.getcClavePago());
		vector.add(this.getcRefencia());
		vector.add(this.getiIdFormaPago());
		vector.add(this.getlEstatus());
		vector.add(this.getId());		

		return vector;
	}
}
