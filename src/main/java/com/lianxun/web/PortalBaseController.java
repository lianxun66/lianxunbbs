package com.lianxun.web;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.beetl.core.Template;

import com.jfinal.kit.PathKit;
import com.jfinal.kit.StrKit;
import com.lianxun.constans.CodeConst;
import com.lianxun.core.Config;

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
	public void createHTML(String dir,String htmlname,String templatePath){
		Template template=Config.groupTemplate.getTemplate(templatePath);
        FileWriter fw=null;
        try {
        	//临时文件
        	File dirf=new File(PathKit.getWebRootPath()+dir);
        	if(!dirf.exists()){
        		dirf.mkdir();
        	}
        	File file=new File(dirf,htmlname);
        	fw=new FileWriter(file);
            template.renderTo(fw);
			fw.flush();
			
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        		try {
	             fw.close();
        	 	} catch (IOException e) {
        	 		// TODO Auto-generated catch block
        	 		e.printStackTrace();
        	 	}
			}
	}


}
