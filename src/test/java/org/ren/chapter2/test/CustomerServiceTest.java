package org.ren.chapter2.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.ren.chapter2.service.CustomerService;

import java.util.HashMap;
import java.util.Map;

public class CustomerServiceTest {

    private final CustomerService  customerService;

    public  CustomerServiceTest(){
        customerService = new CustomerService();
    }

    @Before
    public  void  init(){
        //todo 初始化数据库

    }

    @Test
    public   void  createCustomerServiceTest(){
        Map<String,Object> fieldMap = new HashMap();
        fieldMap.put("name","customer100");
        fieldMap.put("contact","John");

        fieldMap.put("telephone","13956497935");
        boolean result = customerService.createCustomer(fieldMap);
        Assert.assertTrue(result);
    }
}
