package com.sinergitec.ischool.model.ct;

import java.util.Vector;

public class ctFormaPago {
	private int iIdFormaPago;
	private String cFormaPago;
	private boolean lEstatus;
	byte[] Id;
	
	public int getiIdFormaPago() {
		return iIdFormaPago;
	}
	public void setiIdFormaPago(int iIdFormaPago) {
		this.iIdFormaPago = iIdFormaPago;
	}
	public String getcFormaPago() {
		return cFormaPago;
	}
	public void setcFormaPago(String cFormaPago) {
		this.cFormaPago = cFormaPago;
	}
	public boolean getlEstatus() {
		return lEstatus;
	}
	public void setlEstatus(boolean lEstatus) {
		this.lEstatus = lEstatus;
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
		
		vector.add(this.getiIdFormaPago());
		vector.add(this.getcFormaPago());
		vector.add(this.getlEstatus());
		vector.add(this.getId());		

		return vector;
	}
}
