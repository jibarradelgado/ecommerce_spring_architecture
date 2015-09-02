package com.ecommerce.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ecommerce.model.Customer;
import com.ecommerce.model.CustomerLogin;
import com.ecommerce.service.CustomerService;

/**
 * Created by jid on 22/04/15.
 */
@Controller
@SessionAttributes("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value="/signup", method=RequestMethod.GET)
    public String signup(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "signup";
    }

    @RequestMapping(value="/signup", method=RequestMethod.POST)
    public String signup(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "signup";
        } else if(customerService.findByUsername(customer.getUsername())) {
            model.addAttribute("message", "Email already exists. Try another email");
            return "signup";
        } else {
            customerService.save(customer);
            model.addAttribute("message", "Saved customer details");
            return "redirect:login.html";
        }
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login(Model model) {
        CustomerLogin customerLogin = new CustomerLogin();
        model.addAttribute("customerLogin", customerLogin);
        return "login";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(@Valid @ModelAttribute("customerLogin") CustomerLogin customerLogin, BindingResult result) {
        if (result.hasErrors()) {
            return "login";
        } else {
            boolean found = customerService.findByLogin(customerLogin.getEmail(), customerLogin.getPassword());
            if (found) {
                return "success";
            } else {
                return "failure";
            }
        }
    }
}
