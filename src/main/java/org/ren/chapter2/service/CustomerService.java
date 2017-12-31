package org.ren.chapter2.service;

import org.ren.chapter2.helper.DatabaseHelper;
import org.ren.chapter2.model.Customer;
import org.ren.chapter2.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class CustomerService {

    private  final  static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private  static final String DRIVER;
    private  static final  String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static {
        Properties conf = PropsUtil.loadProps("config.properties");
        DRIVER = conf.getProperty("jdbc.driver");
        URL = conf.getProperty("jdbc.url");
        USERNAME = conf.getProperty("jdbc.username");
        PASSWORD = conf.getProperty("jdbc.password");

        try {
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            LOGGER.error("can not load jdbc driver",e);
        }
    }


    public boolean createCustomer(Map<String,Object> fieldMap){
        //todo
        return false;
    }

//    public List<Customer> getCustomerList(){
//        Connection conn = null;
//        try {
//            List <Customer> customerList = new ArrayList();
//            String sql = "select * from customer";
//            conn = DatabaseHelper.getConnection();
//            PreparedStatement stat = conn.prepareStatement(sql);
//            ResultSet rs = stat.executeQuery();
//            while (rs.next()){
//                Customer customer = new Customer();
//                customer.setId(rs.getInt("id"));
//                customer.setContact(rs.getString("contact"));
//                customer.setEmail(rs.getString("email"));
//                customer.setName(rs.getString("name"));
//                customer.setRemark(rs.getString("remark"));
//                customer.setTelephone(rs.getString("telephone"));
//                customerList.add(customer);
//            }
//            return customerList;
//
//        }catch (SQLException e){
//            LOGGER.error("execute sql failure",e);
//        }finally {
//            DatabaseHelper.closeConnection(conn);
//
//        }
//
//        return null;
//    }

    public List<Customer> getCustomerList(){
        String sql = "SELECT * FROM `customer`";
        return DatabaseHelper.queryEntityList(Customer.class,sql);
    }

}
