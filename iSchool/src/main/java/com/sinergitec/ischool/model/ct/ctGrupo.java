package com.sinergitec.ischool.model.ct;

import java.sql.Timestamp;
import java.util.Vector;

public class ctGrupo {
	
	private int iIdGrupo;
	private String cNombre;
	private int iIdCurso;
	private int iIdProfesor;
	private String dtHorario;
	byte[] Id;
	ctProfesor profesor;
	ctCurso curso;
	

	public ctProfesor getProfesor() {
		return profesor;
	}
	public void setProfesor(ctProfesor profesor) {
		this.profesor = profesor;
	}
	public ctCurso getCurso() {
		return curso;
	}
	public void setCurso(ctCurso curso) {
		this.curso = curso;
	}
	public int getiIdGrupo() {
		return iIdGrupo;
	}
	public void setiIdGrupo(int iIdGrupo) {
		this.iIdGrupo = iIdGrupo;
	}
	public String getcNombre() {
		return cNombre;
	}
	public void setcNombre(String cNombre) {
		this.cNombre = cNombre;
	}
	public int getiIdCurso() {
		return iIdCurso;
	}
	public void setiIdCurso(int iIdCurso) {
		this.iIdCurso = iIdCurso;
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
		Timestamp conversion = Timestamp.valueOf(this.getDtHorario()+" 00:00:00.000000");
		/*Date date= new java.util.Date();
		this.setDtFechaIns(new Timestamp(date.getTime()));*/
		
		vector.add(this.getiIdGrupo());
		vector.add(this.getcNombre());
		vector.add(this.getiIdCurso());
		vector.add(this.getiIdProfesor());
		vector.add(conversion);
		vector.add(this.getId());
		
		return vector;
	}
}
