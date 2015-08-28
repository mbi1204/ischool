package com.sinergitec.ischool.model.ct;

import java.util.Vector;

public class ctCurso {
	
	private int iIdCur;
	private String cNomCurso;
	private boolean lEstCurso;
	private int iMinCup;
	private int iMaxCup;
	private Double dePrecioCur;
	byte[] id;
	
	public int getiIdCur() {
		return iIdCur;
	}
	public void setiIdCur(int iIdCur) {
		this.iIdCur = iIdCur;
	}
	public String getcNomCurso() {
		return cNomCurso;
	}
	public void setcNomCurso(String cNomCurso) {
		this.cNomCurso = cNomCurso;
	}
	public boolean getlEstCurso() {
		return lEstCurso;
	}
	public void setlEstCurso(boolean lEstCurso) {
		this.lEstCurso = lEstCurso;
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
	public Double getDePrecioCur() {
		return dePrecioCur;
	}
	public void setDePrecioCur(Double dePrecioCur) {
		this.dePrecioCur = dePrecioCur;
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
		
		vector.add(this.getiIdCur());
		vector.add(this.getcNomCurso());
		vector.add(this.getlEstCurso());
		vector.add(this.getiMinCup());
		vector.add(this.getiMaxCup());
		vector.add(this.getDePrecioCur());
		vector.add(this.getId());
		
		return vector;
	}
	
}
