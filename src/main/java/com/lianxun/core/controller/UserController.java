package com.lianxun.core.controller;

import com.lianxun.web.PortalBaseController;

public class UserController extends PortalBaseController{
	public void login(){
		render("/user/login.html");
	}
	public void set(){
		render("/user/set.html");
	}
	public void reg(){
		render("/user/reg.html");
	}
	
}
