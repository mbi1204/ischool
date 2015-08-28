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
import com.progress.open4gl.StringHolder;
import com.progress.open4gl.javaproxy.Connection;
import com.sinergitec.ischool.model.ct.ctCurso;
import com.sinergitec.ischool.dao.ct.ctCursoDao;
import com.sinergitec.ischool.util.DBConexion;
import com.sinergitec.ischool.util.VectorResultSet;

@Repository
public class ctCursoDaompl implements ctCursoDao {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void add_ctCurso(ctCurso obj_ctCurso) throws Open4GLException, IOException {

		List<ctCurso> Lista = new ArrayList<ctCurso>();
		Lista.add(obj_ctCurso);

		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		for (ctCurso obj : Lista) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}

		ResultSetHolder ttctCurso = new ResultSetHolder(new VectorResultSet(vecTabla1));

		try {

			app.as_ctCurso_Inserta("SISIMB", ttctCurso, oplResultado, opcTexto);

			System.out.println(opcTexto.getValue());

		} catch (Exception ex) {
			System.err.println(ex);

		} finally {
			app._release();
			DBConexion.closeConnection(conexion);

		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void update_ctCurso(ctCurso c) throws Open4GLException, IOException {

		List<ctCurso> valorModificado = new ArrayList<ctCurso>();
		valorModificado.add(c);

		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();
		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		for (ctCurso e : valorModificado) {
			vecRow1 = e.getVectorDatos();
			vecTabla1.add(vecRow1);
		}

		ResultSet ctCursosModificados = new VectorResultSet(vecTabla1);

		try {
			app.as_ctCurso_Actualiza("SISIMB", ctCursosModificados, oplResultado, opcTexto);
			System.out.print(opcTexto.getValue() + " Y el Resultado " + oplResultado.getValue());

		} finally {
			// TODO: handle finally clause
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}

	public void remove_ctCurso(int id) throws Open4GLException, IOException {

		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		try {

			app.as_ctCurso_Borra("SISIMB", id, oplResultado, opcTexto);
			System.err.println(opcTexto.getValue());
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}
}
