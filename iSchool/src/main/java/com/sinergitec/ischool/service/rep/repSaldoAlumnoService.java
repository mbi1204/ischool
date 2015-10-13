package com.sinergitec.ischool.service.rep;

import java.util.List;

import com.sinergitec.ischool.model.cb.cbAlumnoSaldo;

public interface repSaldoAlumnoService {
	
	public List<cbAlumnoSaldo> list_cbAlumno(int idGrupo);

}
