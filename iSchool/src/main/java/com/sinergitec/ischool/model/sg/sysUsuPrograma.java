package com.sinergitec.ischool.model.sg;

import java.util.Vector;

public class sysUsuPrograma {

	private String cUsuario;
	private Integer iIdMenu;
	private Integer iIdPrograma;
	private Boolean lActivo;
	private String cObs;
	private String cPrograma;
	private String cNombre;
	byte[] Id;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getVectorDatos() {
		Vector vector = new Vector();
		vector.add(this.getcUsuario());
		vector.add(this.getiIdMenu());
		vector.add(this.getiIdPrograma());
		vector.add(this.getlActivo());
		vector.add(this.getcObs());
		vector.add(this.getcPrograma());
		vector.add(this.getcNombre());		
		vector.add(this.getId());

		return vector;
	}

	public String getcUsuario() {
		return cUsuario;
	}

	public void setcUsuario(String cUsuario) {
		this.cUsuario = cUsuario;
	}

	public Integer getiIdMenu() {
		return iIdMenu;
	}

	public void setiIdMenu(Integer iIdMenu) {
		this.iIdMenu = iIdMenu;
	}

	public Integer getiIdPrograma() {
		return iIdPrograma;
	}

	public void setiIdPrograma(Integer iIdPrograma) {
		this.iIdPrograma = iIdPrograma;
	}

	public Boolean getlActivo() {
		return lActivo;
	}

	public void setlActivo(Boolean lActivo) {
		this.lActivo = lActivo;
	}

	public String getcObs() {
		return cObs;
	}

	public void setcObs(String cObs) {
		this.cObs = cObs;
	}

	public String getcPrograma() {
		return cPrograma;
	}

	public void setcPrograma(String cPrograma) {
		this.cPrograma = cPrograma;
	}

	public String getcNombre() {
		return cNombre;
	}

	public void setcNombre(String cNombre) {
		this.cNombre = cNombre;
	}

	public byte[] getId() {
		return Id;
	}

	public void setId(byte[] id) {
		Id = id;
	}

}
