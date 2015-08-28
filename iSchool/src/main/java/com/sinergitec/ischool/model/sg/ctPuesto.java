package com.sinergitec.ischool.model.sg;

import java.util.Arrays;
import java.util.Vector;

public class ctPuesto {
	private Integer iIdPuesto;
	private String cPuesto;
	private Boolean lActivo;
	private byte[] Id;
	
	
	public ctPuesto(){
		iIdPuesto = 0;
		
	}

	public Integer getiIdPuesto() {
		return iIdPuesto;
	}

	public void setiIdPuesto(Integer iIdPuesto) {
		this.iIdPuesto = iIdPuesto;
	}

	public String getcPuesto() {
		return cPuesto;
	}

	public void setcPuesto(String cPuesto) {
		this.cPuesto = cPuesto;
	}

	public Boolean getlActivo() {
		return lActivo;
	}

	public void setlActivo(Boolean lActivo) {
		this.lActivo = lActivo;
	}

	public byte[] getId() {
		return Id;
	}

	public void setId(byte[] id) {
		Id = id;
	}

	@Override
	public String toString() {
		return "ctPuesto [iIdPuesto=" + iIdPuesto + ", cPuesto=" + cPuesto
				+ ", lActivo=" + lActivo + ", Id=" + Arrays.toString(Id) + "]";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getVectorDatos() {
		Vector vector = new Vector();
		vector.add(this.getiIdPuesto());
		vector.add(this.getcPuesto());
		vector.add(this.getlActivo());
		vector.add(this.getId());

		return vector;
	}

}
