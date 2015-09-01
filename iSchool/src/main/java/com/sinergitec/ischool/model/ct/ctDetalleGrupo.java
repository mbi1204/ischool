package com.sinergitec.ischool.model.ct;

import java.util.Vector;

public class ctDetalleGrupo {
	private int iIdGrup;
	private int iIdAlumno;
	byte[] Id;
	
	public int getiIdGrup() {
		return iIdGrup;
	}
	public void setiIdGrup(int iIdGrup) {
		this.iIdGrup = iIdGrup;
	}
	public int getiIdAlumno() {
		return iIdAlumno;
	}
	public void setiIdAlumno(int iIdAlumno) {
		this.iIdAlumno = iIdAlumno;
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
		/*Timestamp conversion = Timestamp.valueOf(this.getDtFechaNac()+" 00:00:00.000000");
		Date date= new java.util.Date();
		this.setDtFechaIns(new Timestamp(date.getTime()));*/
		
		vector.add(this.getiIdGrup());
		vector.add(this.getiIdAlumno());
		vector.add(this.getId());

		return vector;
	}
}
