package com.sinergitec.ischool.dao.ct.imp;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.progress.AppServer.AppServer;

import com.progress.open4gl.BooleanHolder;
import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.ResultSetHolder;
import com.progress.open4gl.StringHolder;
import com.progress.open4gl.javaproxy.Connection;
import com.sinergitec.ischool.dao.ct.ctCursoDao;

import com.sinergitec.ischool.dao.ct.ctGrupoDisponibleDao;

import com.sinergitec.ischool.model.ct.ctCurso;
import com.sinergitec.ischool.model.ct.ctGrupo;

import com.sinergitec.ischool.util.DBConexion;


@Repository
public class ctGrupoDisponibleDaoImpl implements ctGrupoDisponibleDao {
	
	@Autowired
	private ctCursoDao ctCursoDao;
	

public List<ctGrupo> list_ctGrupo() throws Open4GLException, IOException{
		
		ResultSetHolder tt_ctGrupo = new ResultSetHolder();
		
		StringHolder opcError = new StringHolder();
		BooleanHolder oplError = new BooleanHolder();
		
		List<ctGrupo> Lista = new ArrayList<ctGrupo>();
		List<ctCurso> List_ctCurso = new ArrayList<ctCurso>();
		List_ctCurso = ctCursoDao.list_ctCurso();	
		
		
		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);
		
		try {			
			
			app.as_ctGrupoDisponible_Carga(true, tt_ctGrupo, oplError, opcError);

			ResultSet rs_tt_ctGrupo = tt_ctGrupo.getResultSetValue();
			

			while (rs_tt_ctGrupo.next()) {
				
				ctGrupo obj = new ctGrupo();

				obj.setiIdGrupo(rs_tt_ctGrupo.getInt("iIdGrupo"));
				obj.setcNombre(rs_tt_ctGrupo.getString("cNombre"));
				obj.setiIdCurso(rs_tt_ctGrupo.getInt("iIdCurso"));
				obj.setiIdProfesor(rs_tt_ctGrupo.getInt("iIdProfesor"));
				obj.setcDias(rs_tt_ctGrupo.getString("cDias"));
				obj.setcHorario(rs_tt_ctGrupo.getString("cHorario"));
				obj.setlHabilitado(rs_tt_ctGrupo.getBoolean("lHabilitado"));
				obj.setId(rs_tt_ctGrupo.getBytes("dao"));
				System.out.println(obj.getcNombre());
				
				
				for(ctCurso obj_ctCurso : List_ctCurso){
					
					
					if(obj_ctCurso.getiIdCurso().equals(obj.getiIdCurso())){
						
						ctCurso obj_nctCurso = new ctCurso();
						obj_nctCurso.setiIdCurso(obj_ctCurso.getiIdCurso());
						obj_nctCurso.setcNombre(obj_ctCurso.getcNombre());
						obj_nctCurso.setDePrecio(obj_ctCurso.getDePrecio());
						obj.setCurso(obj_nctCurso);
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
	
	List<ctCurso> List_ctCurso = new ArrayList<ctCurso>();
	List_ctCurso = ctCursoDao.list_ctCurso();
	

	

	try {
		
		app.as_ctGrupo_get("SISIMB", g, tt_ctGrupo, oplResultado, opcTexto);
		
		ResultSet rs_tt_ctGrupo = tt_ctGrupo.getResultSetValue();			
		
		while (rs_tt_ctGrupo.next()) {
			obj.setiIdGrupo(rs_tt_ctGrupo.getInt("iIdGrupo"));
			obj.setcNombre(rs_tt_ctGrupo.getString("cNombre"));
			obj.setiIdCurso(rs_tt_ctGrupo.getInt("iIdCurso"));
			obj.setiIdProfesor(rs_tt_ctGrupo.getInt("iIdProfesor"));
			obj.setcDias(rs_tt_ctGrupo.getString("cDias"));
			obj.setcHorario(rs_tt_ctGrupo.getString("cHorario"));
			obj.setlHabilitado(rs_tt_ctGrupo.getBoolean("lHabilitado"));
			obj.setId(rs_tt_ctGrupo.getBytes("Id"));
			

			for(ctCurso obj_ctCurso : List_ctCurso){
				
				
				if(obj_ctCurso.getiIdCurso().equals(obj.getiIdCurso())){
					
					ctCurso obj_nctCurso = new ctCurso();
					obj_nctCurso.setiIdCurso(obj_ctCurso.getiIdCurso());
					obj_nctCurso.setcNombre(obj_ctCurso.getcNombre());
					obj_nctCurso.setDePrecio(obj_ctCurso.getDePrecio());
					obj.setCurso(obj_nctCurso);
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
	
}
