/**  
 * All rights Reserved, Designed By www.paicheji.com
 * @Title:  NumberUtil.java   
 * @Package com.bcc.baseframework.utils   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 湖南拍车集汽车电子商务有限公司     
 * @date:   2018年3月16日 下午2:10:42   
 * @version V1.0 
 * @Copyright: 2018 www.paicheji.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南拍车集汽车电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
package com.lianxun.util;

import java.text.DecimalFormat;

/**   
 * @ClassName:  NumberUtil   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 徐达   1013206680@qq.com
 * @date：2018年3月16日 下午2:10:42
 * 
 * @Copyright: 2018 www.paicheji.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南拍车集汽车电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目 
 */
public class NumberUtil {
	  public static String formatTosepara(double data) {
	        DecimalFormat df = new DecimalFormat("#,###.00"); 
	        return df.format(data);
	    }
}
