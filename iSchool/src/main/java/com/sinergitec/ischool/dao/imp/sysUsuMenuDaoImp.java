package com.sinergitec.ischool.dao.imp;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import com.sinergitec.ischool.dao.sysUsuMenuDao;
import com.sinergitec.ischool.model.sg.ctMenu;
import com.sinergitec.ischool.model.sg.sysUsuMenu;
import com.sinergitec.ischool.util.DBConexion;
import com.sinergitec.ischool.util.VectorResultSet;

@Repository
public class sysUsuMenuDaoImp implements sysUsuMenuDao {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void add_sysUsuMenu(sysUsuMenu obj_sysUsuMenu) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException {
		// TODO Auto-generated method stub
		
		
		List<sysUsuMenu> ListNuevos = new ArrayList<sysUsuMenu>();
		ListNuevos.add(obj_sysUsuMenu);
		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		StringHolder ps_Texto = new StringHolder();
		BooleanHolder ps_Resultado = new BooleanHolder();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		for (sysUsuMenu obj : ListNuevos) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}
		ResultSetHolder tt_Nuevos = new ResultSetHolder(new VectorResultSet(
				vecTabla1));

		try {
			
			app.as_sysUsuMenu_Inserta("SISIMB", tt_Nuevos, ps_Resultado, ps_Texto);
			
			System.out.print(ps_Texto.getStringValue());
		} catch (Exception ex) {

		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}

	}

	@Override
	public void update_sysUsuMenu(sysUsuMenu obj) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<sysUsuMenu> list_sysUsuMenu(String cUsuario , Boolean lTodos) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException, SQLException {
		// TODO Auto-generated method stub
		
		ResultSetHolder tt_sysUsuMenu = new ResultSetHolder();
		StringHolder opcError = new StringHolder();
		BooleanHolder oplError = new BooleanHolder();
		List<sysUsuMenu> Lista = new ArrayList<sysUsuMenu>();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		try {
			
			app.as_sysUsuMenu_Carga(cUsuario, false,  tt_sysUsuMenu, oplError, opcError);
			ResultSet rs_tt_ctMenu = tt_sysUsuMenu.getResultSetValue();
			
		

			while (rs_tt_ctMenu.next()) {				
				
				sysUsuMenu obj = new sysUsuMenu();
				obj.setcUsuario(rs_tt_ctMenu.getString("cUsuario"));
				obj.setiIdMenu(rs_tt_ctMenu.getInt("iIdMenu"));
				obj.setlActivo(rs_tt_ctMenu.getBoolean("lActivo"));
				obj.setcObs(rs_tt_ctMenu.getString("cObs"));
				obj.setcMenu(rs_tt_ctMenu.getString("cMenu"));
				obj.setId(rs_tt_ctMenu.getBytes("Id"));				
				
				
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
	public sysUsuMenu get_sysUsuMenu(int id) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove_sysUsuMenu(String cUsuario , int iMenu) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException {
		// TODO Auto-generated method stub
		
		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		try {

			app.as_sysUsuMenu_Borra("SISIMB", cUsuario, iMenu, oplResultado, opcTexto);

			System.err.println(opcTexto.getValue());
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}
		
	
}
