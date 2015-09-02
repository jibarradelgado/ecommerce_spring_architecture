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

import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jid on 22/04/15.
 */
@Controller
@SessionAttributes("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value="/welcome", method=RequestMethod.GET)
    public String welcome(Model model) {
        List<Product> products = productService.find();
        model.addAttribute("products", products);
        return "welcome";
    }
}
