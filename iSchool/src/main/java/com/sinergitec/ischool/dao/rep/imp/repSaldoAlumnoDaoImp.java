package com.sinergitec.ischool.dao.rep.imp;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.progress.AppServer.AppServer;
import com.progress.open4gl.BooleanHolder;
import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.ResultSetHolder;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.StringHolder;
import com.progress.open4gl.SystemErrorException;
import com.progress.open4gl.javaproxy.Connection;
import com.sinergitec.ischool.dao.rep.repSaldoAlumnoDao;
import com.sinergitec.ischool.model.cb.cbAlumnoSaldo;
import com.sinergitec.ischool.util.DBConexion;

@Repository
public class repSaldoAlumnoDaoImp implements repSaldoAlumnoDao {

	@Override
	public List<cbAlumnoSaldo> list_cbAlumno(int idGrupo)
			throws RunTime4GLException, SystemErrorException, Open4GLException, IOException, SQLException {
		// TODO Auto-generated method stub
		
		ResultSetHolder tt_cbAlumno = new ResultSetHolder();

		StringHolder opcError = new StringHolder();
		BooleanHolder oplError = new BooleanHolder();
		List<cbAlumnoSaldo> Lista = new ArrayList<cbAlumnoSaldo>();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);
		
		try {
			
			app.as_repSaldoAlumno(idGrupo, tt_cbAlumno, oplError, opcError);
			
			ResultSet rs_tt_cbAlumno = tt_cbAlumno.getResultSetValue();
			
			while (rs_tt_cbAlumno.next()) {

				cbAlumnoSaldo obj = new cbAlumnoSaldo();			

				obj.setiIdAlumno((rs_tt_cbAlumno.getInt("iIdAlumno")));
				obj.setcNombre(rs_tt_cbAlumno.getString("cNombre"));
				obj.setcApellido(rs_tt_cbAlumno.getString("cApellido"));
				obj.setcTel(rs_tt_cbAlumno.getString("cTel"));
				obj.setcCorreo(rs_tt_cbAlumno.getString("cEmail"));
				obj.setDeSaldo(rs_tt_cbAlumno.getDouble("deSaldo"));
//				System.out.println("dao");
//				System.out.println("email " + obj.getcCorreo());
//				System.out.println("saldo " + obj.getDeSaldo());
				

				Lista.add(obj);
			}
			
			System.out.println(opcError.getStringValue());
			
		} catch (Exception ex) {
			System.out.print(ex);
			Lista = null;
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
		
		return Lista;
	}

}
