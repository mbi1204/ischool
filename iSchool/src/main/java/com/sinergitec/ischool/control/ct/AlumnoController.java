package com.sinergitec.ischool.control.ct;

import java.io.IOException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.model.ct.ctAlumno;
import com.sinergitec.ischool.service.ct.ctAlumnoService;

@Controller
public class AlumnoController {

	@Autowired
	private ctAlumnoService alumnoService;
	
	@RequestMapping(value = "/ctAlumno", method = RequestMethod.GET)
	public String alumno(Locale locale, Model model) {
		
		
		return "alumno";
	}
	
	 @RequestMapping(value= "/ctAlumno/add", method = RequestMethod.POST)
	    public String addPerson(@ModelAttribute("alumno") ctAlumno obj) throws RunTime4GLException, SystemErrorException, Open4GLException, IOException{
	   	 	/*
	   	 	 * Se comprueba que si inserta el programa
	   	 	 * 
	   	 	 * Se comprueba que si borra el programa
	   	 	 * this.alumnoService.eliminarAlumno(2);
	   	 	 * 
	   	 	 *  Se comprueba que si realiza los cambios
	   	 	 *  a.setiIdAlumno(4);
	    		a.setcNombre("Pepe y Tono");
	    		a.setcApellido("Mariana y Sofia");
	    		a.setDtFechaNac("1992-08-18");
	    		a.setcCalle("Munjica");
	    		a.setcNumExt("62");
	    		a.setcNumInt("s/n");
	    		a.setcColonia("Pedro");
	    		a.setcCP("12345");
	    		a.setcMunicipio("Naucalpan");
	    		a.setcEstado("Edo Mex");
	    		a.setcTel("55486621");
	    		a.setlEstatus(true);
	    	
	    		System.out.println("Entra a la edicion");
	    		this.alumnoService.editarAlumno(a);
	    		
	    		NOTA; SE PUEDEN HACER DOS COSAS PARA LA FECHA DE INSCRIPCION:
	    		1.- DIRECTAMENTE EN EL SERVIDOR INDICAR QUE SE TOME LA HORA ACTUAL
	    		2.- EXCLUIR DE CAMBIO AL CAMPO DE FECHA DE INSCRIPCION
	    		*/
	    	
	    	
	        if(obj.getiIdAlumno() == 0){
	            //new person, add it
				try {
					
					this.alumnoService.add_ctAlumno(obj);
				} catch (Open4GLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	        }else{
	            //existing person, call update
	           
	        }
	         
	        return "alumno";
	         
	    }

	    @RequestMapping(value = "/edit/{cNombre}")
	    public String editPerson(@PathVariable("cNombre") String cCveCia, Model modelo){
	    	
	    	//this.alumnoService.eliminarAlumno(iCliente);
	        
	        return "alumno";
	    }
	    
	    @RequestMapping(value= "/remove/{cCveCia},{iCliente}" , method= RequestMethod.GET)
		public String doActions (@PathVariable("cCveCia") String cCveCia,
				@PathVariable("iCliente") int iCliente , Model modelo){
			
			//this.alumnoService.eliminarAlumno(iCliente);

			  return "alumno";
		}
}
