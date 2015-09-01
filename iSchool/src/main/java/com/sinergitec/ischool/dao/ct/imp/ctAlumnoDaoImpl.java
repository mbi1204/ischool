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
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.StringHolder;
import com.progress.open4gl.SystemErrorException;
import com.progress.open4gl.javaproxy.Connection;
import com.sinergitec.ischool.dao.ct.ctAlumnoDao;
import com.sinergitec.ischool.model.ct.ctAlumno;
import com.sinergitec.ischool.util.DBConexion;
import com.sinergitec.ischool.util.VectorResultSet;

@Repository
public class ctAlumnoDaoImpl implements ctAlumnoDao {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void add_ctAlumno(ctAlumno obj) throws Open4GLException, IOException{	
			
		List<ctAlumno> Lista = new ArrayList<ctAlumno>();	
		Lista.add(obj);				
		
		Vector vecTabla1, vecRow1;
        vecTabla1 = new Vector();       
        
        BooleanHolder oplResultado = new BooleanHolder();
        StringHolder opcTexto = new StringHolder();
        
        Connection conexion = DBConexion.getConnection();
        AppServer app = new AppServer(conexion);
              
        for(ctAlumno obj_ctAlumno : Lista){
        	vecRow1 = obj_ctAlumno.getVectorDatos();
        	vecTabla1.add(vecRow1);
        }      
              
        ResultSetHolder ttAlumnos = new ResultSetHolder(new VectorResultSet(vecTabla1));      
        
        try {	
        	app.as_ctAlumno_Inserta("SISIMB",  ttAlumnos, oplResultado, opcTexto);
        	
            System.out.println(opcTexto.getValue());
            System.out.println(oplResultado.getValue());
            

        } catch (Exception ex) {
            System.err.println(ex);

        } finally {
            app._release();
            DBConexion.closeConnection(conexion);

        }
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void update_ctAlumno(ctAlumno obj_ctAlumno) throws Open4GLException, IOException{
		
		List<ctAlumno> Lista_Update = new ArrayList<ctAlumno>();
		Lista_Update.add(obj_ctAlumno);
		
		BooleanHolder oplResultado = new BooleanHolder();
        StringHolder opcTexto = new StringHolder();
		Connection conexion = DBConexion.getConnection();
        AppServer app = new AppServer(conexion);
        
        Vector vecTabla1, vecRow1;
        vecTabla1 = new Vector();
        
        for(ctAlumno obj : Lista_Update){
        	vecRow1 = obj.getVectorDatos();
        	vecTabla1.add(vecRow1);
        }
        
        ResultSet alumnosModificados = new VectorResultSet(vecTabla1); 
        
        try {
        	app.as_ctAlumno_Actualiza("SISIMB", alumnosModificados, oplResultado, opcTexto);
            System.out.print(opcTexto.getValue()+" Y el Resultado "+oplResultado.getValue());
			
		} finally {
			// TODO: handle finally clause
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}
	
	public void remove_ctAlumno(int id) throws RunTime4GLException, SystemErrorException, Open4GLException, IOException{
		
		BooleanHolder oplResultado = new BooleanHolder();
		StringHolder opcTexto = new StringHolder();

		Connection conexion = DBConexion.getConnection();
		AppServer app = new AppServer(conexion);

		try {		
			System.out.println("Entro al metodo eliminar");
			app.as_ctAlumno_Borra("SISIMB", id , oplResultado, opcTexto);
			System.err.println(opcTexto.getValue());
		} finally {
			app._release();
			DBConexion.closeConnection(conexion);
		}
	}
}