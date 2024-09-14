package org.shop_n_happy.products.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.shop_n_happy.seller.model.Seller;
import org.shop_n_happy.products.model.Products;
import org.shop_n_happy.products.service.Brand;
import org.shop_n_happy.products.service.Category;
import org.springframework.stereotype.Repository;

@Repository
public class Repository_Products {

    public Products createProducts(Products products){
        Products pro= new Products();
        Brand b = new Brand();
        Category cat = new Category();
        Seller seller = new Seller();

        pro.setTitle(products.getTitle());
        pro.setPrice(products.getPrice());
        pro.setWarranty(products.getWarranty());


        b.setId(products.getBrand_id());
        pro.setBrand(b);

        cat.setId(products.getCatId());
        pro.setCategory(cat);
        System.out.println(" seller id " + products.getSellerId());
        seller.setSellerId(products.getSellerId());
        pro.setSeller(seller);

      //  pro.setSellerId(products.getSellerId());
        pro.setDescription(products.getDescription());

        Configuration configuration = new Configuration();
        configuration
                .addAnnotatedClass(Products.class)
                .addAnnotatedClass(Brand.class)
                .addAnnotatedClass(Seller.class)
                .addAnnotatedClass(Category.class).configure("Hibernate.cfg.xml");
        System.out.println("succesfully configured");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        System.out.println("Hibernate serviceRegistry created");

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(pro);
        tx.commit();
        return pro;
    }
}
