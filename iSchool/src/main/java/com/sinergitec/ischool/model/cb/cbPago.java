package com.sinergitec.ischool.model.cb;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Vector;

public class cbPago {

	private Integer    iIdPago;
	private BigDecimal deMontoPago;
	private Boolean    lEstado;
	private String     cObs;
	private Timestamp  dtFechaPago;
	private Timestamp  dtFechaAplicacion;
	private BigDecimal deMontoXAplicar;
	private Integer    iIdAlumno;
	private String     cReferencia;
	private String     cConcepto;
	private String     cDescripcion;
	private String     cSucursal;
	private String     cCuenta;

	public Integer getiIdPago() {
		return iIdPago;
	}

	public void setiIdPago(Integer iIdPago) {
		this.iIdPago = iIdPago;
	}

	public BigDecimal getDeMontoPago() {
		return deMontoPago;
	}

	public void setDeMontoPago(BigDecimal deMontoPago) {
		this.deMontoPago = deMontoPago;
	}

	public Boolean getlEstado() {
		return lEstado;
	}

	public void setlEstado(Boolean lEstado) {
		this.lEstado = lEstado;
	}

	public String getcObs() {
		return cObs;
	}

	public void setcObs(String cObs) {
		this.cObs = cObs;
	}

	public Timestamp getDtFechaPago() {
		return dtFechaPago;
	}

	public void setDtFechaPago(Timestamp dtFechaPago) {
		this.dtFechaPago = dtFechaPago;
	}

	public Timestamp getDtFechaAplicacion() {
		return dtFechaAplicacion;
	}

	public void setDtFechaAplicacion(Timestamp dtFechaAplicacion) {
		this.dtFechaAplicacion = dtFechaAplicacion;
	}

	public BigDecimal getDeMontoXAplicar() {
		return deMontoXAplicar;
	}

	public void setDeMontoXAplicar(BigDecimal deMontoXAplicar) {
		this.deMontoXAplicar = deMontoXAplicar;
	}

	public Integer getiIdAlumno() {
		return iIdAlumno;
	}

	public void setiIdAlumno(Integer iIdAlumno) {
		this.iIdAlumno = iIdAlumno;
	}


	public String getcReferencia() {
		return cReferencia;
	}

	public void setcReferencia(String cReferencia) {
		this.cReferencia = cReferencia;
	}

	public String getcConcepto() {
		return cConcepto;
	}

	public void setcConcepto(String cConcepto) {
		this.cConcepto = cConcepto;
	}

	public String getcDescripcion() {
		return cDescripcion;
	}

	public void setcDescripcion(String cDescripcion) {
		this.cDescripcion = cDescripcion;
	}

	public String getcSucursal() {
		return cSucursal;
	}

	public void setcSucursal(String cSucursal) {
		this.cSucursal = cSucursal;
	}

	public String getcCuenta() {
		return cCuenta;
	}

	public void setcCuenta(String cCuenta) {
		this.cCuenta = cCuenta;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getVectorDatos() {
		Vector vector = new Vector();		
		vector.add(this.getiIdPago());
		vector.add(this.getDeMontoPago());
		vector.add(this.getlEstado());
		vector.add(this.cObs);
		vector.add(this.getDtFechaPago());
		vector.add(this.getDtFechaAplicacion());
		vector.add(this.getDeMontoXAplicar());
		vector.add(this.getiIdAlumno());
		vector.add(this.getlEstado());
		vector.add(this.getcReferencia());
		vector.add(this.getcConcepto());
		vector.add(this.getcDescripcion());
		vector.add(this.getcSucursal());
		vector.add(this.getcCuenta());		
		
		return vector;
	}

	@Override
	public String toString() {
		return "cbPago [iIdPago=" + iIdPago + ", deMontoPago=" + deMontoPago + ", lEstado=" + lEstado + ", cObs=" + cObs
				+ ", dtFechaPago=" + dtFechaPago + ", dtFechaAplicacion=" + dtFechaAplicacion + ", deMontoXAplicar="
				+ deMontoXAplicar + ", iIdAlumno=" + iIdAlumno + ", cReferencia=" + cReferencia + ", cConcepto="
				+ cConcepto + ", cDescripcion=" + cDescripcion + ", cSucursal=" + cSucursal + ", cCuenta=" + cCuenta
				+ "]";
	}
	
	
	
}
