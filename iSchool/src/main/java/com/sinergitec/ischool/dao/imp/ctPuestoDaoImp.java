package com.sinergitec.ischool.dao.imp;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Repository;

import com.progress.AppServer.*;
import com.progress.open4gl.BooleanHolder;
import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.ResultSetHolder;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.StringHolder;
import com.progress.open4gl.SystemErrorException;
import com.progress.open4gl.javaproxy.Connection;
import com.sinergitec.ischool.dao.ctPuestoDao;
import com.sinergitec.ischool.model.ctPuesto;
import com.sinergitec.ischool.util.DBConexion;
import com.sinergitec.ischool.util.VectorResultSet;

@Repository
public class ctPuestoDaoImp implements ctPuestoDao {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void add_ctPuesto(ctPuesto obj_ctPuesto) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException {
		// TODO Auto-generated method stub

		
		List<ctPuesto> ListNuevos = new ArrayList<ctPuesto>();
		ListNuevos.add(obj_ctPuesto);
		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		StringHolder ps_Texto = new StringHolder();
		BooleanHolder ps_Resultado = new BooleanHolder();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		for (ctPuesto obj : ListNuevos) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}
		ResultSetHolder tt_Nuevos = new ResultSetHolder(new VectorResultSet(
				vecTabla1));

		try {
			app.as_ctPuesto_Inserta("SISIMB", tt_Nuevos, ps_Resultado, ps_Texto);
			System.out.print(ps_Texto.getStringValue());
		} catch (Exception ex) {

		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void update_ctPuesto(ctPuesto obj) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("entro al update");
		StringHolder ps_Texto = new StringHolder();
		BooleanHolder ps_Resultado = new BooleanHolder();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		vecRow1 = obj.getVectorDatos();
		vecTabla1.add(vecRow1);

		ResultSet tt_Modificados = new VectorResultSet(vecTabla1);

		try {
			app.as_ctPuesto_Actualiza("SISIMB", tt_Modificados, ps_Resultado,
					ps_Texto);
			
			System.out.print(ps_Texto.getStringValue());

		} finally {
			// TODO: handle finally clause
			app._release();
			DBConexion.closeConnection(conexion);
		}

	}

	@Override
	public List<ctPuesto> list_ctPuesto() throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException, SQLException {
		// TODO Auto-generated method stub
		
		ResultSetHolder tt_ctPuesto = new ResultSetHolder();
		StringHolder opcError = new StringHolder();
		BooleanHolder oplError = new BooleanHolder();
		List<ctPuesto> Lista = new ArrayList<ctPuesto>();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		try {
			app.as_ctPuesto_Carga(true, tt_ctPuesto, oplError, opcError);
			ResultSet rs_tt_ctPuesto = tt_ctPuesto.getResultSetValue();
			
		

			while (rs_tt_ctPuesto.next()) {
				
				
				ctPuesto obj = new ctPuesto();
				
				obj.setiIdPuesto(rs_tt_ctPuesto.getInt("iIdPuesto"));
				obj.setcPuesto(rs_tt_ctPuesto.getString("cPuesto"));
				obj.setlActivo(rs_tt_ctPuesto.getBoolean("lActivo"));
				obj.setId(rs_tt_ctPuesto.getBytes("Id"));
				Lista.add(obj);
				
					System.out.println(obj.getcPuesto());

			}

		} catch (Exception ex) {

			Lista = null;
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}

		return Lista;
	}

	@Override
	public ctPuesto get_ctPuesto(int id) throws  RunTime4GLException,
	SystemErrorException, Open4GLException, IOException, SQLException  {
		// TODO Auto-generated method stub
		
		
		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();

		ResultSetHolder tt_ctPuesto = new ResultSetHolder();
		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);
		ctPuesto obj = new ctPuesto();
		try {

			
			app.as_ctPuesto_get("SISIMB", id, tt_ctPuesto, oplResultado, opcTexto);
			
						
			
			
			ResultSet rs_tt_ctPuesto = tt_ctPuesto.getResultSetValue();

			while (rs_tt_ctPuesto.next()) {
				
				
				obj.setiIdPuesto(rs_tt_ctPuesto.getInt("iIdPuesto"));
				obj.setcPuesto(rs_tt_ctPuesto.getString("cPuesto"));
				obj.setlActivo(rs_tt_ctPuesto.getBoolean("lActivo"));
				obj.setId(rs_tt_ctPuesto.getBytes("Id"));
				
			

			}
			
		} catch (Exception ex) {
			System.err.println(ex);

			
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
		
		
		
		return obj;

	}

	@Override
	public void remove_ctPuesto(int id) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException {
		// TODO Auto-generated method stub

		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		try {
			
			app.as_ctPuesto_Borra("SISIMB", id, oplResultado, opcTexto);

			System.err.println(opcTexto.getValue());
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}

	}

}
