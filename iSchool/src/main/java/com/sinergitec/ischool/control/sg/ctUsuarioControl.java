package com.sinergitec.ischool.control.sg;

import java.sql.Timestamp;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.buf.MessageBytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sinergitec.ischool.model.sg.ctUsuario;
import com.sinergitec.ischool.service.sg.ctPuestoService;
import com.sinergitec.ischool.service.sg.ctUsuarioService;

@Controller
public class ctUsuarioControl {
	@Autowired
	private ctUsuarioService serv;
	@Autowired
	private ctPuestoService serv_ctPuesto;

	private String Mensaje;

	private ctUsuarioControl() {
		this.Mensaje = null;
	}

	public String getMensaje() {
		return Mensaje;
	}

	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}

	@RequestMapping(value = "/ctUsuario", method = RequestMethod.GET)
	public String list_ctUsuario(Model model) {
		model.addAttribute("ctUsuario", new ctUsuario());
		model.addAttribute("lista_ctUsuario", this.serv.list_ctUsuario());
		model.addAttribute("lista_ctPuesto", this.serv_ctPuesto.list_ctPuesto());
		model.addAttribute("vcMensaje", this.getMensaje());

		return "ctUsuario_List";
	}

	@RequestMapping(value = "/ctUsuario/add", method = RequestMethod.POST)
	public String add_ctUsuario(@ModelAttribute("ctUsuario") ctUsuario obj, HttpSession session, Model model) {

		ctUsuario ctUsuarioSession = (ctUsuario) session.getAttribute("ctUsuarioSession");

		java.util.Date date = new java.util.Date();
		obj.setDtFechaAlta(new Timestamp(date.getTime()));
		obj.setlActivo(true);

		String vcMensaje = null;

		vcMensaje = this.serv.add_ctUsuario(ctUsuarioSession.getcUsuario(), obj);

		this.setMensaje(vcMensaje);

		return "redirect:/ctUsuario";

	}

	@RequestMapping("/remove_ctUsuario/{cUsuario}")
	public String remove_ctUsuario(@PathVariable("cUsuario") String cUsuario, HttpSession session) {

		ctUsuario ctUsuarioSession = (ctUsuario) session.getAttribute("ctUsuarioSession");
		
		
		

		System.out.println("remove---> " + ctUsuarioSession.getcUsuario());

		String vcMensaje = null; 
		
		vcMensaje = this.serv.remove_ctUsuario(ctUsuarioSession.getcUsuario(), cUsuario);
		
		this.setMensaje(vcMensaje);
		return "redirect:/ctUsuario";

	}

	@RequestMapping("/get_ctUsuario/{cUsuario}")
	public String get_ctUsuario(@PathVariable("cUsuario") String cUsuario, Model model) {

		model.addAttribute("ctUsuario", this.serv.get_ctUsuario(cUsuario));
		model.addAttribute("lista_ctPuesto", this.serv_ctPuesto.list_ctPuesto());

		return "ctUsuario_Form_Update";

	}

	@RequestMapping(value = "/ctUsuario/update", method = RequestMethod.POST)
	public String edit_ctUsuario(@ModelAttribute("ctUsuario") ctUsuario obj, HttpSession session) {
		ctUsuario ctUsuarioSession = (ctUsuario) session.getAttribute("ctUsuarioSession");
		java.util.Date date = new java.util.Date();
		obj.setDtFechaAlta(new Timestamp(date.getTime()));
		
		String vcMensaje = null; 

		vcMensaje =  this.serv.update_ctUsuario(ctUsuarioSession.getcUsuario(), obj);
		this.setMensaje(vcMensaje);
		
		return "redirect:/ctUsuario";
	}

}
