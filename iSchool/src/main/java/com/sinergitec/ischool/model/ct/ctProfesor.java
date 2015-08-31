package com.sinergitec.ischool.model.ct;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;

public class ctProfesor {

	private Integer iIdProfesor;
	private String cNomProfesor;
	private String cApeProfesor;
	private String cCalleProfesor;
	private String iNumExtProfe;
	private String iNumIntProfe;
	private String cColProfesor;
	private String cCPProfesor;
	private String cMunicipioProfe;
	private String cEdoProfesor;
	private String cTelProfesor;
	private Boolean lEstProfesor;
	private Timestamp dtContrato;
	private Timestamp dtFechaNacProfe;
	private byte[] Id;

	public Integer getiIdProfesor() {
		return iIdProfesor;
	}

	public void setiIdProfesor(Integer iIdProfesor) {
		this.iIdProfesor = iIdProfesor;
	}

	public String getcNomProfesor() {
		return cNomProfesor;
	}

	public void setcNomProfesor(String cNomProfesor) {
		this.cNomProfesor = cNomProfesor;
	}

	public String getcApeProfesor() {
		return cApeProfesor;
	}

	public void setcApeProfesor(String cApeProfesor) {
		this.cApeProfesor = cApeProfesor;
	}

	public String getcCalleProfesor() {
		return cCalleProfesor;
	}

	public void setcCalleProfesor(String cCalleProfesor) {
		this.cCalleProfesor = cCalleProfesor;
	}

	public String getiNumExtProfe() {
		return iNumExtProfe;
	}

	public void setiNumExtProfe(String iNumExtProfe) {
		this.iNumExtProfe = iNumExtProfe;
	}

	public String getiNumIntProfe() {
		return iNumIntProfe;
	}

	public void setiNumIntProfe(String iNumIntProfe) {
		this.iNumIntProfe = iNumIntProfe;
	}

	public String getcColProfesor() {
		return cColProfesor;
	}

	public void setcColProfesor(String cColProfesor) {
		this.cColProfesor = cColProfesor;
	}

	public String getcCPProfesor() {
		return cCPProfesor;
	}

	public void setcCPProfesor(String cCPProfesor) {
		this.cCPProfesor = cCPProfesor;
	}

	public String getcMunicipioProfe() {
		return cMunicipioProfe;
	}

	public void setcMunicipioProfe(String cMunicipioProfe) {
		this.cMunicipioProfe = cMunicipioProfe;
	}

	public String getcEdoProfesor() {
		return cEdoProfesor;
	}

	public void setcEdoProfesor(String cEdoProfesor) {
		this.cEdoProfesor = cEdoProfesor;
	}

	public String getcTelProfesor() {
		return cTelProfesor;
	}

	public void setcTelProfesor(String cTelProfesor) {
		this.cTelProfesor = cTelProfesor;
	}

	public Boolean getlEstProfesor() {
		return lEstProfesor;
	}

	public void setlEstProfesor(Boolean lEstProfesor) {
		this.lEstProfesor = lEstProfesor;
	}

	public Timestamp getDtContrato() {
		return dtContrato;
	}

	public void setDtContrato(Timestamp dtContrato) {
		this.dtContrato = dtContrato;
	}

	public Timestamp getDtFechaNacProfe() {
		return dtFechaNacProfe;
	}

	public void setDtFechaNacProfe(Timestamp dtFechaNacProfe) {
		this.dtFechaNacProfe = dtFechaNacProfe;
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
		
		
		Date date= new java.util.Date();
		
		
		this.setDtFechaNacProfe(new Timestamp(date.getTime()));
		this.setDtContrato(new Timestamp(date.getTime()));

		vector.add(this.getiIdProfesor());
		vector.add(this.getcNomProfesor());
		vector.add(this.getcApeProfesor());
		vector.add(this.getcCalleProfesor());
		vector.add(this.getiNumExtProfe());
		vector.add(this.getiNumIntProfe());
		vector.add(this.getcColProfesor());
		vector.add(this.getcCPProfesor());
		vector.add(this.getcMunicipioProfe());
		vector.add(this.getcEdoProfesor());
		vector.add(this.getcTelProfesor());
		vector.add(this.getlEstProfesor());
		vector.add(this.getDtFechaNacProfe());
		vector.add(this.getDtContrato());
		vector.add(this.getId());

		return vector;
	}
}
