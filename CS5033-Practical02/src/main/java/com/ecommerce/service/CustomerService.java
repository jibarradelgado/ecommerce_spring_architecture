package com.ecommerce.service;

import com.ecommerce.model.Customer;

/**
 * Created by jid on 21/04/15.
 */
public interface CustomerService {
    Customer save(Customer customer);
    boolean findByLogin(String username, String password);
    boolean findByUsername(String username);
}
