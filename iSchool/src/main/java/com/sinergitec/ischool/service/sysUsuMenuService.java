package com.sinergitec.ischool.service;

import java.util.List;

import com.sinergitec.ischool.model.sg.sysUsuMenu;

public interface sysUsuMenuService {
	public void add_sysUsuMenu(sysUsuMenu obj);

	public void update_sysUsuMenu(sysUsuMenu obj);

	public List<sysUsuMenu> list_sysUsuMenu(String cUsuario , Boolean lActivo);

	public sysUsuMenu get_sysUsuMenu(int id);

	public void remove_sysUsuMenu(String cUsuario ,int iMenu);

}
