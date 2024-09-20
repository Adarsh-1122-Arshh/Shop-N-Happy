package org.shop_n_happy.products.service;

import jakarta.persistence.*;
import org.shop_n_happy.products.model.Products;

@Entity
@Table(name="productimages")
public class ProductImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name ="path")
    private String path;

    @ManyToMany
    @JoinColumn(name = "proId", referencedColumnName ="id")
    private Products product;
    @Transient
    private int proId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }
}
