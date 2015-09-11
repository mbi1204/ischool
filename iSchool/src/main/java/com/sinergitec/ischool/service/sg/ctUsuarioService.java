package com.sinergitec.ischool.service.sg;


import java.util.List;
import com.sinergitec.ischool.model.sg.ctUsuario;


public interface ctUsuarioService {
	public String add_ctUsuario(String cUsuario,ctUsuario obj);

	public String update_ctUsuario(String cUsuario,ctUsuario obj);

	public List<ctUsuario> list_ctUsuario();

	public ctUsuario get_ctUsuario(String id);

	public String remove_ctUsuario(String cUsuario,String id);
	
	public String get_login(ctUsuario Obj);
	
	@SuppressWarnings("rawtypes")
	public  List<List>     getAllMenu(String cUsuario);

}
