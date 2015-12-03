package com.sinergitec.ischool.dao.ft.imp;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.progress.AppServer.AppServer;
import com.progress.open4gl.BooleanHolder;
import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.ResultSetHolder;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.StringHolder;
import com.progress.open4gl.SystemErrorException;
import com.progress.open4gl.dynamicapi.ResultSet;
import com.progress.open4gl.javaproxy.Connection;
import com.sinergitec.ischool.dao.ft.GeneraCfdiDao;
import com.sinergitec.ischool.model.ft.CFDI;
import com.sinergitec.ischool.util.DBConexion;

@Repository
public class GeneraCfdiDaoImp implements GeneraCfdiDao {

	@Override
	public String generaCfdi(int viSerie, int viFolio)
			throws RunTime4GLException, SystemErrorException, Open4GLException, IOException, SQLException {
		// TODO Auto-generated method stub

		String vcMensage = null;

		StringHolder opcError = new StringHolder();
		BooleanHolder oplError = new BooleanHolder();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		try {
			app.as_CFDI_Genera(viSerie, viFolio, oplError, opcError);
			vcMensage = opcError.getStringValue();

		} catch (Exception ex) {
			vcMensage = ex.getMessage();
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
		return vcMensage;
	}

	@Override
	public CFDI getCFDI(int viSerie, int viFolio ,String cOpcion)
			throws RunTime4GLException, SystemErrorException, Open4GLException, IOException, SQLException {
		// TODO Auto-generated method stub

		String vcMensage = null;

		StringHolder opcError = new StringHolder();
		BooleanHolder oplError = new BooleanHolder();
		ResultSetHolder tt_CFD = new ResultSetHolder();
		CFDI obj = new CFDI ();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		try {
			
			app.as_getCFDI(viSerie, viFolio, cOpcion, tt_CFD, oplError, opcError);
			ResultSet rs_tt_CFD = (ResultSet) tt_CFD.getResultSetValue();
			
			while(rs_tt_CFD.next()){
				
				obj.setCveEmpresa( rs_tt_CFD.getString("CveEmpresa"));
				obj.setSolicitud(rs_tt_CFD.getInt("Solicitud"));
				obj.setSerie(rs_tt_CFD.getString("Serie"));		
				obj.setFolio(rs_tt_CFD.getInt("Folio"));
				obj.setUUID(rs_tt_CFD.getString("UUID"));
				obj.setFechaHora(rs_tt_CFD.getTimestamp("FechaHora"));
				obj.setXML(rs_tt_CFD.getBytes("XML"));
				obj.setPDF(rs_tt_CFD.getBytes("PDF"));
				obj.setCveGenerado(rs_tt_CFD.getString("CveGenerado"));		
				obj.setCancelado(rs_tt_CFD.getTimestamp("Cancelado"));
				obj.setCveCancelado(rs_tt_CFD.getString("CveCancelado"));
				obj.setMotivo(rs_tt_CFD.getString("motivo"));
				obj.setXMLCancela(rs_tt_CFD.getBytes("xMLCancela"));
				obj.setId(rs_tt_CFD.getBytes("id"));
				System.out.println("barrido" + obj.toString());
			}

			vcMensage = opcError.getStringValue();

		} catch (Exception ex) {
			System.out.println(ex);
			vcMensage = ex.getMessage();
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
		
		
		
				

		return obj;
	}

}
