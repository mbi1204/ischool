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
import com.sinergitec.ischool.dao.ctPuestoDao;
import com.sinergitec.ischool.dao.ctUsuarioDao;
import com.sinergitec.ischool.model.ctPuesto;
import com.sinergitec.ischool.model.ctUsuario;
import com.sinergitec.ischool.util.DBConexion;
import com.sinergitec.ischool.util.VectorResultSet;
@Repository
public class ctUsuarioDaoImp implements ctUsuarioDao {
	@Autowired
	private ctPuestoDao DaoPuesto;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void add_ctUsuario(ctUsuario obj_ctUsuario)
			throws RunTime4GLException, SystemErrorException, Open4GLException,
			IOException {
		// TODO Auto-generated method stub
		List<ctUsuario> ListNuevos = new ArrayList<ctUsuario>();

		ListNuevos.add(obj_ctUsuario);
		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		StringHolder ps_Texto = new StringHolder();
		BooleanHolder ps_Resultado = new BooleanHolder();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		for (ctUsuario obj : ListNuevos) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}
		ResultSetHolder tt_Nuevos = new ResultSetHolder(new VectorResultSet(
				vecTabla1));

		try {
			app.as_ctUsuario_Inserta("SISIMB", tt_Nuevos, ps_Resultado,
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
	public void update_ctUsuario(ctUsuario obj) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException {
		// TODO Auto-generated method stub
		StringHolder ps_Texto = new StringHolder();
		BooleanHolder ps_Resultado = new BooleanHolder();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		vecRow1 = obj.getVectorDatos();
		vecTabla1.add(vecRow1);
		
		
		System.out.println("usuario dao->" + obj.getcUsuario() );

		ResultSet tt_Modificados = new VectorResultSet(vecTabla1);

		try {

			app.as_ctUsuario_Actualiza("SISIMB", tt_Modificados, ps_Resultado,
					ps_Texto);

			System.out.print(ps_Texto.getStringValue());

		} finally {
			// TODO: handle finally clause
			app._release();
			DBConexion.closeConnection(conexion);
		}

	}

	@Override
	public List<ctUsuario> list_ctUsuario() throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException, SQLException {
		// TODO Auto-generated method stub
		System.out.print("entro el dao ctUsuaio");
		ResultSetHolder tt_ctUsuario = new ResultSetHolder();
		
		
		StringHolder opcError = new StringHolder();
		BooleanHolder oplError = new BooleanHolder();
		List<ctUsuario> Lista = new ArrayList<ctUsuario>();
		
		List<ctPuesto> Lista_ctPuesto = new ArrayList<ctPuesto>();
		
		Lista_ctPuesto = DaoPuesto.list_ctPuesto();
		
		
		System.out.println("lista" + Lista_ctPuesto.size());

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);
		
		

		try {
			
		
			app.as_ctUsuario_Carga(true, tt_ctUsuario, oplError, opcError);
			
			
			
				
		
		
			
			ResultSet rs_tt_ctUsuario = tt_ctUsuario.getResultSetValue();
			System.out.println("Registros" + rs_tt_ctUsuario.getRow());

			while (rs_tt_ctUsuario.next()) {
				
				ctUsuario obj = new ctUsuario();

				obj.setcUsuario(rs_tt_ctUsuario.getString("cUsuario"));
				obj.setcNombre(rs_tt_ctUsuario.getString("cNombre"));
				obj.setcPassword(rs_tt_ctUsuario.getString("cPassword"));
				obj.setlActivo(rs_tt_ctUsuario.getBoolean("lActivo"));
				obj.setDtFechaAlta(rs_tt_ctUsuario.getTimestamp("dtFechaAlta"));
				obj.setiIdPuesto(rs_tt_ctUsuario.getInt("iIdPuesto"));
				obj.setId(rs_tt_ctUsuario.getBytes("Id"));
				
				
				for (ctPuesto obj_ctPuesto : Lista_ctPuesto){
					
					if (obj_ctPuesto.getiIdPuesto().equals(obj.getiIdPuesto())){
						System.out.print("entro al for");
						ctPuesto obj_nctPuesto = new ctPuesto();
						obj_nctPuesto.setiIdPuesto(obj_ctPuesto.getiIdPuesto());
						obj_nctPuesto.setcPuesto(obj_ctPuesto.getcPuesto());
						obj.setPuesto(obj_nctPuesto);
						
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
	public ctUsuario get_ctUsuario(String id) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException, SQLException {
		// TODO Auto-generated method stub

		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();

		ResultSetHolder tt_ctUsuario = new ResultSetHolder();
		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);
		ctUsuario obj = new ctUsuario();
		try {

			app.as_ctUsuario_get("SISIMB", id, tt_ctUsuario, oplResultado,
					opcTexto);

			ResultSet rs_tt_ctUsuario = tt_ctUsuario.getResultSetValue();

			while (rs_tt_ctUsuario.next()) {

				obj.setcUsuario(rs_tt_ctUsuario.getString("cUsuario"));
				obj.setcNombre(rs_tt_ctUsuario.getString("cNombre"));
				obj.setcPassword(rs_tt_ctUsuario.getString("cPassword"));
				obj.setlActivo(rs_tt_ctUsuario.getBoolean("lActivo"));
				obj.setDtFechaAlta(rs_tt_ctUsuario.getTimestamp("dtFechaAlta"));
				obj.setiIdPuesto(rs_tt_ctUsuario.getInt("iIdPuesto"));
				obj.setId(rs_tt_ctUsuario.getBytes("Id"));

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
	public void remove_ctUsuario(String  id) throws RunTime4GLException,
			SystemErrorException, Open4GLException, IOException {
		// TODO Auto-generated method stub
		
		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		try {
			
			app.as_ctUsuario_Borra("SISIMB", id, oplResultado, opcTexto);

			System.err.println(opcTexto.getValue());
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}


	}

}
