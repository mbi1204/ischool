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
import com.sinergitec.ischool.dao.ct.ctProfesorDao;
import com.sinergitec.ischool.model.ct.ctProfesor;
import com.sinergitec.ischool.util.DBConexion;
import com.sinergitec.ischool.util.VectorResultSet;

@Repository
public class ctProfesorDaoImpl implements ctProfesorDao {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void add_ctProfesor(ctProfesor obj_ctProfesor) throws Open4GLException, IOException {

		List<ctProfesor> Lista = new ArrayList<ctProfesor>();

		Lista.add(obj_ctProfesor);

		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		System.out.println("antes del for");
		for (ctProfesor obj : Lista) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}

		System.out.println("despues del for");

		ResultSetHolder ttProfesores = new ResultSetHolder(new VectorResultSet(vecTabla1));
		System.out.println("despues conversion");

		try {		
			app.as_ctProfesor_Inserta("SISIMB", ttProfesores, oplResultado, opcTexto);		

			System.out.println(opcTexto.getValue());

		} catch (Exception ex) {
			System.err.println(ex);

		} finally {
			app._release();
			DBConexion.closeConnection(conexion);

		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void update_ctProfesor(ctProfesor obj_ctProfesor) throws Open4GLException, IOException {

		List<ctProfesor> Lista = new ArrayList<ctProfesor>();
		Lista.add(obj_ctProfesor);

		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();
		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		for (ctProfesor obj : Lista) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}

		ResultSet alumnosModificados = new VectorResultSet(vecTabla1);

		try {
			app.as_ctProfesor_Actualiza("SISIMB", alumnosModificados, oplResultado, opcTexto);
			System.out.print(opcTexto.getValue() + " Y el Resultado " + oplResultado.getValue());

		} finally {
			// TODO: handle finally clause
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}

	public void remove_ctProfesor(int id) throws Open4GLException, IOException {

		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		try {
			System.out.println("Entro al metodo eliminar");
			app.as_ctAlumno_Borra("SISIMB", id, oplResultado, opcTexto);
			System.err.println(opcTexto.getValue());
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}
}
