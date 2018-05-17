package com.lianxun.core.controller;


import java.io.File;
import java.io.IOException;


import com.jfinal.kit.PathKit;
import com.jfinal.upload.UploadFile;
import com.lianxun.web.PortalBaseController;
import com.lianxun.util.Utils;

public class ApiController extends PortalBaseController{
	public void upload() throws IOException{
		UploadFile uploadFile=getFile("file");
		long time=System.currentTimeMillis();
		String filetype=Utils.getFileExtension(uploadFile.getFileName());
		String url=File.separator+"files"+File.separator+"photos"+File.separator+(time/1000+28800)/86400+File.separator+time+"."+filetype;
		String filename=PathKit.getWebRootPath()+url;
		File dir=new File(PathKit.getWebRootPath()+File.separator+"files"+File.separator+"photos"+File.separator+(time/1000+28800)/86400);
		if(!dir.exists()){
			dir.mkdir();
		}
		uploadFile.getFile().renameTo(new File(filename));
		uploadFile.getFile().delete();
		ajaxResult.putToDatas("url", url);
		renderJson(ajaxResult);
	}
}
