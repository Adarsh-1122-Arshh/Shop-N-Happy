package org.shop_n_happy.seller.servces;

import org.shop_n_happy.seller.model.Seller;
import org.shop_n_happy.seller.respository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class SellerService {
    @Autowired
    SellerRepository sellerrepository;

   public Seller createSeller(Seller seller){
       Seller s= sellerrepository.createSeller(seller);
       return s;
   }

}