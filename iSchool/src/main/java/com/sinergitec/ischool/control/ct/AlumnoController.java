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
				
		return "ctAlumno";
	}
	
	 @RequestMapping(value= "/ctAlumno/add", method = RequestMethod.POST)
	    public String addPerson(@ModelAttribute("ctAlumno") ctAlumno obj) throws RunTime4GLException, SystemErrorException, Open4GLException, IOException{	   	 	
	    	
	    	
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
	         
	        return "ctAlumno";
	         
	    }

	    @RequestMapping(value = "/edit/{cNombre}")
	    public String editPerson(@PathVariable("cNombre") String cCveCia, Model modelo){
	    	
	    	//this.alumnoService.eliminarAlumno(iCliente);
	        
	        return "ctAlumno";
	    }
	    
	    @RequestMapping(value= "/remove/{cCveCia},{iCliente}" , method= RequestMethod.GET)
		public String doActions (@PathVariable("cCveCia") String cCveCia,
				@PathVariable("iCliente") int iCliente , Model modelo){
			
			//this.alumnoService.eliminarAlumno(iCliente);

			  return "ctAlumno";
		}
}
