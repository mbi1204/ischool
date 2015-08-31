package com.sinergitec.ischool.control;

import java.io.IOException;

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
import com.sinergitec.ischool.model.ct.ctGrupo;
import com.sinergitec.ischool.service.ct.ctGrupoService;

@Controller
public class ctGrupoControl {
	
	@Autowired
	private ctGrupoService ctGrupoService;
	
	@RequestMapping(value = "/grupo/adm/", method = RequestMethod.GET)
	public String grupo(Model model) throws Open4GLException, IOException{
		
		model.addAttribute("Grupo", new ctGrupo());
		model.addAttribute("lista_ctGrupo", this.ctGrupoService.list_ctGrupo());
		return"grupoLista";
	}
	
	@RequestMapping(value= "/ctGrupo/add", method = RequestMethod.POST)
    public String agregarGrupo(@ModelAttribute("Grupo") ctGrupo g) throws RunTime4GLException, SystemErrorException, Open4GLException, IOException{
    	
        if(g.getiIdGrupo() == 0){
            //new person, add it
        	System.out.println(g.toString());
        	
        	
			this.ctGrupoService.add_ctGrupo(g);
            
        }else{
            //existing person, call update
           this.ctGrupoService.update_ctGrupo(g);
        }
         
        return "redirect:/grupo/adm/";
         
    }
	
	@RequestMapping("/grupo/adm/eliminar/{id}")
	public String eliminarGrupo(@PathVariable("id") int grupo) throws Open4GLException, IOException {

		this.ctGrupoService.remove_ctGrupo(grupo);
		return "redirect:/grupo/adm/";
	}

	@RequestMapping("/grupo/adm/get/{id}")
	public String get_ctGrupo(@PathVariable("id") int id,
			Model model) throws Open4GLException, IOException {

		model.addAttribute("Grupo", this.ctGrupoService.get_Grupo(id));
		//model.addAttribute("actionUrl", "edit_ctUsuario/");
		//model.addAttribute("lista_ctGrupo", this.grupoService.list_ctGrupo());

		return "grupo";

	}

	@RequestMapping(value = "/grupo/adm/editar/{grupo}", method = RequestMethod.POST)
	public String editarGrupo(@PathVariable("id") int g, Model moldel) throws Open4GLException, IOException {
		
		/*java.util.Date date = new java.util.Date();
		obj.setDtFechaAlta(new Timestamp(date.getTime()));*/
		
		moldel.addAttribute("Grupo",this.ctGrupoService.get_Grupo(g));
		return "redirect:/grupo/adm/";
	}
}
