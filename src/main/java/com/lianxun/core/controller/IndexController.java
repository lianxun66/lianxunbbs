package com.lianxun.core.controller;

import com.lianxun.web.PortalBaseController;

public class IndexController extends PortalBaseController{
	public void index(){
//		render("index.html");
//		createHTML("", "index.html", "/index.html");
		redirect("/index.html");
	}
	
}
