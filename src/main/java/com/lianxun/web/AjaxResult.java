package com.lianxun.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.lianxun.constans.CodeConst;


/**
 * 服务器返回客户端消息包装类
 * 
 * @author Administrator
 *
 */
public class AjaxResult implements Serializable {
	private static final long serialVersionUID = 4123403887594400901L;
	/**状态码 默认1为调用成功，小于0为调用失败*/
	private int status=CodeConst.Success_Code;
	/**存储成功或者失败的消息*/
	private String message;
	/**无论成功或者失败，可将需要传递的对象放入map中*/
	private Map<String, Object> datas=new HashMap<String, Object>();

	

	public AjaxResult putToDatas(String key,Object value){
		this.datas.put(key, value);
		return this;
	}
	public Object getFromDatas(String key){
		return this.datas.get(key);
	}
	public Map<String, Object> getDatas() {
		return datas;
	}

	public int getStatus() {
		return status;
	}

	public AjaxResult setStatus(int status) {
		this.status = status;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public AjaxResult setMessage(String message) {
		this.message = message;
		return this;
	}
}