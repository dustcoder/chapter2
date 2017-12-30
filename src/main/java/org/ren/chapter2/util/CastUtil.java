package org.ren.chapter2.util;/*
 *@Author:WuRen
 *@Description:
 *@date: 14:04 2017/12/30
 */

import com.sun.org.apache.xpath.internal.operations.Bool;

public final class CastUtil {
    /*
     * @Author:WuRen
     * @Description:转为String
     * @Date: 14:09 2017/12/30
     * @param:  * @param null
     */
    public static  String castString(Object obj){
        return CastUtil.castString(obj,"");
    }

    /*
        * @Author:WuRen
        * @Description:转为String，提供默认值
        * @Date: 14:09 2017/12/30
        * @param:  * @param obj
        * @param defaultValue
       */
    public static  String castString(Object obj,String defaultValue){
        return obj !=null ? String.valueOf(obj):defaultValue;
    }

    public static  double castDouble(Object obj){
        return CastUtil.castDouble(obj,0);
    }

    /*
     * @Author:WuRen
     * @Description: 转double
     * @Date: 14:29 2017/12/30
     * @param:  * @param null
    */
    public static  double castDouble(Object obj,double defaultValue){
        double doubleValue = defaultValue;
        if(obj != null){

            String strValue = castString(obj);
            if(StringUtil.isNotEmpty(strValue)){
                try {
                    doubleValue = Double.parseDouble(strValue);
                }catch (NumberFormatException E){
                    doubleValue = defaultValue;
                }
            }

        }
        return doubleValue;
    }

    /*
     * @Author:WuRen
     * @Description: 转为布尔类型
     * @Date: 14:33 2017/12/30
     * @param:  * @param null
    */
    public static  boolean castBoolean(Object obj){
        return CastUtil.castBoolean(obj,false);
    }

    public static  boolean castBoolean(Object obj,boolean defaultValue){

        boolean booleanValue = defaultValue;
        if(obj != null){
            booleanValue = Boolean.parseBoolean(castString(obj));
        }
        return booleanValue;
    }


    //todo list 转int 转long

    public  static  int castInt(Object obj){
        return CastUtil.castInt(obj,0);
    }

    public static int castInt(Object obj,int defaultValue){
        int intValue = defaultValue;
        if(obj != null){
            String strValue = castString(obj);
            if(StringUtil.isNotEmpty(strValue)){
                try {
                    intValue = Integer.parseInt(strValue);
                }catch (NumberFormatException E){
                    intValue = defaultValue;
                }
            }

        }
        return  intValue;
    }






}
