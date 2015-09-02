package com.sinergitec.ischool.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sinergitec.ischool.model.sg.ctPrograma;
import com.sinergitec.ischool.model.sg.ctUsuario;
import com.sinergitec.ischool.model.sg.sysUsuMenu;
import com.sinergitec.ischool.model.sg.sysUsuPrograma;
import com.sinergitec.ischool.service.ctMenuService;
import com.sinergitec.ischool.service.ctProgramaService;
import com.sinergitec.ischool.service.sysUsuMenuService;
import com.sinergitec.ischool.service.sysUsuProgramaService;
import com.sinergitec.ischool.service.ctUsuarioService;

@Controller
public class sysUsuMenu_Control {
	@Autowired
	private ctUsuarioService serv;
	@Autowired
	private ctMenuService servMenu;
	@Autowired
	private sysUsuMenuService servSysMenu;
	@Autowired
	private ctProgramaService serviPrograma;
	@Autowired
	private sysUsuProgramaService serviSysPrograma; 
	
	

	@RequestMapping(value = "/configUsuario", method = RequestMethod.GET)
	public String list_configUsuario(Model model) {

		model.addAttribute("ctUsuario", new ctUsuario());
		model.addAttribute("sysUsuMenu" , new sysUsuMenu());
		model.addAttribute("sysUsuprograma" , new sysUsuPrograma());		
		model.addAttribute("lista_ctUsuario", this.serv.list_ctUsuario());
		model.addAttribute("lista_ctMenu", this.servMenu.list_ctMenu());

		return "sysUsuMenu_List";
				
	}

	@RequestMapping(value = "/BuscaMenu", headers = "Accept=application/json")
	public @ResponseBody List<sysUsuMenu> BuscaMenu(String cUsuario, Model model) {
		List<sysUsuMenu> lista = new ArrayList<sysUsuMenu>();
		lista = this.servSysMenu.list_sysUsuMenu(cUsuario, true);	
	
		return lista;

	}
	
	
	
	@RequestMapping(value = "/sysUsuMenu/add")
	public  @ResponseBody List<sysUsuMenu> add_sysUsuMenu(String cUsuario , int iIdMenu,		
			ModelMap model) {
		
		
		sysUsuMenu obj = new sysUsuMenu();
		
		obj.setcUsuario(cUsuario);
		obj.setiIdMenu(iIdMenu);
		obj.setlActivo(true);
		this.servSysMenu.add_sysUsuMenu(obj);
		List<sysUsuMenu> lista = new ArrayList<sysUsuMenu>();
		lista = this.servSysMenu.list_sysUsuMenu(cUsuario, true);
		
		return lista;

	}
	
	
	@RequestMapping(value = "/sysUsuPrograma/add")
	public  @ResponseBody List<sysUsuPrograma> add_sysUsuPrograma(
			String cUsuario , int iIdMenu,int iIdPrograma,ModelMap model) {
		
		
		sysUsuPrograma obj = new sysUsuPrograma();
		
		obj.setcUsuario(cUsuario);
		obj.setiIdMenu(iIdMenu);
		obj.setiIdPrograma(iIdPrograma);
		obj.setlActivo(true);
		this.serviSysPrograma.add_sysUsuPrograma(obj);
		List<sysUsuPrograma> lista = new ArrayList<sysUsuPrograma>();
		lista = this.serviSysPrograma.list_sysUsuPrograma(cUsuario, iIdMenu, true);
		
		return lista;

	}
	
	
	
	@RequestMapping(value = "/sysUsuMenu/remove")
	public  @ResponseBody List<sysUsuMenu> remove_sysUsuMenu(String cUsuario , int iIdMenu,		
			ModelMap model) {		
		System.out.print("entro al remove");
		
		this.servSysMenu.remove_sysUsuMenu(cUsuario, iIdMenu);
		
		List<sysUsuMenu> lista = new ArrayList<sysUsuMenu>();
		lista = this.servSysMenu.list_sysUsuMenu(cUsuario, true);
		
		return lista;

	}
	
	

	
	@RequestMapping(value = "/sysUsuPrograma/getList", headers = "Accept=application/json")
	public @ResponseBody  List<sysUsuPrograma> list_sysUsuPrograma(String cUsuario , Integer iIdMenu ,ModelMap model) {		
						
		List<sysUsuPrograma> list = new ArrayList<sysUsuPrograma>();
		
		list = this.serviSysPrograma.list_sysUsuPrograma(cUsuario, iIdMenu, true);
		
		return list;

	}
	
	
	@RequestMapping(value = "/sysUsuPrograma/List_ctProgXctMenu", headers = "Accept=application/json")
	public @ResponseBody  List<ctPrograma> List_ctProgXctMenu(String cUsuario , Integer iIdMenu ,ModelMap model) {		
		
		List<ctPrograma> list = new ArrayList<ctPrograma>();
		
		list = this.serviSysPrograma.List_ctProgXctMenu(cUsuario, iIdMenu, true);
		
		return list;

	}
	
	
	

}

