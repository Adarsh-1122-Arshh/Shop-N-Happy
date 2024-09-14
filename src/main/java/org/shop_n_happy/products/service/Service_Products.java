package org.shop_n_happy.products.service;

import org.shop_n_happy.products.model.Products;
import org.shop_n_happy.products.repository.Repository_Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class Service_Products {
    @Autowired
    Repository_Products rep_Pro;


    public Products createProducts(Products pro){
     Products products = rep_Pro.createProducts(pro);
     return products;

    }
}
