package com.sinergitec.ischool.model.ct;

import java.sql.Timestamp;
import java.util.Vector;

public class ctProfesor {
	
	private int iIdProfesor;
	private String cNomProfesor;
	private String cApeProfesor;
	private String cCalleProfesor;
	private int iNumExtProfe;
	private int iNumIntProfe;
	private String cColProfesor;
	private String cCPProfesor;
	private String cMunicipioProfe;
	private String cEdoProfesor;
	private String cTelProfesor;
	private boolean lEstProfesor;
	private Timestamp dtFechaNacProfe;
	private Timestamp dtContrato;
	byte[] id;
	
	public int getiIdProfesor() {
		return iIdProfesor;
	}
	public void setiIdProfesor(int iIdProfesor) {
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
	public int getiNumExtProfe() {
		return iNumExtProfe;
	}
	public void setiNumExtProfe(int iNumExtProfe) {
		this.iNumExtProfe = iNumExtProfe;
	}
	public int getiNumIntProfe() {
		return iNumIntProfe;
	}
	public void setiNumIntProfe(int iNumIntProfe) {
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
	public boolean getlEstProfesor() {
		return lEstProfesor;
	}
	public void setlEstProfesor(boolean lEstProfesor) {
		this.lEstProfesor = lEstProfesor;
	}
	public Timestamp getDtFechaNacProfe() {
		return dtFechaNacProfe;
	}
	public void setDtFechaNacProfe(Timestamp dtFechaNacProfe) {
		this.dtFechaNacProfe = dtFechaNacProfe;
	}
	public Timestamp getDtContrato() {
		return dtContrato;
	}
	public void setDtContrato(Timestamp dtContrato) {
		this.dtContrato = dtContrato;
	}
	public byte[] getId() {
		return id;
	}
	public void setId(byte[] id) {
		this.id = id;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getVectorDatos(){
		Vector vector = new Vector();
		Timestamp conversion = Timestamp.valueOf(this.getDtFechaNacProfe()+" 00:00:00.000000");
		Timestamp conversion2 = Timestamp.valueOf(this.getDtContrato()+" 00:00:00.000000");
		/*Date date= new java.util.Date();
		Fecha Actual(new Timestamp(date.getTime()));*/
		
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
		vector.add(conversion);
		vector.add(conversion2);
		vector.add(this.getId());

		return vector;
	}
}
