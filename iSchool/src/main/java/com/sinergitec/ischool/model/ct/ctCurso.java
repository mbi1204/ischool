package com.sinergitec.ischool.model.ct;

import java.math.BigDecimal;
import java.util.Vector;

public class ctCurso {
	
	private int iIdCurso;
	private String cNombre;
	private boolean lEstatus;
	private int iMinCup;
	private int iMaxCup;
	private BigDecimal dePrecio;
	byte[] id;
	
	
	public int getiIdCurso() {
		return iIdCurso;
	}
	public void setiIdCurso(int iIdCurso) {
		this.iIdCurso = iIdCurso;
	}
	public String getcNombre() {
		return cNombre;
	}
	public void setcNombre(String cNombre) {
		this.cNombre = cNombre;
	}
	public boolean getlEstatus() {
		return lEstatus;
	}
	public void setlEstatus(boolean lEstatus) {
		this.lEstatus = lEstatus;
	}
	public int getiMinCup() {
		return iMinCup;
	}
	public void setiMinCup(int iMinCup) {
		this.iMinCup = iMinCup;
	}
	public int getiMaxCup() {
		return iMaxCup;
	}
	public void setiMaxCup(int iMaxCup) {
		this.iMaxCup = iMaxCup;
	}
	public BigDecimal getDePrecio() {
		return dePrecio;
	}
	public void setDePrecio(BigDecimal dePrecio) {
		this.dePrecio = dePrecio;
	}
	public byte[] getId() {
		return id;
	}
	public void setId(byte[] id) {
		this.id = id;
	}



	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getVectorDatos(){
		Vector vector = new Vector();
		/*Timestamp conversion = Timestamp.valueOf(this.getDtFechaNac()+" 00:00:00.000000");
		Date date= new java.util.Date();
		this.setDtFechaIns(new Timestamp(date.getTime()));*/
		
		vector.add(this.getiIdCurso());
		vector.add(this.getcNombre());
		vector.add(this.getlEstatus());
		vector.add(this.getiMinCup());
		vector.add(this.getiMaxCup());
		vector.add(this.getDePrecio());
		vector.add(this.getId());
		
		return vector;
	}
	
}
