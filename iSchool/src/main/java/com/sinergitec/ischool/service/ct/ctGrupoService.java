package com.sinergitec.ischool.service.ct;


import java.util.List;
import com.sinergitec.ischool.model.ct.ctGrupo;

public interface ctGrupoService {
	
	public void add_ctGrupo(ctGrupo obj_Grupo) ;	
	public void update_ctGrupo(ctGrupo obj_ctGrupo) ;	
	public void remove_ctGrupo(int id);	
	public List<ctGrupo> list_ctGrupo();	
	public ctGrupo get_Grupo(int id) ;
}
 