package com.sinergitec.ischool.model.ct;

import java.util.Vector;

public class ctGrupo {
	
	private int iIdGrupo;
	private String cNomGrupo;
	private int iIdCur;
	private int iIdProfesor;
	private String dtHorario;
	byte[] Id;
	
	public int getiIdGrupo() {
		return iIdGrupo;
	}
	public void setiIdGrupo(int iIdGrupo) {
		this.iIdGrupo = iIdGrupo;
	}
	public String getcNomGrupo() {
		return cNomGrupo;
	}
	public void setcNomGrupo(String cNomGrupo) {
		this.cNomGrupo = cNomGrupo;
	}
	public int getiIdCur() {
		return iIdCur;
	}
	public void setiIdCur(int iIdCur) {
		this.iIdCur = iIdCur;
	}
	public int getiIdProfesor() {
		return iIdProfesor;
	}
	public void setiIdProfesor(int iIdProfesor) {
		this.iIdProfesor = iIdProfesor;
	}
	public String getDtHorario() {
		return dtHorario;
	}
	public void setDtHorario(String dtHorario) {
		this.dtHorario = dtHorario;
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
		
		vector.add(this.getiIdGrupo());
		vector.add(this.getcNomGrupo());
		vector.add(this.getiIdCur());
		vector.add(this.getiIdProfesor());
		vector.add(this.getDtHorario());
		vector.add(this.getId());
		
		return vector;
	}
}
