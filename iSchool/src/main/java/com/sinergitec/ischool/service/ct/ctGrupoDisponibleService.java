package com.sinergitec.ischool.service.ct;

import java.util.List;
import com.sinergitec.ischool.model.ct.ctGrupo;

public interface ctGrupoDisponibleService {

	public List<ctGrupo> list_ctGrupo();
	public ctGrupo get_Grupo(int id) ;

}
