package org.shop_n_happy.products.controller;

import org.shop_n_happy.products.model.Products;
import org.shop_n_happy.products.service.Service_Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class Products_Controller {

    @Autowired
    Service_Products serv_pro;

    @RequestMapping( method= RequestMethod.POST)
    public Products createProducts( @RequestBody Products pro){
        System.out.println("rhfghfdhgk");
       Products products =  serv_pro.createProducts(pro);
       System.out.println("78789r7");
       return products;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Products> fetchProducts(){
        return serv_pro.fetchProducts();
    }

}
