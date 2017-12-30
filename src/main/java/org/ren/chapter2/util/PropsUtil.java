package org.ren.chapter2.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropsUtil {

    private static  final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);



    /*
     * @Author:WuRen
     * @Description:
     * @Date: 13:51 2017/12/30
     * @param:  * @param 文件名
    */
    private static Properties loadProps(String fileName){
        Properties props = null;
        InputStream is = null;
        try {

            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if(is == null){
                throw new FileNotFoundException(fileName + "file is not found");
            }
            props = new Properties();
            props.load(is);
        }catch (IOException e){
            LOGGER.error("load properties failure",e);
        }   finally {
            if(is != null){
                try {
                    is.close();
                }catch (IOException e){
                    LOGGER.error("close is failure",e);
                }
            }

        }
        return props;

    }

    /*
     * @Author:WuRen
     * @Description: 获取字符型属性
     * @Date: 13:53 2017/12/30  
     * @param:  * @param null
    */
    public  static  String getString(Properties props,String key){
        return getString(props,key,"");
    }

    /*
     * @Author:WuRen
     * @Description: 获取字符型属性
     * @Date: 13:57 2017/12/30
     * @param:  * @param null
    */
    public static  String getString(Properties props,String key,String defaultValue){
        String value = defaultValue;
        if(props.contains(key)){
            value = props.getProperty(key);
        }
        return value;
    }

    /*
     * @Author:WuRen
     * @Description: 获取数值型属性，默认为0
     * @Date: 14:00 2017/12/30
     * @param:  * @param null
    */
    public  static int  getInt(Properties props,String key){
        return getInt(props,key,0);
    }

    /*
     * @Author:WuRen
     * @Description: 取数值型属性,可指定默认值
     * @Date: 14:01 2017/12/30
     * @param:  * @param null
    */
    public static  int getInt(Properties props,String key,int defaultValue){
        int value = defaultValue;
        if(props.contains(key)){
            value = CastUtil.castInt(props.getProperty(key));
        }
        return value;
    }

    /*
     * @Author:WuRen
     * @Description: 取布尔型属性，默认为0
     * @Date: 14:00 2017/12/30
     * @param:  * @param null
     */
    public  static boolean  getBoolean(Properties props,String key){
        return getBoolean(props,key,false);
    }

    /*
     * @Author:WuRen
     * @Description: 取布尔型属性,可指定默认值
     * @Date: 14:01 2017/12/30
     * @param:  * @param null
     */
    public static  boolean getBoolean(Properties props,String key,Boolean defaultValue){
        boolean value = defaultValue;
        if(props.contains(key)){
            value = CastUtil.castBoolean(props.getProperty(key));
        }
        return value;
    }










}
