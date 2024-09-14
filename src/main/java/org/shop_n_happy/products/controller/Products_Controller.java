package org.shop_n_happy.products.controller;

import org.shop_n_happy.products.model.Products;
import org.shop_n_happy.products.service.Service_Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class Products_Controller {

    @Autowired
    Service_Products serv_pro;

    @PostMapping
    public Products createProducts( @RequestBody Products pro){
        System.out.println("rhfghfdhgk");
       Products products =  serv_pro.createProducts(pro);
       System.out.println("78789r7");
       return products;
    }
}
