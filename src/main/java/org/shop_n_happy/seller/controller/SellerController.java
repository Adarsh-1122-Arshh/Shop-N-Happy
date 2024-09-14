package org.shop_n_happy.seller.controller;


import org.shop_n_happy.seller.model.Seller;
import org.shop_n_happy.seller.servces.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")

public class SellerController {
@Autowired
SellerService sellerservice;
@PostMapping
    public Seller createSellers(@RequestBody Seller seller){

    Seller s = sellerservice.createSeller(seller);
    return s;
}
}
