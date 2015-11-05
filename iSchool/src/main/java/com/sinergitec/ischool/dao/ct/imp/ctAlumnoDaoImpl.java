package com.sinergitec.ischool.dao.ct.imp;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Repository;

import com.progress.AppServer.AppServer;
import com.progress.open4gl.BooleanHolder;
import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.ResultSetHolder;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.StringHolder;
import com.progress.open4gl.SystemErrorException;
import com.progress.open4gl.javaproxy.Connection;
import com.sinergitec.ischool.dao.ct.ctAlumnoDao;
import com.sinergitec.ischool.model.ct.ctAlumno;
import com.sinergitec.ischool.model.ct.ctGrupo;
import com.sinergitec.ischool.util.DBConexion;
import com.sinergitec.ischool.util.VectorResultSet;

@Repository
public class ctAlumnoDaoImpl implements ctAlumnoDao {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String add_ctAlumno(ctAlumno obj, List<ctGrupo> listaGrupo) throws Open4GLException, IOException {

		String vcError = null;

		List<ctAlumno> Lista = new ArrayList<ctAlumno>();
		Lista.add(obj);

		Vector vecTabla1, vecRow1, vecTablaGrupo, vecRow2;
		vecTabla1 = new Vector();
		vecTablaGrupo = new Vector();

		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();		

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		for (ctAlumno obj_ctAlumno : Lista) {
			vecRow1 = obj_ctAlumno.getVectorDatos();
			vecTabla1.add(vecRow1);
		}

		for (ctGrupo objGrupo : listaGrupo) {
			vecRow2 = objGrupo.getVectorDatos();
			vecTablaGrupo.add(vecRow2);

		}

		ResultSetHolder ttAlumnos = new ResultSetHolder(new VectorResultSet(vecTabla1));
		ResultSetHolder ttGrupo = new ResultSetHolder(new VectorResultSet(vecTablaGrupo));

		try {

			app.as_ctAlumno_Inserta("SISIMB", ttAlumnos, ttGrupo, oplResultado, opcTexto);
			
			
			ResultSet rsAlumno = ttAlumnos.getResultSetValue();
			while(rsAlumno.next()){
				ctAlumno objAlumno = new ctAlumno();
				
				objAlumno.setiIdAlumno(rsAlumno.getInt("iIdAlumno"));
				objAlumno.setcNombre(rsAlumno.getString("cNombre"));
				objAlumno.setcApellido(rsAlumno.getString("cApellido"));
				objAlumno.setcCalle(rsAlumno.getString("cCalle"));
				objAlumno.setcNumExt(rsAlumno.getString("cNumExt"));
				objAlumno.setcNumInt(rsAlumno.getString("cNumInt"));
				objAlumno.setcColonia(rsAlumno.getString("cCol"));
				objAlumno.setcCP(rsAlumno.getString("cCP"));
				objAlumno.setcMunicipio(rsAlumno.getString("cMunicipio"));
				objAlumno.setcEstado(rsAlumno.getString("cEdo"));
				objAlumno.setlEstatus(rsAlumno.getBoolean("lEstatus"));
				objAlumno.setDtFechaIns(rsAlumno.getTimestamp("dtFechaIns"));
				objAlumno.setcCorreo(rsAlumno.getString("cEmail"));
				objAlumno.setcEdad(rsAlumno.getString("cEdad"));
				objAlumno.setcTelEmergencia(rsAlumno.getString("cTelEmergencia"));
				objAlumno.setcEstado(rsAlumno.getString("cEdo"));
				objAlumno.setcEstado(rsAlumno.getString("cEdo"));
				objAlumno.setcEstado(rsAlumno.getString("cEdo"));
				
				
				
				
			}
			
			

			vcError = (String) opcTexto.getValue();

		} catch (Exception ex) {

			vcError = ex.getMessage();

		} finally {
			app._release();
			DBConexion.closeConnection(conexion);

		}

		return vcError;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void update_ctAlumno(ctAlumno obj_ctAlumno) throws Open4GLException, IOException {

		List<ctAlumno> Lista_Update = new ArrayList<ctAlumno>();
		Lista_Update.add(obj_ctAlumno);

		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();
		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		for (ctAlumno obj : Lista_Update) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}

		ResultSet alumnosModificados = new VectorResultSet(vecTabla1);

		try {
			app.as_ctAlumno_Actualiza("SISIMB", alumnosModificados, oplResultado, opcTexto);
			System.out.print(opcTexto.getValue() + " Y el Resultado " + oplResultado.getValue());

		} finally {
			// TODO: handle finally clause
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}

	public void remove_ctAlumno(int id)
			throws RunTime4GLException, SystemErrorException, Open4GLException, IOException {

		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		try {

			app.as_ctAlumno_Borra("SISIMB", id, oplResultado, opcTexto);
			System.err.println(opcTexto.getValue());
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}
}
