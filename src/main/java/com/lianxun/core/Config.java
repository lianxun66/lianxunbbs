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
	
	
	public static void main(String[] args) {
		JFinal.start("src/main/webapp", 81, "/",5);
	}
	public void configConstant(Constants me) {
		PropKit.use("mainconfig.propertise");
		me.setDevMode(PropKit.getBoolean("devMode"));
		me.setEncoding("utf-8");
		JFinal3BeetlRenderFactory renderFactory = new JFinal3BeetlRenderFactory();
		renderFactory.config();
		GroupTemplate groupTemplate = renderFactory.groupTemplate;
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
		me.add("/note",NoteController.class);
		me.add("/user",UserController.class);
		me.add("/api",ApiController.class);
		
	}                                   
	public void configPlugin(Plugins me) {
		DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("master.database.jdbcUrl"), PropKit.get("master.database.user"), 		PropKit.get("master.database.password"));
		WallFilter wall = new WallFilter();
		wall.setDbType("mysql");
		druidPlugin.addFilter(wall);
		druidPlugin.addFilter(new StatFilter());

		me.add(druidPlugin);
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);

		me.add(arp);
		// =================数据库到实体类的映射关系======================
		arp.setShowSql(Boolean.parseBoolean(PropKit.get("showsql")));// 这句话就是ShowSql
	}

	public void configInterceptor(Interceptors me) {
	}
	
	public void configHandler(Handlers me) {
		me.add(new HtmlHandler());
	}
	@Override
	public void afterJFinalStart() {
	
	}
	@Override
	public void configEngine(Engine me) {
	}
	
}
