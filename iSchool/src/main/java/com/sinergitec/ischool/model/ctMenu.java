package com.sinergitec.ischool.model;

import java.util.Arrays;
import java.util.Vector;

public class ctMenu {
	private Integer iIdMenu;
	private String cMenu;
	private Boolean lActivo;
	private byte[] Id;
	
	public ctMenu(){
		iIdMenu = 0 ;
		
		
	}
	public Integer getiIdMenu() {
		return iIdMenu;
	}
	public void setiIdMenu(Integer iIdMenu) {
		this.iIdMenu = iIdMenu;
	}
	public String getcMenu() {
		return cMenu;
	}
	public void setcMenu(String cMenu) {
		this.cMenu = cMenu;
	}
	public Boolean getlActivo() {
		return lActivo;
	}
	public void setlActivo(Boolean lActivo) {
		this.lActivo = lActivo;
	}
	public byte[] getId() {
		return Id;
	}
	public void setId(byte[] id) {
		Id = id;
	}
	@Override
	public String toString() {
		return "ctMenu [iIdMenu=" + iIdMenu + ", cMenu=" + cMenu + ", lActivo="
				+ lActivo + ", Id=" + Arrays.toString(Id) + "]";
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getVectorDatos() {
		Vector vector = new Vector();
		vector.add(this.getiIdMenu());
		vector.add(this.getcMenu());
		vector.add(this.getlActivo());
		vector.add(this.getId());

		return vector;
	}
	
	

}
