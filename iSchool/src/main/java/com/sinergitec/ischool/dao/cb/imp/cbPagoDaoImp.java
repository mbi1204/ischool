package com.sinergitec.ischool.dao.cb.imp;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Repository;

import com.progress.AppServer.AppServer;
import com.progress.open4gl.BooleanHolder;
import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.ResultSetHolder;
import com.progress.open4gl.StringHolder;
import com.progress.open4gl.javaproxy.Connection;
import com.sinergitec.ischool.dao.cb.cbPagoDao;
import com.sinergitec.ischool.model.cb.cbPago;
import com.sinergitec.ischool.util.DBConexion;
import com.sinergitec.ischool.util.VectorResultSet;
@Repository
public class cbPagoDaoImp implements cbPagoDao {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String add_cbPagos(List<cbPago> List_cbPagos) throws Open4GLException, IOException {
		// TODO Auto-generated method stub
		String vcMensaje = null;

		Vector vecTabla1, vecRow1;
		vecTabla1 = new Vector();

		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		for (cbPago obj : List_cbPagos) {
			vecRow1 = obj.getVectorDatos();
			vecTabla1.add(vecRow1);
		}

		ResultSetHolder ttPagos = new ResultSetHolder(new VectorResultSet(vecTabla1));
		try {

			app.as_cbPagos_Inserta("SISIMB", ttPagos, oplResultado, opcTexto);
			
			vcMensaje = opcTexto.getStringValue();
		} catch (Exception ex) {
			System.err.println(ex);
			vcMensaje = ex.getMessage();

		} finally {
			app._release();
			DBConexion.closeConnection(conexion);

		}

		
		return vcMensaje;
	}

	@Override
	public List<cbPago> list_cbPagoReporte(String ipcCaso, GregorianCalendar ipdtFechaIni,
			GregorianCalendar ipdtFechaFin, String ipcReferencia, String ipcConcepto)
					throws Open4GLException, IOException {
		// TODO Auto-generated method stub
		
		ResultSetHolder tt_cbPago = new ResultSetHolder();

		StringHolder opcError = new StringHolder();
		BooleanHolder oplError = new BooleanHolder();
		List<cbPago> lista = new ArrayList<cbPago>();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);
		
		try {
			app.as_cbPagoReporte(ipcCaso, ipdtFechaIni, ipdtFechaFin, ipcReferencia, ipcConcepto, tt_cbPago, oplError, opcError);
			
			ResultSet rs_tt_cbPago = tt_cbPago.getResultSetValue();
			
			while (rs_tt_cbPago.next()) {
				cbPago obj = new cbPago();
				obj.setiIdPago(rs_tt_cbPago.getInt("iIdPago"));
				obj.setDeMontoPago(rs_tt_cbPago.getBigDecimal("deMontoPago"));
				obj.setlEstado(rs_tt_cbPago.getBoolean("lEstado"));
				obj.setcObs(rs_tt_cbPago.getString("cObs"));
				obj.setDtFechaPago(rs_tt_cbPago.getTimestamp("dtFechaPago"));
				obj.setDtFechaAplicacion(rs_tt_cbPago.getTimestamp("dtFechaAplicacion"));
				obj.setDeMontoXAplicar(rs_tt_cbPago.getBigDecimal("deMontoXAplicar"));
				obj.setiIdAlumno(rs_tt_cbPago.getInt("iIdAlumno"));
				obj.setcReferencia(rs_tt_cbPago.getString("cReferencia"));
				obj.setcConcepto(rs_tt_cbPago.getString("cConcepto"));
				obj.setcDescripcion(rs_tt_cbPago.getString("cDescripcion"));
				obj.setcSucursal(rs_tt_cbPago.getString("cSucursal"));
				obj.setcCuenta(rs_tt_cbPago.getString("cCuenta"));
				obj.setId(rs_tt_cbPago.getBytes("Id"));
				
				lista.add(obj);			
				
			}
			
			System.out.println(opcError.getStringValue());
			
		} catch (Exception e) {
			System.out.print(e);
			lista = null;
		}finally{
			app._release();
			DBConexion.closeConnection(conexion);
		}
		
		return lista;
	}

}
