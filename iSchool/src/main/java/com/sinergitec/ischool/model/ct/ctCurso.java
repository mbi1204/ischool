package com.sinergitec.ischool.model.ct;

import java.math.BigDecimal;
import java.util.Vector;

public class ctCurso {
	
	private Integer iIdCurso;
	private String cNombre;
	private Boolean lEstatus;
	private Integer iMinCup;
	private Integer iMaxCup;
	private BigDecimal dePrecio;
	byte[] id;
	
	public ctCurso(){
		iIdCurso = 0 ;
	}
	
	public Integer getiIdCurso() {
		return iIdCurso;
	}
	public void setiIdCurso(Integer iIdCurso) {
		this.iIdCurso = iIdCurso;
	}
	public String getcNombre() {
		return cNombre;
	}
	public void setcNombre(String cNombre) {
		this.cNombre = cNombre;
	}
	public Boolean getlEstatus() {
		return lEstatus;
	}
	public void setlEstatus(Boolean lEstatus) {
		this.lEstatus = lEstatus;
	}
	public Integer getiMinCup() {
		return iMinCup;
	}
	public void setiMinCup(Integer iMinCup) {
		this.iMinCup = iMinCup;
	}
	public Integer getiMaxCup() {
		return iMaxCup;
	}
	public void setiMaxCup(Integer iMaxCup) {
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
