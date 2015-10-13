package com.sinergitec.ischool.dao.rep;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.model.cb.cbAlumnoSaldo;

public interface repSaldoAlumnoDao {
	
	public List<cbAlumnoSaldo> list_cbAlumno(int idGrupo)
			throws RunTime4GLException, SystemErrorException, Open4GLException, IOException, SQLException;

}
