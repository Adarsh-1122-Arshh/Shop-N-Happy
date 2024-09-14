package org.shop_n_happy.seller.model;

import jakarta.persistence.*;

@Entity
@Table(name="seller")

public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int sellerId ;

    @Column(name="Name")
    private String sellerName;

    @Column(name = "phone")
    private String phone;



    @Column(name = "sellerGst")
    private String sellerGst ;

    @Column(name = "sellerAddress")
    private String sellerAddress;



    public int getSellerId(){
        return sellerId;
    }
    public void setSellerId( int  sellerId){
        this.sellerId = sellerId;
    }

    public String getSellerName(){
        return sellerName;

    }

    public void setSellerName (String sellerName ){
        this.sellerName = sellerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSellerGst() {
        return sellerGst;
    }

    public void setSellerGst(String sellerGst) {
        this.sellerGst = sellerGst;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }
    public void setSellerAddress(String sellerAddress){
        this.sellerAddress = sellerAddress;
    }

}
