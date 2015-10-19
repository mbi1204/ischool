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
import com.sinergitec.ischool.dao.rep.repAlumnoGrupoDao;
import com.sinergitec.ischool.model.ct.ctAlumno;
import com.sinergitec.ischool.util.DBConexion;
@Repository
public class repAlumnoGrupoDaoImp implements repAlumnoGrupoDao {

	@Override
	public List<ctAlumno> list_ctAlumno(int idGrupo)
			throws RunTime4GLException, SystemErrorException, Open4GLException, IOException, SQLException {
		// TODO Auto-generated method stub

		ResultSetHolder tt_ctAlumno = new ResultSetHolder();

		StringHolder opcError = new StringHolder();
		BooleanHolder oplError = new BooleanHolder();
		List<ctAlumno> Lista = new ArrayList<ctAlumno>();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);
		
		
		try {
			
			app.as_repAlumnoGrupo(idGrupo, tt_ctAlumno, oplError, opcError);
			
			ResultSet rs_tt_ctAlumno = tt_ctAlumno.getResultSetValue();

			while (rs_tt_ctAlumno.next()) {

				ctAlumno obj = new ctAlumno();

				obj.setiIdAlumno((rs_tt_ctAlumno.getInt("iIdAlumno")));
				obj.setcNombre(rs_tt_ctAlumno.getString("cNombre"));
				obj.setcApellido(rs_tt_ctAlumno.getString("cApellido"));
				obj.setcEdad(rs_tt_ctAlumno.getString("cEdad"));				
				obj.setcCalle(rs_tt_ctAlumno.getString("cCalle"));
				obj.setcNumExt(rs_tt_ctAlumno.getString("cNumExt"));
				obj.setcNumInt(rs_tt_ctAlumno.getString("cNumInt"));
				obj.setcColonia(rs_tt_ctAlumno.getString("cCol"));
				obj.setcCP(rs_tt_ctAlumno.getString("cCP"));
				obj.setcMunicipio(rs_tt_ctAlumno.getString("cMunicipio"));
				obj.setcEstado(rs_tt_ctAlumno.getString("cEdo"));
				obj.setcTel(rs_tt_ctAlumno.getString("cTel"));
				obj.setlEstatus(rs_tt_ctAlumno.getBoolean("lEstatus"));
				obj.setDtFechaIns(rs_tt_ctAlumno.getTimestamp("dtFechaIns"));
				obj.setcCorreo(rs_tt_ctAlumno.getString("cEmail"));
				obj.setId(rs_tt_ctAlumno.getBytes("Id"));				

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
