package com.sinergitec.ischool.dao.ft.imp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.progress.AppServer.AppServer;
import com.progress.open4gl.BooleanHolder;
import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.ResultSetHolder;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.StringHolder;
import com.progress.open4gl.SystemErrorException;
import com.progress.open4gl.dynamicapi.ResultSet;
import com.progress.open4gl.javaproxy.Connection;
import com.sinergitec.ischool.dao.ft.repDetFacturaDao;
import com.sinergitec.ischool.model.ft.ftDetFactura;
import com.sinergitec.ischool.util.DBConexion;

@Service
public class repDetFacturaDaoImp implements repDetFacturaDao {

	@Override
	public List<ftDetFactura> list_ftDetFactura(int iFolio, int iSerie)
			throws RunTime4GLException, SystemErrorException, Open4GLException, IOException, SQLException {
		// TODO Auto-generated method stub
		
		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();		
		ResultSetHolder tt_ftDetFactura = new ResultSetHolder();
		Connection conexion = DBConexion.getConnection();		
		AppServer app = new AppServer(conexion);
		
		List<ftDetFactura> lista = new ArrayList<ftDetFactura>();
		
		try {
			app.as_repDetFactura(iFolio, iSerie, tt_ftDetFactura, oplResultado, opcTexto);
			
			ResultSet rs_tt_ftDetFactura = (ResultSet) tt_ftDetFactura.getResultSetValue();
			
			while(rs_tt_ftDetFactura.next()){
				
				ftDetFactura obj = new ftDetFactura();
				obj.setiFolio(rs_tt_ftDetFactura.getInt("iFolio"));
				obj.setiSerie(rs_tt_ftDetFactura.getInt("iSerie"));
				obj.setiPartida(rs_tt_ftDetFactura.getInt("iPartida"));
				obj.setcConcepto(rs_tt_ftDetFactura.getString("cConcepto"));
				obj.setDeCantidad(rs_tt_ftDetFactura.getBigDecimal("deCantidad"));
				obj.setDeMonto(rs_tt_ftDetFactura.getBigDecimal("deMonto"));
				obj.setDeSubtotal(rs_tt_ftDetFactura.getBigDecimal("deSubTotal"));
				obj.setcClave(rs_tt_ftDetFactura.getString("cClave"));
				lista.add(obj);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lista;
	}

}
