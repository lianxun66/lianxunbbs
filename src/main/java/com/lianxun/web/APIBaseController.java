package com.lianxun.web;

import com.jfinal.kit.JsonKit;
import com.jfinal.kit.StrKit;

/**
 * 封装的Contoller类，提供返回json调用的方法。
 * 
 * @author Administrator
 *
 */
public abstract class APIBaseController extends CommonController {
	/**
	 * 
	 * @Title : sendCallback(ajax调用返回，可根据callback自动决定是否跨域调用) @param: @param
	 *        controller @param: @param callback @param: @param json @return:
	 *        void @throws
	 */
	public void proceed() {
		String callback=getPara("callback");
		if (StrKit.isBlank(callback)) {
			this.renderJson(ajaxResult);
		} else {
			this.renderText(callback + "(" + JsonKit.toJson(ajaxResult) + ")");
		}
	}
	public void proceed(Object obj) {
		ajaxResult=(AjaxResult)obj;
		proceed();
	}
	
	
	
}
