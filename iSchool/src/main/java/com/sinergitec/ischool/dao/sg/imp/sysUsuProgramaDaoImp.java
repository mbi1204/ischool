package com.sinergitec.ischool.dao.sg.imp;

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
import com.sinergitec.ischool.dao.sg.sysUsuProgramaDao;
import com.sinergitec.ischool.model.sg.ctPrograma;
import com.sinergitec.ischool.model.sg.sysUsuPrograma;
import com.sinergitec.ischool.util.DBConexion;
import com.sinergitec.ischool.util.VectorResultSet;

@Repository
public class sysUsuProgramaDaoImp implements sysUsuProgramaDao {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void add_sysUsuPrograma(sysUsuPrograma obj_sysUsuPrograma) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException {
		// TODO Auto-generated method stub
		
		
		List<sysUsuPrograma> ListNuevos = new ArrayList<sysUsuPrograma>();
		ListNuevos.add(obj_sysUsuPrograma);
		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		StringHolder ps_Texto = new StringHolder();
		BooleanHolder ps_Resultado = new BooleanHolder();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		for (sysUsuPrograma obj : ListNuevos) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}
		ResultSetHolder tt_Nuevos = new ResultSetHolder(new VectorResultSet(
				vecTabla1));

		try {
			
			app.as_sysUsuPrograma_Inserta("SISIMB", tt_Nuevos, ps_Resultado, ps_Texto);
			
			System.out.print(ps_Texto.getStringValue());
		} catch (Exception ex) {

		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}

	}

	@Override
	public void update_sysUsuPrograma(sysUsuPrograma obj) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<sysUsuPrograma> list_sysUsuPrograma(String cUsuario ,int iMenu, Boolean lTodos) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException, SQLException {
		// TODO Auto-generated method stub
		
		ResultSetHolder tt_sysUsuPrograma = new ResultSetHolder();
		StringHolder opcError = new StringHolder();
		BooleanHolder oplError = new BooleanHolder();
		List<sysUsuPrograma> Lista = new ArrayList<sysUsuPrograma>();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		try {
			
			app.as_sysUsuPrograma_Carga(cUsuario,iMenu, false,  tt_sysUsuPrograma, oplError, opcError);
			
			ResultSet rs_tt_sysUsuPrograma = tt_sysUsuPrograma.getResultSetValue();
			
		

			while (rs_tt_sysUsuPrograma.next()) {				
				
				sysUsuPrograma obj = new sysUsuPrograma();
				obj.setcUsuario(rs_tt_sysUsuPrograma.getString("cUsuario"));
				obj.setiIdMenu(rs_tt_sysUsuPrograma.getInt("iIdMenu"));
				obj.setiIdPrograma(rs_tt_sysUsuPrograma.getInt("iIdPrograma"));
				obj.setlActivo(rs_tt_sysUsuPrograma.getBoolean("lActivo"));
				obj.setcObs(rs_tt_sysUsuPrograma.getString("cObs"));
				obj.setcPrograma(rs_tt_sysUsuPrograma.getString("cPrograma"));
				obj.setcNombre(rs_tt_sysUsuPrograma.getString("cNombre"));
				obj.setId(rs_tt_sysUsuPrograma.getBytes("Id"));				
				
				
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
	public sysUsuPrograma get_sysUsuPrograma(int id) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove_sysUsuPrograma(String cUsuario , int iMenu, int iPrograma) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException {
		
		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		try {

			app.as_sysUsuPrograma_Borra("SISIMB", cUsuario, iMenu, iPrograma, oplResultado, opcTexto);

			System.err.println(opcTexto.getValue());
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
		
		
	}

	@Override
	public List<ctPrograma> List_ctProgXctMenu(String cUsuario, int iMenu, boolean lTodos)
			throws RunTime4GLException, SystemErrorException, Open4GLException, IOException, SQLException {
		// TODO Auto-generated method stub

		ResultSetHolder tt_ctPrograma = new ResultSetHolder();
		StringHolder opcError = new StringHolder();
		BooleanHolder oplError = new BooleanHolder();
		List<ctPrograma> Lista = new ArrayList<ctPrograma>();
		

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);
		
		
		
		try {
			app.as_ctProgXctMenu_Carga(cUsuario, iMenu, lTodos, tt_ctPrograma, oplError, opcError);
			ResultSet rs_tt_ctPrograma = tt_ctPrograma.getResultSetValue();

			while (rs_tt_ctPrograma.next()) {

				ctPrograma obj = new ctPrograma();
				obj.setiIdPrograma(rs_tt_ctPrograma.getInt("iIdPrograma"));
				obj.setiIdMenu(rs_tt_ctPrograma.getInt("iIdMenu"));
				obj.setcPrograma(rs_tt_ctPrograma.getString("cPrograma"));
				obj.setlActivo(rs_tt_ctPrograma.getBoolean("lActivo"));
				obj.setcNombre(rs_tt_ctPrograma.getString("cNombre"));
				obj.setId(rs_tt_ctPrograma.getBytes("Id"));
				
				

						

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
		
	
}
