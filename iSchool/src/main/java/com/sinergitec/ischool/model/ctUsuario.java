package com.sinergitec.ischool.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.Vector;


public class ctUsuario {
	private String cUsuario;
    private String cNombre;
    private String cPassword;
    private Boolean lActivo;
    private Timestamp dtFechaAlta;
    private Integer iIdPuesto;
    private byte[] Id;    
    private ctPuesto puesto;
    
    
    
    
	
	
	public ctPuesto getPuesto() {
		return puesto;
	}
	public void setPuesto(ctPuesto puesto) {
		this.puesto = puesto;
	}
	public String getcUsuario() {
		return cUsuario;
	}
	public void setcUsuario(String cUsuario) {
		this.cUsuario = cUsuario;
	}
	public String getcNombre() {
		return cNombre;
	}
	public void setcNombre(String cNombre) {
		this.cNombre = cNombre;
	}
	public String getcPassword() {
		return cPassword;
	}
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
	public Boolean getlActivo() {
		return lActivo;
	}
	public void setlActivo(Boolean lActivo) {
		this.lActivo = lActivo;
	}
	public Timestamp getDtFechaAlta() {
		return dtFechaAlta;
	}
	public void setDtFechaAlta(Timestamp dtFechaAlta) {
		this.dtFechaAlta = dtFechaAlta;
	}
	public Integer getiIdPuesto() {
		return iIdPuesto;
	}
	public void setiIdPuesto(Integer iIdPuesto) {
		this.iIdPuesto = iIdPuesto;
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
		vector.add(this.getcUsuario());
		vector.add(this.getcNombre());
		vector.add(this.getcPassword());
		vector.add(this.getlActivo());
		vector.add(this.getDtFechaAlta());
		vector.add(this.getiIdPuesto());
		vector.add(this.getId());

		return vector;
	}
	
    
}
