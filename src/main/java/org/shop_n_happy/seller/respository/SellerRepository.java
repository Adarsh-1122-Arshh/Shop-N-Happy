package org.shop_n_happy.seller.respository;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.shop_n_happy.seller.model.Seller;
import org.springframework.stereotype.Repository;

@Repository
public class SellerRepository {


    public Seller createSeller(Seller seller){

        Seller s = new Seller();
        s.setSellerName(seller.getSellerName());
        s.setPhone(seller.getPhone());
        s.setSellerGst(seller.getSellerGst());
        s.setSellerAddress(seller.getSellerAddress());

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Seller.class).configure("Hibernate.cfg.xml");
        System.out.println("Hibernate Configuration loaded");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        System.out.println("Hibernate serviceRegistry created");

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(s);
        tx.commit();
        return s;
    }

}
