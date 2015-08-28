package com.sinergitec.ischool.dao.imp;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.progress.AppServer.AppServer;
import com.progress.open4gl.BooleanHolder;
import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.ResultSetHolder;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.StringHolder;
import com.progress.open4gl.SystemErrorException;
import com.progress.open4gl.javaproxy.Connection;
import com.sinergitec.ischool.dao.ctMenuDao;
import com.sinergitec.ischool.dao.ctProgramaDao;
import com.sinergitec.ischool.dao.ctPuestoDao;
import com.sinergitec.ischool.model.sg.ctMenu;
import com.sinergitec.ischool.model.sg.ctPrograma;
import com.sinergitec.ischool.model.sg.ctPuesto;
import com.sinergitec.ischool.util.DBConexion;
import com.sinergitec.ischool.util.VectorResultSet;

@Repository
public class ctProgramaDaoImp implements ctProgramaDao {

	@Autowired
	private ctMenuDao DaoMenu;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void add_ctPrograma(ctPrograma obj_ctPrograma)
			throws RunTime4GLException, SystemErrorException, Open4GLException,
			IOException {
		// TODO Auto-generated method stub

		List<ctPrograma> ListNuevos = new ArrayList<ctPrograma>();
		ListNuevos.add(obj_ctPrograma);
		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		StringHolder ps_Texto = new StringHolder();
		BooleanHolder ps_Resultado = new BooleanHolder();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		for (ctPrograma obj : ListNuevos) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}
		ResultSetHolder tt_Nuevos = new ResultSetHolder(new VectorResultSet(
				vecTabla1));

		try {
			app.as_ctPrograma_Inserta("SISIMB", tt_Nuevos, ps_Resultado,
					ps_Texto);
			System.out.print(ps_Texto.getStringValue());
		} catch (Exception ex) {

		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void update_ctPrograma(ctPrograma obj) throws RunTime4GLException,
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
			app.as_ctPrograma_Actualiza("SISIMB", tt_Modificados, ps_Resultado,
					ps_Texto);

			System.out.print(ps_Texto.getStringValue());

		} finally {
			// TODO: handle finally clause
			app._release();
			DBConexion.closeConnection(conexion);
		}

	}

	@Override
	public List<ctPrograma> list_ctPrograma() throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException, SQLException {
		// TODO Auto-generated method stub

		ResultSetHolder tt_ctPrograma = new ResultSetHolder();
		StringHolder opcError = new StringHolder();
		BooleanHolder oplError = new BooleanHolder();
		List<ctPrograma> Lista = new ArrayList<ctPrograma>();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		List<ctMenu> Lista_ctMenu = new ArrayList<ctMenu>();

		Lista_ctMenu = DaoMenu.list_ctMenu();

		try {
			app.as_ctPrograma_Carga(true, tt_ctPrograma, oplError, opcError);
			ResultSet rs_tt_ctPrograma = tt_ctPrograma.getResultSetValue();

			while (rs_tt_ctPrograma.next()) {

				ctPrograma obj = new ctPrograma();
				obj.setiIdPrograma(rs_tt_ctPrograma.getInt("iIdPrograma"));
				obj.setiIdMenu(rs_tt_ctPrograma.getInt("iIdMenu"));
				obj.setcPrograma(rs_tt_ctPrograma.getString("cPrograma"));
				obj.setlActivo(rs_tt_ctPrograma.getBoolean("lActivo"));
				obj.setcNombre(rs_tt_ctPrograma.getString("cNombre"));
				obj.setId(rs_tt_ctPrograma.getBytes("Id"));

				for (ctMenu obj_ctMenu : Lista_ctMenu) {
					if (obj_ctMenu.getiIdMenu().equals(obj.getiIdMenu())) {
						System.out.print("entro al for");
						ctMenu obj_nctMenu = new ctMenu();
						obj_nctMenu.setiIdMenu(obj_ctMenu.getiIdMenu());
						obj_nctMenu.setcMenu(obj_ctMenu.getcMenu());
						obj.setMenu(obj_nctMenu);

					}
				}

				Lista.add(obj);

			}

		} catch (Exception ex) {

			System.out.print(ex);

			Lista = null;
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}

		return Lista;
	}

	@Override
	public ctPrograma get_ctPrograma(int idMenu, int idPrograma)
			throws RunTime4GLException, SystemErrorException, Open4GLException,
			IOException, SQLException {
		// TODO Auto-generated method stub
		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();

		ResultSetHolder tt_ctPrograma = new ResultSetHolder();
		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);
		ctPrograma obj = new ctPrograma();
		
		List<ctMenu> Lista_ctMenu = new ArrayList<ctMenu>();

		Lista_ctMenu = DaoMenu.list_ctMenu();
		try {

			app.as_ctPrograma_get("SISIMB", idMenu, idPrograma, tt_ctPrograma,
					oplResultado, opcTexto);

			ResultSet rs_tt_ctPrograma = tt_ctPrograma.getResultSetValue();

			while (rs_tt_ctPrograma.next()) {

				
				obj.setiIdPrograma(rs_tt_ctPrograma.getInt("iIdPrograma"));
				obj.setiIdMenu(rs_tt_ctPrograma.getInt("iIdMenu"));
				obj.setcPrograma(rs_tt_ctPrograma.getString("cPrograma"));
				obj.setlActivo(rs_tt_ctPrograma.getBoolean("lActivo"));
				obj.setcNombre(rs_tt_ctPrograma.getString("cNombre"));
				obj.setId(rs_tt_ctPrograma.getBytes("Id"));
				

				for (ctMenu obj_ctMenu : Lista_ctMenu) {
					if (obj_ctMenu.getiIdMenu().equals(obj.getiIdMenu())) {
						System.out.print("entro al for");
						ctMenu obj_nctMenu = new ctMenu();
						obj_nctMenu.setiIdMenu(obj_ctMenu.getiIdMenu());
						obj_nctMenu.setcMenu(obj_ctMenu.getcMenu());
						obj.setMenu(obj_nctMenu);

					}
				}

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
	public void remove_ctPrograma(int idMenu, int idPrograma)
			throws RunTime4GLException, SystemErrorException, Open4GLException,
			IOException {
		// TODO Auto-generated method stub

		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		try {

			app.as_ctPrograma_Borra("SISIMB", idMenu, idPrograma, oplResultado,
					opcTexto);

			System.err.println(opcTexto.getValue());
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}

}
