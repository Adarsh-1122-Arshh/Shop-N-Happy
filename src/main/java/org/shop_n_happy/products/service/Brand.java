package org.shop_n_happy.products.service;

import jakarta.persistence.*;

@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String brandName;
    @Column(name = "symbol")
    private String brandSymbol;

    public String getBrandSymbol() {
        return brandSymbol;
    }
    public void setBrandSymbol(String brandSymbol) {
        this.brandSymbol = brandSymbol;
    }

    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
