package com.sinergitec.ischool.model.cb;

import java.util.Vector;

public class cbPago {
	private int iIdPago;
	private String dtFrechaPago;
	private Double deMontoPago;
	private int iIdAlumno;
	private boolean lEstado;
	private String cObs;
	byte[] Id;
	
	public int getiIdPago() {
		return iIdPago;
	}
	public void setiIdPago(int iIdPago) {
		this.iIdPago = iIdPago;
	}
	public String getDtFrechaPago() {
		return dtFrechaPago;
	}
	public void setDtFrechaPago(String dtFrechaPago) {
		this.dtFrechaPago = dtFrechaPago;
	}
	public Double getDeMontoPago() {
		return deMontoPago;
	}
	public void setDeMontoPago(Double deMontoPago) {
		this.deMontoPago = deMontoPago;
	}
	public int getiIdAlumno() {
		return iIdAlumno;
	}
	public void setiIdAlumno(int iIdAlumno) {
		this.iIdAlumno = iIdAlumno;
	}
	public boolean getlEstado() {
		return lEstado;
	}
	public void setlEstado(boolean lEstado) {
		this.lEstado = lEstado;
	}
	public String getcObs() {
		return cObs;
	}
	public void setcObs(String cObs) {
		this.cObs = cObs;
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
		vector.add(this.getDtFrechaPago());
		vector.add(this.getDeMontoPago());
		vector.add(this.getiIdAlumno());
		vector.add(this.getlEstado());
		vector.add(this.getcObs());
		vector.add(this.getId());
		
		return vector;
	}
}
