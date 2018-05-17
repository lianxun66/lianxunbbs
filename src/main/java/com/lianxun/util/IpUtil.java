package com.lianxun.util;

import javax.servlet.http.HttpServletRequest;


public class IpUtil {
	 public static String getIpAddr(HttpServletRequest request) {     
	      String ip =applyIp(request.getHeader("x-forwarded-for"));
	      if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {     
	         ip = applyIp(request.getHeader("Proxy-Client-IP"));
	     }     
	      if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {     
	         ip = applyIp(request.getHeader("WL-Proxy-Client-IP"));
	      }     
	     if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {     
	          ip = applyIp(request.getRemoteAddr());
	     }    
	     return ip;     
	}
	 private static String applyIp(String ip){
		 if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			 return ip;
		 }
		return ip.indexOf(",")==-1 ? ip:ip.split(",")[0]; 
	 }
}
