package com.lianxun.util;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class Utils {
	public static String mobleShield(String moble){
		moble = moble.substring(0,moble.length()-(moble.substring(3)).length())+"****"+moble.substring(7); 
		return moble;
	}
	/**
     * 获取文件扩展名
     * @param file
     * @return
     */
    public  static String getFileExtension(String filename) {
        if (filename.lastIndexOf(".") != -1 && filename.lastIndexOf(".") != 0) {
            return filename.substring(filename.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }
	/**

	 * 判断url是否为静态文件地址

	 * @param url

	 * @return

	 */
	public static boolean judgeStaticFile(String url){
		if (url.endsWith(".gif") || url.endsWith(".jpg") || url.endsWith(".png")||url.endsWith(".mp4")||url.endsWith("flv")
				|| url.endsWith(".bmp") || url.endsWith(".css") || url.endsWith(".js")|| url.endsWith(".ico")|| url.endsWith(".woff")){
	            return true;
		} else {
	            return false;
		}
	}
	
	public static boolean checkPhone(String phone){
		return !phone.matches("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(16[6])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$");
		
	}
	/**
	 * 请求路径转换
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String buildOriginalURL(HttpServletRequest request) {
		StringBuffer originalURL = request.getRequestURL();
		Map parameters = request.getParameterMap();
		if (parameters != null && parameters.size() > 0) {
			originalURL.append("?");
			for (Iterator iter = parameters.keySet().iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				String[] values = (String[]) parameters.get(key);
				for (int i = 0; i < values.length; i++) {
					originalURL.append(key).append("=").append(values[i]).append("&");
				}
			}
		}
		return originalURL.toString();
	}

	/** 
     * 字符串转换为16进制字符串 
     *  
     * @param s 
     * @return 
     */  
    private static String stringToHexString(String s) {  
        String str = "";  
        for (int i = 0; i < s.length(); i++) {  
            int ch = (int) s.charAt(i);  
            String s4 = Integer.toHexString(ch);  
            str = str + s4;  
        }  
        return str;  
    }  
  
    /** 
     * 16进制字符串转换为字符串 
     *  
     * @param s 
     * @return 
     */  
    private static String hexStringToString(String s) {  
        if (s == null || s.equals("")) {  
            return null;  
        }  
        s = s.replace(" ", "");  
        byte[] baKeyword = new byte[s.length() / 2];  
        for (int i = 0; i < baKeyword.length; i++) {  
            try {  
                baKeyword[i] = (byte) (0xff & Integer.parseInt(  
                        s.substring(i * 2, i * 2 + 2), 16));  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        try {  
            s = new String(baKeyword, "gbk");  
            new String();  
        } catch (Exception e1) {  
            e1.printStackTrace();  
        }  
        return s;  
    }

  
    
 
   
}
