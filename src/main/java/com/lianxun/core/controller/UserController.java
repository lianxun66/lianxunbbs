package com.lianxun.core.controller;

import com.lianxun.web.PortalBaseController;

public class UserController extends PortalBaseController{
	public void login(){
		render("/user/login.html");
		createHTML("/user", "login.html", "/user/login.html");
	}
	public void set(){
		render("/user/set.html");
		createHTML("/user", "set.html", "/user/set.html");
	}
	public void reg(){
		render("/user/reg.html");
		createHTML("/user", "reg.html", "/user/reg.html");
	}
	
}
