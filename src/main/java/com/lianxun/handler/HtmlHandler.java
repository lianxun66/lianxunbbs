package com.lianxun.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;

public class HtmlHandler extends Handler{
	@Override
	public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
		if(target.equals("/index.html")){
			target="/index";
		}else if(target.equals("/note/add.html")){
			target="/note/add";
		}else if(target.equals("/user/login.html")){
			target="/user/login";
		}else if(target.equals("/note/detail.html")){
			target="/note/detail";
		}else if(target.equals("/user/set.html")){
			target="/user/set";
		}else if(target.equals("/user/reg.html")){
			target="/user/reg";
		}
		next.handle(target, request, response, isHandled);
	}

}
