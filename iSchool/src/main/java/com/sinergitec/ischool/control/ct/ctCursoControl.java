package com.sinergitec.ischool.control.ct;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.RunTime4GLException;
import com.progress.open4gl.SystemErrorException;
import com.sinergitec.ischool.model.ct.ctCurso;
import com.sinergitec.ischool.service.ct.ctCursoService;

@Controller
public class ctCursoControl {

	@Autowired
	private ctCursoService ctCursoService;
	
	@RequestMapping(value = "/Curso", method = RequestMethod.GET)
	public String curso(Locale locale, Model model) {
		
		
		return "curso";
	}
	
	@RequestMapping(value = "/ctCurso", method = RequestMethod.GET)
	public String cursoLista(Model model) throws Open4GLException, IOException {
		
		model.addAttribute("ctCurso", new ctCurso());
		model.addAttribute("lista_ctCurso", this.ctCursoService.list_ctCurso());

		return "ctCurso_List";
	}
	
	@RequestMapping(value= "/ctCurso/add", method = RequestMethod.POST)
    public String cursoRegistro(@ModelAttribute("ctCurso") ctCurso c, ModelMap model) throws RunTime4GLException, SystemErrorException, Open4GLException, IOException{
    	
        if(c.getiIdCurso() == 0){
            //new person, add it
			try {
				
				this.ctCursoService.add_ctCurso(c);
			} catch (Open4GLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            
        }else{
            //existing person, call update
        	this.ctCursoService.update_ctCurso(c);
           
        }
         
        return "redirect:/ctCurso";
         
    }
	
	@RequestMapping("/ctCurso/get/{id}")
	public String get_ctCurso(@PathVariable("id") int id,	Model model) throws RunTime4GLException, SystemErrorException, Open4GLException, IOException, SQLException {

		model.addAttribute("ctCurso", this.ctCursoService.get_Curso(id));		

		return "ctCurso_Form";

	}
	
	
	 @RequestMapping("/ctCurso/edit/{id}")
	    public String edit_ctCurso(@PathVariable("id") int id, Model model) throws RunTime4GLException, SystemErrorException, Open4GLException, IOException, SQLException{
		 
	        model.addAttribute("ctCurso", this.ctCursoService.get_Curso(id));
	        model.addAttribute("lista_ctPuesto", this.ctCursoService.list_ctCurso());
	        return "redirect:/ctCurso";
	    }
	 
	 @RequestMapping("/ctCurso/remove/{id}")
		public String remove_ctCurso(@PathVariable("id") int id) throws Open4GLException, IOException {

			this.ctCursoService.remove_ctCurso(id);
			return "redirect:/ctCurso";
		}
}
