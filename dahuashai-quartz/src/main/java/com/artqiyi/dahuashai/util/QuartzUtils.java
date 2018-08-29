package com.artqiyi.dahuashai.util;

import org.quartz.CronExpression;

import java.text.ParseException;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/5/9
 * Modify On: 2018/5/9 by chencunjun
 */
public class QuartzUtils {
    /**
     * 将cronExpression转换成中文
     * @param cronExp
     * @return
     */
    public static String translateToChinese(String cronExp)
    {
        if (cronExp == null || cronExp.length() < 1)
        {
            return "cron表达式为空";
        }
        CronExpression exp = null;
        // 初始化cron表达式解析器
        try
        {
            exp = new CronExpression(cronExp);
        }
        catch (ParseException e)
        {
            return "corn表达式不正确";
        }
        String[] tmpCorns = cronExp.split(" ");
        StringBuffer sBuffer = new StringBuffer();
        if(tmpCorns.length == 6)
        {
            //解析月
            if(!tmpCorns[4].equals("*"))
            {
                sBuffer.append(tmpCorns[4]).append("月");
            }
            else
            {
                sBuffer.append("每月");
            }
            //解析周
            if(!tmpCorns[5].equals("*") && !tmpCorns[5].equals("?"))
            {
                char[] tmpArray =  tmpCorns[5].toCharArray();
                for(char tmp:tmpArray)
                {
                    switch (tmp)
                    {
                        case '1':
                            sBuffer.append("星期天");
                            break;
                        case '2':
                            sBuffer.append("星期一");
                            break;
                        case '3':
                            sBuffer.append("星期二");
                            break;
                        case '4':
                            sBuffer.append("星期三");
                            break;
                        case '5':
                            sBuffer.append("星期四");
                            break;
                        case '6':
                            sBuffer.append("星期五");
                            break;
                        case '7':
                            sBuffer.append("星期六");
                            break;
                        case '-':
                            sBuffer.append("至");
                            break;
                        default:
                            sBuffer.append(tmp);
                            break;
                    }
                }
            }

            //解析日
            if(!tmpCorns[3].equals("?"))
            {
                if(!tmpCorns[3].equals("*"))
                {
                    sBuffer.append(tmpCorns[3]).append("日");
                }
                else
                {
                    sBuffer.append("每日");
                }
            }

            //解析时
            if(!tmpCorns[2].equals("*"))
            {
                sBuffer.append(tmpCorns[2]).append("时");
            }
            else
            {
                sBuffer.append("每时");
            }

            //解析分
            if(!tmpCorns[1].equals("*"))
            {
                sBuffer.append(tmpCorns[1]).append("分");
            }
            else
            {
                sBuffer.append("每分");
            }

            //解析秒
            if(!tmpCorns[0].equals("*"))
            {
                sBuffer.append(tmpCorns[0]).append("秒");
            }
            else
            {
                sBuffer.append("每秒");
            }
        }

        return sBuffer.toString();

    }
}
