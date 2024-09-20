package org.shop_n_happy.products.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.shop_n_happy.products.service.ProductImages;
import org.shop_n_happy.seller.model.Seller;
import org.shop_n_happy.products.model.Products;
import org.shop_n_happy.products.service.Brand;
import org.shop_n_happy.products.service.Category;
import org.shop_n_happy.users.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Repository_Products {

    public Products createProducts(Products products){
        Products pro= new Products();
        Brand b = new Brand();
        Category cat = new Category();
        Seller seller = new Seller();
        ProductImages proImg = new ProductImages();

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

        proImg.setId(products.getImageId());

      //  pro.setSellerId(products.getSellerId());
        pro.setDescription(products.getDescription());


        Configuration configuration = new Configuration();
        configuration
                .addAnnotatedClass(Products.class)
                .addAnnotatedClass(Brand.class)
                .addAnnotatedClass(Seller.class)
                .addAnnotatedClass(Category.class)
                .configure("Hibernate.cfg.xml");
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


    public ProductImages createProductImage(ProductImages productImage) {
        ProductImages proImg = new ProductImages();
        Products pro = new Products();

        proImg.setPath(productImage.getPath());

        pro.setId(productImage.getId());
        proImg.setProduct(pro);

        Configuration configuration = new Configuration();
        configuration
                .addAnnotatedClass(ProductImages.class)
                .addAnnotatedClass(Products.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(proImg);
        tx.commit();
        return proImg;
    }

    public List<Products> fetchProducts() {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Products.class)
                .addAnnotatedClass(Brand.class)
                .addAnnotatedClass(Seller.class)
                .addAnnotatedClass(Category.class)
                .configure("Hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query userSelectQuery = session.createQuery("from Products", Products.class);
        // here we are returning multiple products , so use List Interface and products is typecated to List (List<Products>)
        List <Products> products = (List<Products>) userSelectQuery.getResultList();
        tx.commit();
        return products;

    }
}
