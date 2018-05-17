/**  
 * All rights Reserved, Designed By www.paicheji.com
 * @Title:  BaseController.java   
 * @Package com.paicheji.baseframework.web   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 湖南拍车集汽车电子商务有限公司     
 * @date:   2017年7月23日 下午10:06:29   
 * @version V1.0 
 * @Copyright: 2017 www.paicheji.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南拍车集汽车电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
package com.lianxun.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;

import com.jfinal.core.Controller;
import com.jfinal.plugin.redis.Redis;
import com.lianxun.constans.CodeConst;

/**   
 * @ClassName:  CommonController   
 * @Description:控制器基类   
 * @author: 王运德   mmtzwyd@163.com
 * @date：2017年7月23日 下午10:06:29
 * 
 * @Copyright: 2017 www.paicheji.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南拍车集汽车电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目 
 */
public abstract class CommonController extends Controller{
	public String deviceId=null;
	// 请求返回结果集
	protected AjaxResult ajaxResult = new AjaxResult();
	// http参数包装
	protected Map<String, String> param = new HashMap<String, String>();
	/**
	 * 
	 * 返回成功的调用
	 */
	public void success() {
		ajaxResult.setStatus(CodeConst.Success_Code);
	}
	
	/**
	 * 
	 * @Title : successWithMessage(执行成功并返回一个消息，放在message中) @param: @param
	 *        fid @param: @param message @return: void @throws
	 */
	public void successWithMessage( String message) {
		ajaxResult.setStatus(CodeConst.Success_Code).setMessage(message);
	}

	/**
	 * 
	 * @Title : successWithData(执行成功并返回一个对象) @param: @param fid
	 *        方法名 @param: @param message 返回消息 @param: @param data 返回对象 @return:
	 *        void @throws
	 */
	public void successWithData( String message, Map<String, Object> data) {
		ajaxResult.setStatus(CodeConst.Success_Code).setMessage(message);
		ajaxResult.getDatas().putAll(data);
	}

	/**
	 * 
	 * @Title : error(执行失败，仅返回方法名) @param: @param fid @return: void @throws
	 */
	public void error() {
		ajaxResult.setStatus(CodeConst.Failure_Code);
	}
	public void error(int errorCode) {
		ajaxResult.setStatus(errorCode);
	}
	/**
	 * 
	 * @Title : errorWithMessage(执行失败返回一个消息) @param: @param fid
	 *        方法名 @param: @param message 返回消息 @return: void @throws
	 */
	public void errorWithMessage( String message) {
		ajaxResult.setStatus(CodeConst.Failure_Code).setMessage(message);
	}
	/**
	 * 
	 * @Title : errorWithMessage(执行失败返回错误码与一个消息) @param: @param fid
	 *        方法名 @param: @param message 返回消息 @return: void @throws
	 */
	public void errorWithMessage( int errorCode,String message) {
		ajaxResult.setStatus(errorCode).setMessage(message);
	}

	/**
	 * 
	 * @Title : errorWithData(执行失败返回消息与对象) @param: @param fid 方法名 @param: @param
	 *        message 返回消息 @param: @param data 返回数据 @return: void @throws
	 */
	public void errorWithData( String message, Map<String, Object> data) {
		ajaxResult.setMessage(message).setStatus(CodeConst.Failure_Code);
		ajaxResult.getDatas().putAll(data);
	}

	public abstract void proceed();
	
	
}
