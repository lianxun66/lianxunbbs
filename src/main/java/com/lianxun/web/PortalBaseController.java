package com.lianxun.web;

import com.lianxun.constans.CodeConst;

/**
 * 封装的Contoller类，提供返回json调用的方法。
 * 
 * @author Administrator
 *
 */
public abstract class PortalBaseController extends CommonController {
	
	/**
	 * 
	 * portalProceed 此方法用于调用portal接口处理返回数据,调用之前需要完成业务处理
	 */
	public void proceed(){
		if(ajaxResult.getStatus()==CodeConst.Success_Code){
			success();
		}else{
			error();
		}
	}
	


}
