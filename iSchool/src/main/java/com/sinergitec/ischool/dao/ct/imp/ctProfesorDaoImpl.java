package com.sinergitec.ischool.dao.ct.imp;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Timestamp;
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
import com.sinergitec.ischool.model.ct.ctGrupo;
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

		
		for (ctProfesor obj : Lista) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}

		

		ResultSetHolder ttProfesores = new ResultSetHolder(new VectorResultSet(vecTabla1));
		

		try {		
			app.as_ctProfesor_Inserta("SISIMB", ttProfesores, oplResultado, opcTexto);		

			

		} catch (Exception ex) {
			

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
			
			app.as_ctAlumno_Borra("SISIMB", id, oplResultado, opcTexto);
			System.err.println(opcTexto.getValue());
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}

	@Override
	public List<ctProfesor> list_ctProfesor() throws Open4GLException, IOException {

		ResultSetHolder tt_ctProfesor = new ResultSetHolder();
		
		StringHolder opcError = new StringHolder();
		BooleanHolder oplError = new BooleanHolder();
		List<ctProfesor> Lista = new ArrayList<ctProfesor>();
		
		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);
		
		try {
					
			app.as_ctProfesor_Carga(true, tt_ctProfesor, oplError, opcError);

			ResultSet rs_tt_ctProfesor = tt_ctProfesor.getResultSetValue();
			
			while (rs_tt_ctProfesor.next()) {
				
				ctProfesor obj = new ctProfesor();				
			
				
				obj.setiIdProfesor(rs_tt_ctProfesor.getInt("iIdProfesor"));
				obj.setcNombre(rs_tt_ctProfesor.getString("cNombre"));
				obj.setcApellido(rs_tt_ctProfesor.getString("cApellido"));
				obj.setcCalle(rs_tt_ctProfesor.getString("cCalle"));
				obj.setiNumExt(rs_tt_ctProfesor.getString("iNumExt"));
				obj.setiNumInt(rs_tt_ctProfesor.getString("iNumInt"));
				obj.setcColonia(rs_tt_ctProfesor.getString("cColonia"));
				obj.setcCP(rs_tt_ctProfesor.getString("cCP"));
				obj.setcMunicipio(rs_tt_ctProfesor.getString("cMunicipio"));
				obj.setcEdo(rs_tt_ctProfesor.getString("cEdo"));
				obj.setcTelefono(rs_tt_ctProfesor.getString("cTelefono"));
				obj.setlEstatus(rs_tt_ctProfesor.getBoolean("lEstatus"));
				obj.setDtContrato(rs_tt_ctProfesor.getString("dtContrato"));
				obj.setDtFechaNac(rs_tt_ctProfesor.getTimestamp("dtFechaNac"));
				obj.setId(rs_tt_ctProfesor.getBytes("id"));				
				
		
			
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
	public ctProfesor get_ctProfesor(int id) throws Open4GLException, IOException {
		// TODO Auto-generated method stub
		/*BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();

		ResultSetHolder tt_ctprofesor = new ResultSetHolder();
		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);
		ctGrupo obj = new ctGrupo();
		System.out.println("Truena aqui un paso antes de la conexion a BD");
		try {
			
			app.as_ctProfesor_get("SISIMB", id, tt_ctprofesor, oplResultado, opcTexto);
			
			ResultSet rs_tt_ctGrupo = tt_ctGrupo.getResultSetValue();

			while (rs_tt_ctGrupo.next()) {
				
				obj.setiIdGrupo(rs_tt_ctGrupo.getInt("iIdGrupo"));
				obj.setcNomGrupo(rs_tt_ctGrupo.getString("cNomGrupo"));
				obj.setiIdCur(rs_tt_ctGrupo.getInt("iIdCur"));
				obj.setiIdProfesor(rs_tt_ctGrupo.getInt("iIdProfesor"));
				obj.setDtHorario(rs_tt_ctGrupo.getString("dtHorario"));
				 
				obj.setId(rs_tt_ctGrupo.getBytes("id"));

			}
			
		} catch (Exception ex) {
			System.err.println(ex);

			
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
		*/
		return null;
	}
}
