package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ecommerce.model.Product;

import java.util.List;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.product_id = :product_id")
    Product findById(@Param("product_id") int product_id);

    @Query("select p from Product p")
    List<Product> find();
}