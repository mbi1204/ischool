package com.sinergitec.ischool.model.sg;

import java.util.Arrays;
import java.util.Vector;

public class sysUsuMenu {

    private String cUsuario;
    private Integer iIdMenu;
    private Boolean lActivo;
    private String cObs;
    private String cMenu;    
    private  byte[] Id;
    
    
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
	public byte[] getId() {
		return Id;
	}
	public void setId(byte[] id) {
		Id = id;
	}
	
	
	
	
	public String getcMenu() {
		return cMenu;
	}
	public void setcMenu(String cMenu) {
		this.cMenu = cMenu;
	}
	@Override
	public String toString() {
		return "sysUsuMenu [cUsuario=" + cUsuario + ", iIdMenu=" + iIdMenu
				+ ", lActivo=" + lActivo + ", cObs=" + cObs + ", Id="
				+ Arrays.toString(Id) + "]";
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getVectorDatos() {
		Vector vector = new Vector();
		vector.add(this.getcUsuario());
		vector.add(this.getiIdMenu());
		vector.add(this.getlActivo());
		vector.add(this.getcObs());
		vector.add(this.getcMenu());
		vector.add(this.getId());

		return vector;
	}
	
    
	
    
    
	

}
