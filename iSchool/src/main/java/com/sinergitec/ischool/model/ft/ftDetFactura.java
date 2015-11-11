package com.sinergitec.ischool.model.ft;

import java.math.BigDecimal;
import java.util.Vector;

public class ftDetFactura {

	private Integer iFolio;
	private Integer iSerie;
	private Integer iPartida;
	private String cConcepto;
	private BigDecimal deCantidad;
	private BigDecimal deMonto;
	private BigDecimal deSubtotal;
	private String cClave;
	private byte[] Id;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getVectorDatos(){
		Vector vector = new Vector();
		
		vector.add(this.iFolio);
		vector.add(this.iSerie);
		vector.add(this.iPartida);
		vector.add(this.cConcepto);
		vector.add(this.deCantidad);
		vector.add(this.deMonto);
		vector.add(this.deSubtotal);
		vector.add(this.cClave);
		vector.add(this.Id);
		return vector;
	}

	public Integer getiFolio() {
		return iFolio;
	}

	public void setiFolio(Integer iFolio) {
		this.iFolio = iFolio;
	}

	public Integer getiSerie() {
		return iSerie;
	}

	public void setiSerie(Integer iSerie) {
		this.iSerie = iSerie;
	}

	public Integer getiPartida() {
		return iPartida;
	}

	public void setiPartida(Integer iPartida) {
		this.iPartida = iPartida;
	}

	public String getcConcepto() {
		return cConcepto;
	}

	public void setcConcepto(String cConcepto) {
		this.cConcepto = cConcepto;
	}

	public BigDecimal getDeCantidad() {
		return deCantidad;
	}

	public void setDeCantidad(BigDecimal deCantidad) {
		this.deCantidad = deCantidad;
	}

	public BigDecimal getDeMonto() {
		return deMonto;
	}

	public void setDeMonto(BigDecimal deMonto) {
		this.deMonto = deMonto;
	}

	public BigDecimal getDeSubtotal() {
		return deSubtotal;
	}

	public void setDeSubtotal(BigDecimal deSubtotal) {
		this.deSubtotal = deSubtotal;
	}

	public String getcClave() {
		return cClave;
	}

	public void setcClave(String cClave) {
		this.cClave = cClave;
	}

	public byte[] getId() {
		return Id;
	}

	public void setId(byte[] id) {
		Id = id;
	}

}
