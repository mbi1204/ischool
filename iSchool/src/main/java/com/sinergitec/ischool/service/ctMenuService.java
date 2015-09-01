package com.sinergitec.ischool.service;

import java.util.List;

import com.sinergitec.ischool.model.sg.ctMenu;

public interface ctMenuService {
	public void add_ctMenu(ctMenu obj);

	public void update_ctMenu(ctMenu obj);

	public List<ctMenu> list_ctMenu();

	public ctMenu get_ctMenu(int id);

	public void remove_ctMenu(int id);

}
