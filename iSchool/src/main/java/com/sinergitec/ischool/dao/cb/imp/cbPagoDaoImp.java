package com.sinergitec.ischool.dao.cb.imp;

import java.io.IOException;
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

}
