package com.lianxun.core;


import java.util.HashMap;
import java.util.Map;

import org.beetl.core.GroupTemplate;
import org.beetl.ext.jfinal3.JFinal3BeetlRenderFactory;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import com.lianxun.constans.PathConst;
import com.lianxun.core.controller.ApiController;
import com.lianxun.core.controller.IndexController;
import com.lianxun.core.controller.NoteController;
import com.lianxun.core.controller.UserController;
import com.lianxun.handler.HtmlHandler;

public class Config extends JFinalConfig {
	public static GroupTemplate groupTemplate;
	
	public static void main(String[] args) {
		JFinal.start("src/main/webapp", 81, "/",5);
	}
	public void configConstant(Constants me) {
		PropKit.use("mainconfig.propertise");
		me.setDevMode(PropKit.getBoolean("devMode"));
		me.setEncoding("utf-8");
		JFinal3BeetlRenderFactory renderFactory = new JFinal3BeetlRenderFactory();
		renderFactory.config();
		 groupTemplate = renderFactory.groupTemplate;
		Map<String, Object> shared = new HashMap<String, Object>();
		Map<String, Object> common = new HashMap<String, Object>();
		common.put("keywords", "链讯,去中心化论坛,DAPP论坛,区块链新生态");
		common.put("title", "链讯-去中心化论坛");
		common.put("description", "去中心化论坛,DAPP论坛,区块链新生态");
		shared.put("webPath", PathConst.WEBPATH);
		shared.put("common",common);
		groupTemplate.setSharedVars(shared);
		me.setRenderFactory(renderFactory);
	}

	public void configRoute(Routes me) {
		me.add("/",IndexController.class);
//		me.add("/note",NoteController.class);
//		me.add("/user",UserController.class);
		me.add("/api",ApiController.class);
		
	}                                   
	public void configPlugin(Plugins me) {
	}

	public void configInterceptor(Interceptors me) {
	}
	
	public void configHandler(Handlers me) {
	//	me.add(new HtmlHandler());
	}
	@Override
	public void afterJFinalStart() {
	
	}
	@Override
	public void configEngine(Engine me) {
	}
	
}
