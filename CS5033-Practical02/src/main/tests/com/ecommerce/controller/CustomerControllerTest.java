package com.ecommerce.controller;

import com.ecommerce.model.Customer;
import com.ecommerce.model.CustomerLogin;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.DataBinder;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.Assert.*;

/**
 * Created by jid on 22/04/15.
 */
public class CustomerControllerTest {

    Customer customer;
    CustomerLogin customerLogin;

    @Before
    public void setUp() throws Exception {
        customer =  new Customer();
        customer.setCustomer_id(1);
        customer.setCreate_date();
        customer.setEmail("john@gmail.com");
        customer.setFirst_name("John");
        customer.setLast_name("Nash");
        customer.setPassword("john");

        customerLogin = new CustomerLogin();
        customerLogin.setEmail("john@gmail.com");
        customerLogin.setPassword("john");
    }

    @Test
    public void testSignup() throws Exception {
        CustomerController customerController = new CustomerController();
        String result = customerController.signup(customer, new DataBinder(customer, "customer").getBindingResult(), new BindingAwareModelMap());
        assertTrue(result.equals("redirect:login.html"));
    }

    @Test
    public void testLogin() throws Exception {
        CustomerController customerController = new CustomerController();
        String result = customerController.login(customerLogin, new DataBinder(customerLogin, "customer").getBindingResult());
        assertTrue(result.equals("success"));
    }

}