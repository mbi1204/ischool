package com.sinergitec.ischool.model.sg;

import java.util.Vector;

public class ctPrograma {

	private Integer iIdPrograma;
	private Integer iIdMenu;
	private String cPrograma;
	private Boolean lActivo;
	private String cNombre;
	private byte[] Id;
	private ctMenu menu;
	
	
	public ctPrograma() {
		 iIdPrograma = 0 ;
		 iIdMenu     = 0;
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getVectorDatos() {
		Vector vector = new Vector();
		vector.add(this.getiIdPrograma());
		vector.add(this.getiIdMenu());
		vector.add(this.getcPrograma());
		vector.add(this.getlActivo());
		vector.add(this.getcNombre());
		vector.add(this.getId());

		return vector;
	}

	public ctMenu getMenu() {
		return menu;
	}

	public void setMenu(ctMenu menu) {
		this.menu = menu;
	}

	public Integer getiIdPrograma() {
		return iIdPrograma;
	}

	public void setiIdPrograma(Integer iIdPrograma) {
		this.iIdPrograma = iIdPrograma;
	}

	public Integer getiIdMenu() {
		return iIdMenu;
	}

	public void setiIdMenu(Integer iIdMenu) {
		this.iIdMenu = iIdMenu;
	}

	public String getcPrograma() {
		return cPrograma;
	}

	public void setcPrograma(String cPrograma) {
		this.cPrograma = cPrograma;
	}

	public Boolean getlActivo() {
		return lActivo;
	}

	public void setlActivo(Boolean lActivo) {
		this.lActivo = lActivo;
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
