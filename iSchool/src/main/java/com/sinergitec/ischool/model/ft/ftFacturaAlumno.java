package com.sinergitec.ischool.model.ft;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Vector;

public class ftFacturaAlumno {

	private Integer iIdAlumno;
	private String cNombre;
	private String cApellido;
	private String cSerie;
	private Integer iFolio;
	private Timestamp dtFecha;
	private BigDecimal deDescPorc;
	private BigDecimal deDescMonto;
	private BigDecimal deSubtotal;
	private BigDecimal deIVA;
	private BigDecimal deTotal;
	private byte[] Id;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getVectorDatos(){
		Vector vector = new Vector();		
		
		vector.add(this.getiFolio());
		vector.add(this.getDtFecha());	
		vector.add(this.getDeSubtotal());
		vector.add(this.getDeIVA());
		vector.add(this.getDeTotal());
		vector.add(this.getDeDescPorc());		
		vector.add(this.getDeDescMonto());		
		vector.add(this.getiIdAlumno());
		vector.add(this.getcNombre());
		vector.add(this.getcApellido());
		vector.add(this.getcSerie());
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

	public String getcSerie() {
		return cSerie;
	}

	public void setcSerie(String cSerie) {
		this.cSerie = cSerie;
	}

	public Integer getiFolio() {
		return iFolio;
	}

	public void setiFolio(Integer iFolio) {
		this.iFolio = iFolio;
	}

	public Timestamp getDtFecha() {
		return dtFecha;
	}

	public void setDtFecha(Timestamp dtFecha) {
		this.dtFecha = dtFecha;
	}

	public BigDecimal getDeDescPorc() {
		return deDescPorc;
	}

	public void setDeDescPorc(BigDecimal deDescPorc) {
		this.deDescPorc = deDescPorc;
	}

	public BigDecimal getDeDescMonto() {
		return deDescMonto;
	}

	public void setDeDescMonto(BigDecimal deDescMonto) {
		this.deDescMonto = deDescMonto;
	}	

	public void setDeSubtotal(BigDecimal deSubtotal) {
		this.deSubtotal = deSubtotal;
	}

	public BigDecimal getDeIVA() {
		return deIVA;
	}

	public void setDeIVA(BigDecimal deIVA) {
		this.deIVA = deIVA;
	}

	public BigDecimal getDeTotal() {
		return deTotal;
	}

	public void setDeTotal(BigDecimal deTotal) {
		this.deTotal = deTotal;
	}

	public byte[] getId() {
		return Id;
	}

	public void setId(byte[] id) {
		Id = id;
	}

	public BigDecimal getDeSubtotal() {
		return deSubtotal;
	}

}
