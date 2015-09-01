package com.sinergitec.ischool.dao.sg.imp;

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
import com.sinergitec.ischool.dao.sg.ctMenuDao;
import com.sinergitec.ischool.model.sg.ctMenu;
import com.sinergitec.ischool.util.DBConexion;
import com.sinergitec.ischool.util.VectorResultSet;

@Repository
public class ctMenuDaoImp implements ctMenuDao {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void add_ctMenu(ctMenu obj_ctMenu) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException {
		// TODO Auto-generated method stub

		
		List<ctMenu> ListNuevos = new ArrayList<ctMenu>();
		ListNuevos.add(obj_ctMenu);
		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		StringHolder ps_Texto = new StringHolder();
		BooleanHolder ps_Resultado = new BooleanHolder();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		for (ctMenu obj : ListNuevos) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}
		ResultSetHolder tt_Nuevos = new ResultSetHolder(new VectorResultSet(
				vecTabla1));

		try {
			app.as_ctMenu_Inserta("SISIMB", tt_Nuevos, ps_Resultado, ps_Texto);
			System.out.print(ps_Texto.getStringValue());
		} catch (Exception ex) {

		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void update_ctMenu(ctMenu obj) throws RunTime4GLException,
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
			app.as_ctMenu_Actualiza("SISIMB", tt_Modificados, ps_Resultado,
					ps_Texto);
			
			System.out.print(ps_Texto.getStringValue());

		} finally {
			// TODO: handle finally clause
			app._release();
			DBConexion.closeConnection(conexion);
		}

	}

	@Override
	public List<ctMenu> list_ctMenu() throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException, SQLException {
		// TODO Auto-generated method stub
		
		ResultSetHolder tt_ctMenu = new ResultSetHolder();
		StringHolder opcError = new StringHolder();
		BooleanHolder oplError = new BooleanHolder();
		List<ctMenu> Lista = new ArrayList<ctMenu>();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		try {
			app.as_ctMenu_Carga(true, tt_ctMenu, oplError, opcError);
			ResultSet rs_tt_ctMenu = tt_ctMenu.getResultSetValue();
			
		

			while (rs_tt_ctMenu.next()) {
				
				
				ctMenu obj = new ctMenu();
				
				obj.setiIdMenu(rs_tt_ctMenu.getInt("iIdMenu"));
				obj.setcMenu(rs_tt_ctMenu.getString("cMenu"));
				obj.setlActivo(rs_tt_ctMenu.getBoolean("lActivo"));
				obj.setId(rs_tt_ctMenu.getBytes("Id"));
				Lista.add(obj);
				
				

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
	public ctMenu get_ctMenu(int id) throws  RunTime4GLException,
	SystemErrorException, Open4GLException, IOException, SQLException  {
		// TODO Auto-generated method stub
		
		
		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();

		ResultSetHolder tt_ctMenu = new ResultSetHolder();
		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);
		ctMenu obj = new ctMenu();
		try {

			
			app.as_ctMenu_get("SISIMB", id, tt_ctMenu, oplResultado, opcTexto);
			
						
			
			
			ResultSet rs_tt_ctMenu = tt_ctMenu.getResultSetValue();

			while (rs_tt_ctMenu.next()) {
				
				
				obj.setiIdMenu(rs_tt_ctMenu.getInt("iIdMenu"));
				obj.setcMenu(rs_tt_ctMenu.getString("cMenu"));
				obj.setlActivo(rs_tt_ctMenu.getBoolean("lActivo"));
				obj.setId(rs_tt_ctMenu.getBytes("Id"));
				
			

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
	public void remove_ctMenu(int id) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException {
		// TODO Auto-generated method stub

		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		try {
			
			app.as_ctMenu_Borra("SISIMB", id, oplResultado, opcTexto);

			System.err.println(opcTexto.getValue());
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}

	}

}
