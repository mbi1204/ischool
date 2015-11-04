package com.sinergitec.ischool.model.ct;

public class Cobro {

	private String cuenta;
	private String fecha;
	private String hora;
	private String sucursal;
	private String descripcion;
	private String cargoAbono;
	private String importe;
	private String saldo;
	private String referencia;
	private String concepto;
	
	public Cobro(String[] array){
		this.cuenta = array[0];
		this.fecha = array[1];
		this.hora = array[2];
		this.sucursal = array[3];
		this.descripcion = array[4];
		this.cargoAbono = array[5];
		this.importe = array[6];
		this.saldo = array[7];
		this.referencia = array[8];
		this.concepto = array[9];
		
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCargoAbono() {
		return cargoAbono;
	}

	public void setCargoAbono(String cargoAbono) {
		this.cargoAbono = cargoAbono;
	}

	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	@Override
	public String toString() {
		return "Cobro [cuenta=" + cuenta + ", fecha=" + fecha + ", hora=" + hora + ", sucursal=" + sucursal
				+ ", descripcion=" + descripcion + ", cargoAbono=" + cargoAbono + ", importe=" + importe + ", saldo="
				+ saldo + ", referencia=" + referencia + ", concepto=" + concepto + "]";
	}

}
