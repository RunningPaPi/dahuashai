/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai-common
 * Author: author  wushyue@gmail.com
 * Create On: May 9, 2018 4:08:01 PM
 * Modify On: May 9, 2018 4:08:01 PM by wushyue@gmail.com
 */
package com.artqiyi.dahuashai.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.artqiyi.dahuashai.common.constant.DateConstants;

import java.util.Date;

/**
 * 业务序列号生成器
 *
 * @author wushuang
 * @since 2018-05-09
 */
public final class SequenceGenerator {
	private static final Logger logger = LoggerFactory.getLogger(SequenceGenerator.class);
	
	
	/**
	  * @Title: getSequenceUUID
	  * @Creater: chencc <br>
	  * @Date: 2011-3-18 <br>
	  * @Description: TODO根据公用方法获得序列ID
	  * @param @return
	  * @param @throws Exception
	  * @return String
	  * @throws
	 */
	public static String getSequenceUUID()  {
		String seqStr = "";
		try{
			seqStr = SeqUUIDUtil.toSequenceUUID();
		}catch(Exception e){
			logger.error("getSequenceUUID() exception",e);
			throw new RuntimeException(e.getMessage());
		}
		return seqStr;
	}
	
	
	/**
      * 根据UUID获得展示ID(六位)
	  * @param @param seqId
	  * @param @param nowDate
	  * @param @return
	  * @param @throws Exception
	  * @return String
	  * @throws
	 */
	public static String getShowIdBySeqId(String seqId, Date nowDate)  {
		String showId = "";
		try{
			if(null == seqId || seqId.length()<6)
				throw new Exception("序列ID长度太短！");
			seqId = seqId.replace("-", "").replace("/", "").replace("_", "");
			showId = DateUtil.convertDateToStr(nowDate, DateConstants.NOTBLANK_DATE_FORMAT) + 
							seqId.toString().substring(String.valueOf(seqId).length()-6,String.valueOf(seqId).length());

		}catch(Exception ex){
			logger.error(ex.getMessage(),ex);
		}
		return showId;
	}
	
	/**
      * 根据UUID获得展示ID(三位)
	  * @param @param seqId
	  * @param @param showStr
	  * @param @param nowDate
	  * @param @return
	  * @param @throws Exception
	  * @return String
	  * @throws
	 */
	public static String getShowIdBySeqId(String seqId, String showStr, Date nowDate) {
		String showId = "";
		try{
			if(null == seqId || seqId.length()<3)
				throw new Exception("序列ID长度太短！");
			if(null == showStr || showStr.length()<1 || showStr.length()>5)
				throw new Exception("序列展示符位数不对！");
			seqId = seqId.replace("-", "").replace("/", "");
			showId = DateUtil.convertDateToStr(nowDate, DateConstants.NOTBLANK_DATE_FORMAT) + showStr + 
							seqId.toString().substring(String.valueOf(seqId).length()-3,String.valueOf(seqId).length());

		}catch(Exception e){
			logger.error("getShowIdBySeqId exception",e);
			throw  new RuntimeException(e.getMessage());
		}
		return showId;
	}

	public static void main(String[] args){
		Date nowDate = new Date();

		String str1 = SequenceGenerator.getSequenceUUID();
		String str2 = SequenceGenerator.getShowIdBySeqId(str1,nowDate);
		String str3 = SequenceGenerator.getShowIdBySeqId(str1,"COIND",nowDate);

		System.out.println("str1="+str1);
		System.out.println("str2="+str2);
		System.out.println("str3="+str3);
	}

}
