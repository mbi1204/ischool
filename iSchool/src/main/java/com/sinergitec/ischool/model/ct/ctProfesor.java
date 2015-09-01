package com.sinergitec.ischool.model.ct;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;

public class ctProfesor {

	private Integer iIdProfesor;
	String cNombre;
	String cApellido;
	String cCalle;
	String iNumExt;
	String iNumInt;
	String cColonia;
	String cCP;
	String cMunicipio;
	String cEdo;
	String cTelefono;
	Boolean lEstatus;
	Timestamp dtContrato;
	Timestamp dtFechaNac;
	byte[] Id;

	public Integer getiIdProfesor() {
		return iIdProfesor;
	}

	public void setiIdProfesor(Integer iIdProfesor) {
		this.iIdProfesor = iIdProfesor;
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

	public String getcCalle() {
		return cCalle;
	}

	public void setcCalle(String cCalle) {
		this.cCalle = cCalle;
	}

	public String getiNumExt() {
		return iNumExt;
	}

	public void setiNumExt(String iNumExt) {
		this.iNumExt = iNumExt;
	}

	public String getiNumInt() {
		return iNumInt;
	}

	public void setiNumInt(String iNumInt) {
		this.iNumInt = iNumInt;
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

	public String getcEdo() {
		return cEdo;
	}

	public void setcEdo(String cEdo) {
		this.cEdo = cEdo;
	}

	public String getcTelefono() {
		return cTelefono;
	}

	public void setcTelefono(String cTelefono) {
		this.cTelefono = cTelefono;
	}

	public Boolean getlEstatus() {
		return lEstatus;
	}

	public void setlEstatus(Boolean lEstatus) {
		this.lEstatus = lEstatus;
	}

	public Timestamp getDtContrato() {
		return dtContrato;
	}

	public void setDtContrato(Timestamp dtContrato) {
		this.dtContrato = dtContrato;
	}

	public Timestamp getDtFechaNac() {
		return dtFechaNac;
	}

	public void setDtFechaNac(Timestamp dtFechaNac) {
		this.dtFechaNac = dtFechaNac;
	}

	public byte[] getId() {
		return Id;
	}

	public void setId(byte[] id) {
		Id = id;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getVectorDatos() {
		Vector vector = new Vector();

		Date date = new java.util.Date();

		this.setDtFechaNac(new Timestamp(date.getTime()));
		this.setDtContrato(new Timestamp(date.getTime()));

		vector.add(this.getiIdProfesor());
		vector.add(this.getcNombre());
		vector.add(this.getcApellido());
		vector.add(this.getcCalle());
		vector.add(this.getiNumExt());
		vector.add(this.getiNumInt());
		vector.add(this.getcColonia());
		vector.add(this.getcCP());
		vector.add(this.getcMunicipio());
		vector.add(this.getcEdo());
		vector.add(this.getcTelefono());
		vector.add(this.getlEstatus());
		vector.add(this.getDtFechaNac());
		vector.add(this.getDtContrato());
		vector.add(this.getId());

		return vector;
	}
}
