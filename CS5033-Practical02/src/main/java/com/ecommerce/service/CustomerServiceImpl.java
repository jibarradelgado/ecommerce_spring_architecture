package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ecommerce.model.Customer;
import com.ecommerce.repository.CustomerRepository;
/**
 * Created by jid on 21/04/15.
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Qualifier("customerRepository")
    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public Customer save(Customer student) {
        return customerRepository.save(student);
    }

    public boolean findByLogin(String userName, String password) {
        Customer customer = customerRepository.findByUsername(userName);

        if(customer != null && customer.getPassword().equals(password)) {
            return true;
        }

        return false;
    }

    public boolean findByUsername(String username) {
        Customer customer = customerRepository.findByUsername(username);

        if(customer != null) {
            return true;
        }

        return false;
    }
}
