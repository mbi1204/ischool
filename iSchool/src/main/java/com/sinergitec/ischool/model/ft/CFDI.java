package com.sinergitec.ischool.model.ft;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Vector;

public class CFDI {
	 private String CveEmpresa;
	 private Integer Solicitud;
	 private String Serie;
	 private Integer Folio;
	 private String UUID;
	 private Timestamp FechaHora;
	 private byte[] XML;
	 private byte[] PDF;
	 private String CveGenerado;
	 private Timestamp Cancelado;
	 private String CveCancelado;
	 private String Motivo;
	 private byte[] XMLCancela;
     byte[] Id;     
     
     
     
	public byte[] getXML() {
		return XML;
	}
	public void setXML(byte[] xML) {
		XML = xML;
	}
	public byte[] getPDF() {
		return PDF;
	}
	public void setPDF(byte[] pDF) {
		PDF = pDF;
	}
	public byte[] getXMLCancela() {
		return XMLCancela;
	}
	public void setXMLCancela(byte[] xMLCancela) {
		XMLCancela = xMLCancela;
	}
	public String getCveEmpresa() {
		return CveEmpresa;
	}
	public void setCveEmpresa(String cveEmpresa) {
		CveEmpresa = cveEmpresa;
	}
	public Integer getSolicitud() {
		return Solicitud;
	}
	public void setSolicitud(Integer solicitud) {
		Solicitud = solicitud;
	}
	public String getSerie() {
		return Serie;
	}
	public void setSerie(String serie) {
		Serie = serie;
	}
	public Integer getFolio() {
		return Folio;
	}
	public void setFolio(Integer folio) {
		Folio = folio;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public Timestamp getFechaHora() {
		return FechaHora;
	}
	public void setFechaHora(Timestamp fechaHora) {
		FechaHora = fechaHora;
	}
	
	public String getCveGenerado() {
		return CveGenerado;
	}
	public void setCveGenerado(String cveGenerado) {
		CveGenerado = cveGenerado;
	}
	public Timestamp getCancelado() {
		return Cancelado;
	}
	public void setCancelado(Timestamp cancelado) {
		Cancelado = cancelado;
	}
	public String getCveCancelado() {
		return CveCancelado;
	}
	public void setCveCancelado(String cveCancelado) {
		CveCancelado = cveCancelado;
	}
	public String getMotivo() {
		return Motivo;
	}
	public void setMotivo(String motivo) {
		Motivo = motivo;
	}
	
	public byte[] getId() {
		return Id;
	}
	public void setId(byte[] id) {
		Id = id;
	}
     
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getVectorDatos(){
		Vector vector = new Vector();		
		
		vector.add(this.getCveEmpresa());
		vector.add(this.getSolicitud());
		vector.add(this.getSerie());
		vector.add(this.getFolio());
		vector.add(this.getUUID());
		vector.add(this.getFechaHora());
		vector.add(this.getXML());
		vector.add(this.getPDF());		
		vector.add(this.getCveGenerado());		
		vector.add(this.getCancelado());
		vector.add(this.getCveCancelado());
		vector.add(this.getMotivo());
		vector.add(this.getXMLCancela());
		vector.add(this.getId());	
		return vector;
	}
	@Override
	public String toString() {
		return "CFDI [CveEmpresa=" + CveEmpresa + ", Solicitud=" + Solicitud + ", Serie=" + Serie + ", Folio=" + Folio
				+ ", UUID=" + UUID + ", FechaHora=" + FechaHora + ", XML=" + XML + ", PDF=" + PDF + ", CveGenerado="
				+ CveGenerado + ", Cancelado=" + Cancelado + ", CveCancelado=" + CveCancelado + ", Motivo=" + Motivo
				+ ", XMLCancela=" + XMLCancela + ", Id=" + Arrays.toString(Id) + "]";
	}  
  
	
	


}
