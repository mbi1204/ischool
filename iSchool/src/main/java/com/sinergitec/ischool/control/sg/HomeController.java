package com.sinergitec.ischool.control.sg;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sinergitec.ischool.model.sg.ctUsuario;
import com.sinergitec.ischool.service.imp.sg.ctUsuarioServiceImp;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({"List_ctMenu" ,"List_ctPrograma"} )



public class HomeController {
	
	@Autowired
	private ctUsuarioServiceImp ctUsuarioserv;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("ctUsuario", new ctUsuario() );
		
		return "home";
	}
	
	
	@RequestMapping(value= "/Login", method = RequestMethod.POST)
    public String cursoRegistro(@ModelAttribute("ctUsuario") ctUsuario  obj_ctUsuario, ModelMap model){		
	
		String vcRespuesta ;
		
		vcRespuesta = ctUsuarioserv.get_login(obj_ctUsuario);
		List<List>   lista      = new ArrayList<List>();
				
		
		if (vcRespuesta.equals("") ){
			
			lista = ctUsuarioserv.getAllMenu(obj_ctUsuario.getcUsuario());
			
			model.addAttribute("List_ctMenu", lista.get(0) );
			model.addAttribute("List_ctPrograma", lista.get(1) );
			
		
			return "sysUsuMenu";
			
		}else {
			
			model.addAttribute("ctUsuario", new ctUsuario() );
			model.addAttribute("vcRespuesta", vcRespuesta );
							
			return "home";
		}	
	
	}
   
	
}
