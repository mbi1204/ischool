package com.sinergitec.ischool.model.ct;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;

public class ctProfesor {

	private Integer iIdProfesor;
	String cNombre;
	String cApellido;
	String cCalle;
	String cNumExt;
	String cNumInt;
	String cColonia;
	String cCP;
	String cMunicipio;
	String cEdo;
	String cTelefono;
	Boolean lEstatus;
	String dtContrato;
	String dtFechaNac;
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

	public String getcNumExt() {
		return cNumExt;
	}

	public void setiNumExt(String cNumExt) {
		this.cNumExt = cNumExt;
	}

	public String getcNumInt() {
		return cNumInt;
	}

	public void setiNumInt(String cNumInt) {
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

	public String getDtContrato() {
		return dtContrato;
	}

	public void setDtContrato(String dtContrato) {
		this.dtContrato = dtContrato;
	}

	public String getDtFechaNac() {
		return dtFechaNac;
	}

	public void setDtFechaNac(String dtFechaNac) {
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

		
		
		Timestamp dtFechaNac = Timestamp.valueOf(this.getDtFechaNac()+" 00:00:00.000000");
		Timestamp dtFechaContrato = Timestamp.valueOf(this.getDtContrato()+" 00:00:00.000000");
		//this.setDtContrato(dtFechaContrato);
		//this.setDtFechaNac(dtFechaNac);
		

		
		
	
		
		vector.add(this.getiIdProfesor());
		vector.add(this.getcNombre());
		vector.add(this.getcApellido());
		vector.add(this.getcCalle());
		vector.add(this.getcNumExt());
		vector.add(this.getcNumInt());
		vector.add(this.getcColonia());
		vector.add(this.getcCP());
		vector.add(this.getcMunicipio());
		vector.add(this.getcEdo());
		vector.add(this.getcTelefono());
		vector.add(this.getlEstatus());
		vector.add(dtFechaContrato);
		vector.add(dtFechaNac);
		vector.add(this.getId());

		return vector;
	}
}
