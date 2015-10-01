package com.sinergitec.ischool.model.ct;

import java.util.Vector;

public class ctLocalidad {
	
	private String cLocalidad;
	private String cCP;
	private String cCiudad;
	private String cMunicipio;
	private String cEstado;
	private String cNomMunicipio;
	private String cNomEstado;
	private byte[] id;
	
	public String getcLocalidad() {
		return cLocalidad;
	}
	public void setcLocalidad(String cLocalidad) {
		this.cLocalidad = cLocalidad;
	}
	public String getcCP() {
		return cCP;
	}
	public void setcCP(String cCP) {
		this.cCP = cCP;
	}
	public String getcCiudad() {
		return cCiudad;
	}
	public void setcCiudad(String cCiudad) {
		this.cCiudad = cCiudad;
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
	public String getcNomMunicipio() {
		return cNomMunicipio;
	}
	public void setcNomMunicipio(String cNomMunicipio) {
		this.cNomMunicipio = cNomMunicipio;
	}
	public String getcNomEstado() {
		return cNomEstado;
	}
	public void setcNomEstado(String cNomEstado) {
		this.cNomEstado = cNomEstado;
	}
	public byte[] getId() {
		return id;
	}
	public void setId(byte[] id) {
		this.id = id;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getVectorDatos() {
		Vector vector = new Vector();
		vector.add(this.getcLocalidad());
		vector.add(this.getcCP());
		vector.add(this.getcCiudad());
		vector.add(this.getcMunicipio());
		vector.add(this.getcEstado());
		vector.add(this.getcNomMunicipio());
		vector.add(this.getcNomEstado());
		vector.add(this.getId());
		return vector;
	}
	
}
