package com.sinergitec.ischool.model.cb;

import java.math.BigDecimal;
import java.util.Vector;

public class cbAlumnoSaldo {

	private int iIdAlumno;
	private String cNombre;
	private String cApellido;
	private String cTel;
	private String cCorreo;
	private BigDecimal deSaldo;
	byte[] Id;

	public int getiIdAlumno() {
		return iIdAlumno;
	}

	public void setiIdAlumno(int iIdAlumno) {
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

	public String getcTel() {
		return cTel;
	}

	public void setcTel(String cTel) {
		this.cTel = cTel;
	}

	public String getcCorreo() {
		return cCorreo;
	}

	public void setcCorreo(String cCorreo) {
		this.cCorreo = cCorreo;
	}

	public BigDecimal getDeSaldo() {
		return deSaldo;
	}

	public void setDeSaldo(BigDecimal deSaldo) {
		this.deSaldo = deSaldo;
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
		vector.add(this.getiIdAlumno());
		vector.add(this.getcNombre());
		vector.add(this.getcApellido());
		vector.add(this.getcTel());
		vector.add(this.getcCorreo());
		vector.add(this.getId());
		return vector;
	}

}
