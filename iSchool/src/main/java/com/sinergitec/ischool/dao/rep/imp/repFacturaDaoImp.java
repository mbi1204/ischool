package com.sinergitec.ischool.dao.rep.imp;

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
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.StringHolder;
import com.progress.open4gl.SystemErrorException;
import com.progress.open4gl.javaproxy.Connection;
import com.sinergitec.ischool.dao.rep.repFacturaDao;
import com.sinergitec.ischool.model.ft.ftFacturaAlumno;
import com.sinergitec.ischool.util.DBConexion;

@Repository
public class repFacturaDaoImp implements repFacturaDao{

	@Override
	public List<ftFacturaAlumno> list_ftFactura(int idGrupo)
			throws RunTime4GLException, SystemErrorException, Open4GLException, IOException, SQLException {
		// TODO Auto-generated method stub
		
		ResultSetHolder tt_ftFactura = new ResultSetHolder();

		StringHolder opcError = new StringHolder();
		BooleanHolder oplError = new BooleanHolder();
		List<ftFacturaAlumno> Lista = new ArrayList<ftFacturaAlumno>();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);
		
		try {
			
			app.as_repFactura(idGrupo, tt_ftFactura, oplError, opcError);
			
			ResultSet rs_tt_ftFactura = tt_ftFactura.getResultSetValue();
			
			while (rs_tt_ftFactura.next()) {

				ftFacturaAlumno obj = new ftFacturaAlumno();			
				
				obj.setiFolio((rs_tt_ftFactura.getInt("iFolio")));
				obj.setiSerie((rs_tt_ftFactura.getInt("iSerie")));
				obj.setDtFecha((rs_tt_ftFactura.getTimestamp("dtFecha")));
				obj.setlActivo((rs_tt_ftFactura.getBoolean("lActivo")));
				obj.setDeSubtotal(rs_tt_ftFactura.getBigDecimal("deSubtotal"));
				obj.setDeIVA(rs_tt_ftFactura.getBigDecimal("deIVA"));
				obj.setDeTotal(rs_tt_ftFactura.getBigDecimal("deTotal"));
				obj.setDeDescPorc((rs_tt_ftFactura.getBigDecimal("deDescPorc")));
				obj.setDeDescMonto(rs_tt_ftFactura.getBigDecimal("deDescMonto"));
				obj.setiIdAlumno((rs_tt_ftFactura.getInt("iIdAlumno")));
				obj.setDtFechaCancel((rs_tt_ftFactura.getTimestamp("dtFechaCancel")));
				obj.setDeSaldo((rs_tt_ftFactura.getBigDecimal("deSaldo")));
				obj.setcNombre(rs_tt_ftFactura.getString("cNombre"));
				obj.setcApellido(rs_tt_ftFactura.getString("cApellido"));
				obj.setcSerie(rs_tt_ftFactura.getString("cSerie"));
				obj.setId(rs_tt_ftFactura.getBytes("Id"));			

				Lista.add(obj);
			}
			
			System.out.println(opcError.getStringValue());
			
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
