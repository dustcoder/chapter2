package org.ren.chapter2.helper;/*
 *@Author:WuRen
 *@Description:
 *@date: 9:46 2017/12/31
 */

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.ren.chapter2.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public final class DatabaseHelper {
    private static final ThreadLocal<Connection> CONNECTION_HOLDER;
    public static final Logger LOGGER = LoggerFactory.getLogger(DatabaseHelper.class);

    private static final QueryRunner QUERY_RUNNER;
    private static final BasicDataSource DATA_SOURCE;




    //初始化静态代码块
    static{
        CONNECTION_HOLDER = new ThreadLocal<Connection>();
        QUERY_RUNNER = new QueryRunner();
        Properties conf = PropsUtil.loadProps("config.properties");
        String driver = conf.getProperty("jdbc.driver");
        String url = conf.getProperty("jdbc.url");

        String username = conf.getProperty("jdbc.username");
        String password = conf.getProperty("jdbc.password");

        DATA_SOURCE = new BasicDataSource();
        DATA_SOURCE.setDriverClassName(driver);
        DATA_SOURCE.setUrl(url);
        DATA_SOURCE.setUsername(username);
        DATA_SOURCE.setPassword(password);
    }



     public static Connection getConnection(){

         Connection conn = CONNECTION_HOLDER.get();
         if(conn == null){
             try {
                 conn = DATA_SOURCE.getConnection();
             }catch (SQLException e){
                 LOGGER.error("get connection failure",e);
                 throw new RuntimeException(e);

             }finally {
                 CONNECTION_HOLDER.set(conn);
             }

         }
         return conn;
//         try {
//             conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
//         }catch (SQLException e){
//             LOGGER.error("get connection failure",e);
//         }
//         return conn;

     }

    public static void closeConnection(){
        Connection conn = CONNECTION_HOLDER.get();
        if (conn != null) {
            try {
                conn.close();
            }catch (SQLException e){
                LOGGER.error("close connection failure",e);
                throw new RuntimeException(e);
            }finally {
                CONNECTION_HOLDER.remove();
            }

        }

//        if(conn != null){
//            try {
//                conn.close();
//            }catch (SQLException e){
//                LOGGER.error("close connection failure",e);
//            }
//
//        }

    }

    public static <T>List<T>  queryEntityList(Class<T> entityClass,String sql,Object ... param){
        List<T> entityList;
        try {
            Connection conn = getConnection();
            entityList = QUERY_RUNNER.query(conn,sql,new BeanListHandler<T>(entityClass),param);
        }catch (SQLException e){
            LOGGER.error("query entity list failure",e);
            throw new RuntimeException(e);
        }
        return entityList;


    }



}
