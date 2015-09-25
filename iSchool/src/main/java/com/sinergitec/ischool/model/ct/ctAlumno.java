package com.sinergitec.ischool.model.ct;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;

public class ctAlumno {

	private Integer iIdAlumno;
	private String cNombre;
	private String cApellido;
	private String dtFechaNac;
	private String cCalle;
	private String cNumExt;
	private String cNumInt;
	private String cColonia;
	private String cCP;
	private String cMunicipio;
	private String cEstado;
	private String cTel;
	private Boolean lEstatus;
	private Timestamp dtFechaIns;
	private String cCorreo;
	private byte[] Id;
	private ctGrupo grupo;	
	private String cGrupo;
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getVectorDatos() {
		Vector vector = new Vector();

		Timestamp conversion = Timestamp.valueOf(this.getDtFechaNac() + " 00:00:00.000000");

		Date date = new java.util.Date();
		this.setDtFechaIns(new Timestamp(date.getTime()));

		vector.add(this.getiIdAlumno());
		vector.add(this.getcNombre());
		vector.add(this.getcApellido());
		vector.add(conversion);
		vector.add(this.getcCalle());
		vector.add(this.getcNumExt());
		vector.add(this.getcNumInt());
		vector.add(this.getcColonia());
		vector.add(this.getcCP());
		vector.add(this.getcMunicipio());
		vector.add(this.getcEstado());
		vector.add(this.getcTel());
		vector.add(this.getlEstatus());
		vector.add(this.getDtFechaIns());
		vector.add(this.getcCorreo());
		vector.add(this.getId());

		return vector;
	}

	public Integer getiIdAlumno() {
		return iIdAlumno;
	}

	public void setiIdAlumno(Integer iIdAlumno) {
		this.iIdAlumno = iIdAlumno;
	}

	public String getcNombre() {
		return cNombre;
	}

	public void setcNombre(String cNombre) {
		this.cNombre = cNombre;
	}

	public String getcApellido() {
		return cApellido;
	}

	public void setcApellido(String cApellido) {
		this.cApellido = cApellido;
	}

	public String getDtFechaNac() {
		return dtFechaNac;
	}

	public void setDtFechaNac(String dtFechaNac) {
		this.dtFechaNac = dtFechaNac;
	}

	public String getcCalle() {
		return cCalle;
	}

	public void setcCalle(String cCalle) {
		this.cCalle = cCalle;
	}

	public String getcNumExt() {
		return cNumExt;
	}

	public void setcNumExt(String cNumExt) {
		this.cNumExt = cNumExt;
	}

	public String getcNumInt() {
		return cNumInt;
	}

	public void setcNumInt(String cNumInt) {
		this.cNumInt = cNumInt;
	}

	public String getcColonia() {
		return cColonia;
	}

	public void setcColonia(String cColonia) {
		this.cColonia = cColonia;
	}

	public String getcCP() {
		return cCP;
	}

	public void setcCP(String cCP) {
		this.cCP = cCP;
	}

	public String getcMunicipio() {
		return cMunicipio;
	}

	public void setcMunicipio(String cMunicipio) {
		this.cMunicipio = cMunicipio;
	}

	public String getcEstado() {
		return cEstado;
	}

	public void setcEstado(String cEstado) {
		this.cEstado = cEstado;
	}

	public String getcTel() {
		return cTel;
	}

	public void setcTel(String cTel) {
		this.cTel = cTel;
	}

	public Boolean getlEstatus() {
		return lEstatus;
	}

	public void setlEstatus(Boolean lEstatus) {
		this.lEstatus = lEstatus;
	}

	public Timestamp getDtFechaIns() {
		return dtFechaIns;
	}

	public void setDtFechaIns(Timestamp dtFechaIns) {
		this.dtFechaIns = dtFechaIns;
	}
	
	



	public String getcCorreo() {
		return cCorreo;
	}

	public void setcCorreo(String cCorreo) {
		this.cCorreo = cCorreo;
	}

	public byte[] getId() {
		return Id;
	}

	public void setId(byte[] id) {
		Id = id;
	}

	public ctGrupo getGrupo() {
		return grupo;
	}

	public void setGrupo(ctGrupo grupo) {
		this.grupo = grupo;
	}

	public String getcGrupo() {
		return cGrupo;
	}

	public void setcGrupo(String cGrupo) {
		this.cGrupo = cGrupo;
	}
	
	
	
}
