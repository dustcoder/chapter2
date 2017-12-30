package org.ren.chapter2.util;/*
 *@Author:WuRen
 *@Description:集合工具类
 *@date: 14:20 2017/12/30
 */

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.Collection;
import java.util.Map;

public class CollectionUtil {
    /*
     * @Author:WuRen
     * @Description: 判断collection 是否为空
     * @Date: 14:22 2017/12/30
     * @param:  * @param null
    */
    public  static  boolean isEmpty(Collection<?> collection){
        return CollectionUtils.isEmpty(collection);
    }

    /*
     * @Author:WuRen
     * @Description:  判断collection 是否非空
     * @Date: 14:23 2017/12/30
     * @param:  * @param null
    */
    public  static  boolean isNotEmpty(Collection<?> collection){
        return !isEmpty(collection);
    }

    /*
     * @Author:WuRen
     * @Description: 判断map是否为空
     * @Date: 14:25 2017/12/30
     * @param:  * @param null
    */
    public static boolean isEmpty(Map<?,?> map){
        return MapUtils.isEmpty(map);
    }

    /*
     * @Author:WuRen
     * @Description: 判断map是否非空
     * @Date: 14:26 2017/12/30
     * @param:  * @param null
    */
    public static boolean isNotEmpty(Map<?,?> map){
        return MapUtils.isEmpty(map);
    }




}
