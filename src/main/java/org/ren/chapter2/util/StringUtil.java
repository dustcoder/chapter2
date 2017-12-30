package org.ren.chapter2.util;/*
 *@Author:WuRen
 *@Description:字符串工具类
 *@date: 14:15 2017/12/30
 */

import org.apache.commons.lang3.StringUtils;

public class StringUtil {

    /*
     * @Author:WuRen
     * @Description: 判断字符串是否为空
     * @Date: 14:19 2017/12/30
     * @param:  * @param null
    */
    public static boolean isEmpty(String str){
        if(str != null){
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /*
     * @Author:WuRen
     * @Description: 判断字符串是否非空
     * @Date: 14:19 2017/12/30
     * @param:  * @param null
    */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }


}
