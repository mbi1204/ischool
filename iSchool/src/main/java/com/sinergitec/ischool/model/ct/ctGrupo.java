package com.sinergitec.ischool.model.ct;

import java.util.Vector;

public class ctGrupo {

	private Integer iIdGrupo;
	private String cNombre;
	private Integer iIdCurso;
	private Integer iIdProfesor;
	private String cDias;
	private String cHorario;
	private Boolean lHabilitado;
	private byte[] Id;
	private ctProfesor profesor;
	private ctCurso curso;
	private String cDescripcion;

	public ctGrupo() {
		this.iIdGrupo = 0;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getVectorDatos() {
		Vector vector = new Vector();

		vector.add(this.getiIdGrupo());
		vector.add(this.getcNombre());
		vector.add(this.getiIdCurso());
		vector.add(this.getiIdProfesor());
		vector.add(this.getcDias());
		vector.add(this.getcHorario());
		vector.add(this.getlHabilitado());
		vector.add(this.getId());
		return vector;
	}
	
	
	

	public String getcDescripcion() {
		return ("Curso:" + cNombre  + " Grupo: "+  curso.getcNombre() + " Horario: " +  cDias  + " "+  cHorario + " Precio: $" + curso.getDePrecio()   );
	}

	public void setcDescripcion(String cDescripcion) {
		this.cDescripcion = cDescripcion;
	}

	public Integer getiIdGrupo() {
		return iIdGrupo;
	}

	public void setiIdGrupo(Integer iIdGrupo) {
		this.iIdGrupo = iIdGrupo;
	}

	public String getcNombre() {
		return cNombre;
	}

	public void setcNombre(String cNombre) {
		this.cNombre = cNombre;
	}

	public Integer getiIdCurso() {
		return iIdCurso;
	}

	public void setiIdCurso(Integer iIdCurso) {
		this.iIdCurso = iIdCurso;
	}

	public Integer getiIdProfesor() {
		return iIdProfesor;
	}

	public void setiIdProfesor(Integer iIdProfesor) {
		this.iIdProfesor = iIdProfesor;
	}

	public String getcDias() {
		return cDias;
	}

	public void setcDias(String cDias) {
		this.cDias = cDias;
	}

	public String getcHorario() {
		return cHorario;
	}

	public void setcHorario(String cHorario) {
		this.cHorario = cHorario;
	}

	public Boolean getlHabilitado() {
		return lHabilitado;
	}

	public void setlHabilitado(Boolean lHabilitado) {
		this.lHabilitado = lHabilitado;
	}

	public byte[] getId() {
		return Id;
	}

	public void setId(byte[] id) {
		Id = id;
	}

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

}
