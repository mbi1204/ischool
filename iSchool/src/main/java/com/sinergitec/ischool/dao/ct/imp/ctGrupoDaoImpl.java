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
import com.sinergitec.ischool.dao.ct.ctGrupoDao;
import com.sinergitec.ischool.model.ct.ctCurso;
import com.sinergitec.ischool.model.ct.ctGrupo;
import com.sinergitec.ischool.model.ct.ctProfesor;
import com.sinergitec.ischool.util.DBConexion;
import com.sinergitec.ischool.util.VectorResultSet;

@Repository
public class ctGrupoDaoImpl implements ctGrupoDao {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void add_ctGrupo(ctGrupo obj_Grupo) throws Open4GLException, IOException {

		List<ctGrupo> Lista = new ArrayList<ctGrupo>();

		Lista.add(obj_Grupo);

		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

	
		for (ctGrupo obj : Lista) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}

		ResultSetHolder ttGrupos = new ResultSetHolder(new VectorResultSet(vecTabla1));
		try {

			app.as_ctGrupo_Inserta("SISIMB", ttGrupos, oplResultado, opcTexto);			

		} catch (Exception ex) {
			System.err.println(ex);

		} finally {
			app._release();
			DBConexion.closeConnection(conexion);

		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void update_ctGrupo(ctGrupo obj_Grupo) throws Open4GLException, IOException {

		List<ctGrupo> Lista = new ArrayList<ctGrupo>();
		Lista.add(obj_Grupo);

		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();
		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		for (ctGrupo e : Lista) {
			vecRow1 = e.getVectorDatos();
			vecTabla1.add(vecRow1);
		}

		ResultSet gruposModificados = new VectorResultSet(vecTabla1);

		try {
			app.as_ctGrupo_Actualiza("SISIMB", gruposModificados, oplResultado, opcTexto);
		

		} finally {
			// TODO: handle finally clause
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}

	public void remove_ctGrupo(int id) throws Open4GLException, IOException {

		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		try {
			
			app.as_ctGrupo_Borra("SISIMB", id, oplResultado, opcTexto);
			System.err.println(opcTexto.getValue());
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}

public List<ctGrupo> list_ctGrupo() throws Open4GLException, IOException{
		
		ResultSetHolder tt_ctGrupo = new ResultSetHolder();
		
		StringHolder opcError = new StringHolder();
		BooleanHolder oplError = new BooleanHolder();
		List<ctGrupo> Lista = new ArrayList<ctGrupo>();
		
		List<ctProfesor> Lista_ctProfesor = new ArrayList<ctProfesor>();
		
		List<ctCurso> Lista_ctCurso = new ArrayList<ctCurso>();
		
		
		

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);
		
		try {
			
		
			app.as_ctGrupo_Carga(true, tt_ctGrupo, oplError, opcError);

			ResultSet rs_tt_ctGrupo = tt_ctGrupo.getResultSetValue();
			

			while (rs_tt_ctGrupo.next()) {
				
				ctGrupo obj = new ctGrupo();

				obj.setiIdGrupo(rs_tt_ctGrupo.getInt("iIdGrupo"));
				obj.setcNomGrupo(rs_tt_ctGrupo.getString("cNombre"));
				obj.setiIdCur(rs_tt_ctGrupo.getInt("iIdCurso"));
				obj.setiIdProfesor(rs_tt_ctGrupo.getInt("iIdProfesor"));
				obj.setDtHorario(rs_tt_ctGrupo.getString("dtHorario"));
				obj.setId(rs_tt_ctGrupo.getBytes("Id"));
				
				for(ctProfesor obj_ctProfesor : Lista_ctProfesor){
					if(obj_ctProfesor.getiIdProfesor().equals(obj.getiIdProfesor())){
						
						ctProfesor obj2 = new ctProfesor();
						
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

	public ctGrupo get_ctGrupo(int g) throws Open4GLException, IOException{
		
		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();

		ResultSetHolder tt_ctGrupo = new ResultSetHolder();
		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);
		ctGrupo obj = new ctGrupo();

		try {
			
			app.as_ctGrupo_get("SISIMB", g, tt_ctGrupo, oplResultado, opcTexto);
			
			ResultSet rs_tt_ctGrupo = tt_ctGrupo.getResultSetValue();

			while (rs_tt_ctGrupo.next()) {
				
				obj.setiIdGrupo(rs_tt_ctGrupo.getInt("iIdGrupo"));
				obj.setcNomGrupo(rs_tt_ctGrupo.getString("cNombre"));
				obj.setiIdCur(rs_tt_ctGrupo.getInt("iIdCurso"));
				obj.setiIdProfesor(rs_tt_ctGrupo.getInt("iIdProfesor"));
				obj.setDtHorario(rs_tt_ctGrupo.getString("dtHorario"));
				 /* 
				 * 
				 * Por el momento comento esta linea, NOTA: Investigar como 
				 * se manejan los horarios en progress y como hacer un tipo
				 * calendario para que eligan los dias que toque clase asi
				 * como la hora :)*/
				obj.setId(rs_tt_ctGrupo.getBytes("id"));

			}
			
		} catch (Exception ex) {
			System.err.println(ex);

			
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
		
		return obj;
	}
}