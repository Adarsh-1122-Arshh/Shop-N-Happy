package org.shop_n_happy.products.service;

import org.shop_n_happy.products.model.Products;
import org.shop_n_happy.products.repository.Repository_Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Service_Products {
    @Autowired
    Repository_Products rep_Pro;


    public Products createProducts(Products pro){
     Products product = rep_Pro.createProducts(pro);
     for(ProductImages productImage : pro.getProductImage()){
         productImage.setProduct(product);
         rep_Pro.createProductImage(productImage);

     }
     return product;
    }

    public List<Products> fetchProducts(){

        return rep_Pro.fetchProducts();
    }
}
