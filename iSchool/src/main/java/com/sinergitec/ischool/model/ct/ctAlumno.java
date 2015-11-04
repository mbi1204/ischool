package com.sinergitec.ischool.model.ct;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;

public class ctAlumno {

	private Integer iIdAlumno;
	private String cNombre;
	private String cApellido;
	private String cEdad;
	private String cCalle;
	private String cNumExt;
	private String cNumInt;
	private String cColonia;
	private String cCP;
	private String cMunicipio;
	private String cEstado;
	private String cTel;
	private Boolean lEstatus;
	private Timestamp dtFechaIns;
	private String cCorreo;
	private byte[] Id;
	private ctGrupo grupo;
	private String cGrupo;
	private String cNombreFiscal;
	private String cCalleFiscal;
	private String cNumeroFiscal;
	private String cColoniaFiscal;
	private String cMunicipioFiscal;
	private String cCPFiscal;
	private String cCiudadFiscal;
	private String cEstadoFiscal;
	private String cRfcFiscal;
	private String cTelEmergencia;
	private String cGenero;
	private Boolean lSeguro;
	private Boolean lFactura;
	private Boolean lAlergia;
	private String cAlergia;
	private Boolean lMedicamento;
	private String cMedicamento;
	private Boolean lLesion;
	private String cLesion;
	private Boolean lTratamiento;
	private String cTratamiento;
	private BigDecimal deDescuento;
	private String cMotivoDesc;
	private String cReferencia;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getVectorDatos() {
		Vector vector = new Vector();		
		
		Date date = new java.util.Date();
		this.setDtFechaIns(new Timestamp(date.getTime()));

		vector.add(this.getiIdAlumno());
		vector.add(this.getcNombre());
		vector.add(this.getcApellido());		
		vector.add(this.getcCalle());
		vector.add(this.getcNumExt());
		vector.add(this.getcNumInt());
		vector.add(this.getcColonia());
		vector.add(this.getcCP());
		vector.add(this.getcMunicipio());
		vector.add(this.getcEstado());
		vector.add(this.getcTel());
		vector.add(this.getlEstatus());
		vector.add(this.getDtFechaIns());
		vector.add(this.getcCorreo());
		vector.add(this.getcNombreFiscal());
		vector.add(this.getcCalleFiscal());
		vector.add(this.getcNumeroFiscal());
		vector.add(this.getcColoniaFiscal());
		vector.add(this.getcMunicipioFiscal());
		vector.add(this.getcCPFiscal());
		vector.add(this.getcCiudadFiscal());
		vector.add(this.getcEstadoFiscal());
		vector.add(this.getcRfcFiscal());
		vector.add(this.getcEdad());		
		vector.add(this.getcTelEmergencia());
		vector.add(this.getlSeguro());
		vector.add(this.getlFactura());
		vector.add(this.getcGenero());
		vector.add(this.getlAlergia());
		vector.add(this.getcAlergia());
		vector.add(this.getlMedicamento());
		vector.add(this.getcMedicamento());
		vector.add(this.getlLesion());
		vector.add(this.getcLesion());
		vector.add(this.getlTratamiento());
		vector.add(this.getcTratamiento());	
		vector.add(this.getDeDescuento());
		vector.add(this.getcMotivoDesc());
		vector.add(this.getcReferencia());
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

	public String getcCalle() {
		return cCalle;
	}

	public void setcCalle(String cCalle) {
		this.cCalle = cCalle;
	}

	public String getcNumExt() {
		return cNumExt;
	}

	public void setcNumExt(String cNumExt) {
		this.cNumExt = cNumExt;
	}

	public String getcNumInt() {
		return cNumInt;
	}

	public void setcNumInt(String cNumInt) {
		this.cNumInt = cNumInt;
	}

	public String getcColonia() {
		return cColonia;
	}

	public void setcColonia(String cColonia) {
		this.cColonia = cColonia;
	}

	public String getcCP() {
		return cCP;
	}

	public void setcCP(String cCP) {
		this.cCP = cCP;
	}

	public String getcMunicipio() {
		return cMunicipio;
	}

	public void setcMunicipio(String cMunicipio) {
		this.cMunicipio = cMunicipio;
	}

	public String getcEstado() {
		return cEstado;
	}

	public void setcEstado(String cEstado) {
		this.cEstado = cEstado;
	}

	public String getcTel() {
		return cTel;
	}

	public void setcTel(String cTel) {
		this.cTel = cTel;
	}

	public Boolean getlEstatus() {
		return lEstatus;
	}

	public void setlEstatus(Boolean lEstatus) {
		this.lEstatus = lEstatus;
	}

	public String getcCorreo() {
		return cCorreo;
	}

	public void setcCorreo(String cCorreo) {
		this.cCorreo = cCorreo;
	}

	public byte[] getId() {
		return Id;
	}

	public void setId(byte[] id) {
		Id = id;
	}

	public ctGrupo getGrupo() {
		return grupo;
	}

	public void setGrupo(ctGrupo grupo) {
		this.grupo = grupo;
	}

	public String getcGrupo() {
		return cGrupo;
	}

	public void setcGrupo(String cGrupo) {
		this.cGrupo = cGrupo;
	}

	public String getcEdad() {
		return cEdad;
	}

	public void setcEdad(String cEdad) {
		this.cEdad = cEdad;
	}

	public String getcNombreFiscal() {
		return cNombreFiscal;
	}

	public void setcNombreFiscal(String cNombreFiscal) {
		this.cNombreFiscal = cNombreFiscal;
	}

	public String getcCalleFiscal() {
		return cCalleFiscal;
	}

	public void setcCalleFiscal(String cCalleFiscal) {
		this.cCalleFiscal = cCalleFiscal;
	}

	public String getcNumeroFiscal() {
		return cNumeroFiscal;
	}

	public void setcNumeroFiscal(String cNumeroFiscal) {
		this.cNumeroFiscal = cNumeroFiscal;
	}

	public String getcColoniaFiscal() {
		return cColoniaFiscal;
	}

	public void setcColoniaFiscal(String cColoniaFiscal) {
		this.cColoniaFiscal = cColoniaFiscal;
	}

	public String getcMunicipioFiscal() {
		return cMunicipioFiscal;
	}

	public void setcMunicipioFiscal(String cMunicipioFiscal) {
		this.cMunicipioFiscal = cMunicipioFiscal;
	}

	public String getcCPFiscal() {
		return cCPFiscal;
	}

	public void setcCPFiscal(String cCPFiscal) {
		this.cCPFiscal = cCPFiscal;
	}

	public String getcCiudadFiscal() {
		return cCiudadFiscal;
	}

	public void setcCiudadFiscal(String cCiudadFiscal) {
		this.cCiudadFiscal = cCiudadFiscal;
	}

	public String getcEstadoFiscal() {
		return cEstadoFiscal;
	}

	public void setcEstadoFiscal(String cEstadoFiscal) {
		this.cEstadoFiscal = cEstadoFiscal;
	}

	public String getcRfcFiscal() {
		return cRfcFiscal;
	}

	public void setcRfcFiscal(String cRfcFiscal) {
		this.cRfcFiscal = cRfcFiscal;
	}

	public String getcTelEmergencia() {
		return cTelEmergencia;
	}

	public void setcTelEmergencia(String cTelEmergencia) {
		this.cTelEmergencia = cTelEmergencia;
	}

	public String getcGenero() {
		return cGenero;
	}

	public void setcGenero(String cGenero) {
		this.cGenero = cGenero;
	}

	public Boolean getlSeguro() {
		return lSeguro;
	}

	public void setlSeguro(Boolean lSeguro) {
		this.lSeguro = lSeguro;
	}

	public Boolean getlFactura() {
		return lFactura;
	}

	public void setlFactura(Boolean lFactura) {
		this.lFactura = lFactura;
	}

	public Timestamp getDtFechaIns() {
		return dtFechaIns;
	}

	public void setDtFechaIns(Timestamp dtFechaIns) {
		this.dtFechaIns = dtFechaIns;
	}

	public Boolean getlAlergia() {
		return lAlergia;
	}

	public void setlAlergia(Boolean lAlergia) {
		this.lAlergia = lAlergia;
	}

	public String getcAlergia() {
		return cAlergia;
	}

	public void setcAlergia(String cAlergia) {
		this.cAlergia = cAlergia;
	}

	public Boolean getlMedicamento() {
		return lMedicamento;
	}

	public void setlMedicamento(Boolean lMedicamento) {
		this.lMedicamento = lMedicamento;
	}

	public String getcMedicamento() {
		return cMedicamento;
	}

	public void setcMedicamento(String cMedicamento) {
		this.cMedicamento = cMedicamento;
	}

	public Boolean getlLesion() {
		return lLesion;
	}

	public void setlLesion(Boolean lLesion) {
		this.lLesion = lLesion;
	}

	public String getcLesion() {
		return cLesion;
	}

	public void setcLesion(String cLesion) {
		this.cLesion = cLesion;
	}

	public Boolean getlTratamiento() {
		return lTratamiento;
	}

	public void setlTratamiento(Boolean lTratamiento) {
		this.lTratamiento = lTratamiento;
	}

	public String getcTratamiento() {
		return cTratamiento;
	}

	public void setcTratamiento(String cTratamiento) {
		this.cTratamiento = cTratamiento;
	}

	public BigDecimal getDeDescuento() {
		return deDescuento;
	}

	public void setDeDescuento(BigDecimal deDescuento) {
		this.deDescuento = deDescuento;
	}

	public String getcMotivoDesc() {
		return cMotivoDesc;
	}

	public void setcMotivoDesc(String cMotivoDesc) {
		this.cMotivoDesc = cMotivoDesc;
	}

	public String getcReferencia() {
		return cReferencia;
	}

	public void setcReferencia(String cReferencia) {
		this.cReferencia = cReferencia;
	}
	
	
	
	

}
