package com.sinergitec.ischool.service;

import java.util.List;

import com.sinergitec.ischool.model.sg.ctPrograma;

public interface ctProgramaService {
	public void add_ctPrograma(ctPrograma obj);

	public void update_ctPrograma(ctPrograma obj);

	public List<ctPrograma> list_ctPrograma();

	public ctPrograma get_ctPrograma(int idMenu, int idPrograma);

	public void remove_ctPrograma(int idMenu, int idPrograma);

}
