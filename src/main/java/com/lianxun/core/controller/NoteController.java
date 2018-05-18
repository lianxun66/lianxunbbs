package com.lianxun.core.controller;

import com.lianxun.web.PortalBaseController;

public class NoteController extends PortalBaseController{
	public void add(){
		render("/note/add.html");
		createHTML("/note", "add.html", "/note/add.html");
	}
	public void detail(){
		render("/note/detail.html");
		createHTML("/note", "detail.html", "/note/detail.html");
	}
}
