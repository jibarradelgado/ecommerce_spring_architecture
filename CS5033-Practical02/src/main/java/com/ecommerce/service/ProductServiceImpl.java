package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jid on 22/04/15.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService{

    @Qualifier("productRepository")
    @Autowired
    private ProductRepository productRepository;

    public List<Product> find() {
        List<Product> products = productRepository.find();
        return products;
    }
}
