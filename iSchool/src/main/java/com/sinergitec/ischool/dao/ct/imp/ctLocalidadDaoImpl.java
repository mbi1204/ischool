package com.sinergitec.ischool.dao.ct.imp;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.progress.AppServer.AppServer;
import com.progress.open4gl.BooleanHolder;
import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.ResultSetHolder;
import com.progress.open4gl.StringHolder;
import com.progress.open4gl.javaproxy.Connection;
import com.sinergitec.ischool.dao.ct.ctLocalidadDao;
import com.sinergitec.ischool.model.ct.ctLocalidad;
import com.sinergitec.ischool.util.DBConexion;

@Repository
public class ctLocalidadDaoImpl implements ctLocalidadDao {
	
	public List<ctLocalidad> list_ctLocalidad(String cP) throws Open4GLException, IOException{
		
		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();

		ResultSetHolder tt_ctLocalidad = new ResultSetHolder();
		Connection conexion = DBConexion.getConnection();
		
		AppServer app = new AppServer(conexion);
		List<ctLocalidad> Lista = new ArrayList<ctLocalidad>();
		
		try {
		
		app.as_ctLocalidades_carga(cP, tt_ctLocalidad, oplResultado, opcTexto);

		ResultSet rs_tt_ctLocalidad = tt_ctLocalidad.getResultSetValue();
		
		
			while(rs_tt_ctLocalidad.next()){
				
				ctLocalidad obj = new ctLocalidad();
				obj.setcLocalidad(rs_tt_ctLocalidad.getString("cLocalidad"));
				obj.setcCP(rs_tt_ctLocalidad.getString("cCP"));
				obj.setcCiudad(rs_tt_ctLocalidad.getString("cCiudad"));
				obj.setcMunicipio(rs_tt_ctLocalidad.getString("cMunicipio"));
				obj.setcEstado(rs_tt_ctLocalidad.getString("cEstado"));
				obj.setcNomMunicipio(rs_tt_ctLocalidad.getString("cNomMunicipio"));
				obj.setcNomEstado(rs_tt_ctLocalidad.getString("cNomEstado"));
				obj.setId(rs_tt_ctLocalidad.getBytes("Id"));
				
				Lista.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Lista;		
	}
}
