package com.sinergitec.ischool.service;

import java.util.List;

import com.sinergitec.ischool.model.sg.sysUsuPrograma;

public interface sysUsuProgramaService {
	public void add_sysUsuPrograma(sysUsuPrograma obj);

	public void update_sysUsuPrograma(sysUsuPrograma obj);

	public List<sysUsuPrograma> list_sysUsuPrograma(String cUsuario ,int iMenu, Boolean lActivo);

	public sysUsuPrograma get_sysUsuPrograma(int id);

	public void remove_sysUsuPrograma(String cMenu ,int iMenu, int iPrograma);

}
