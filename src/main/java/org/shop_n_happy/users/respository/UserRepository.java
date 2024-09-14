package org.shop_n_happy.users.respository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.shop_n_happy.users.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public User createUser(User user){
        System.out.println("--- signing up --- ");
        User u = new User();

        u.setName(user.getName());
        u.setAge(user.getAge());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());

        Configuration configuration = new Configuration().addAnnotatedClass(User.class)
                .configure("Hibernate.cfg.xml");
        System.out.println("succesfully configured");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        System.out.println("Hibernate serviceRegistry created");

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(u);
        tx.commit();
        return u;
    }

    public User userSignIn(User UserSignIn){
        Configuration configuration = new Configuration().addAnnotatedClass(User.class)
                .configure("Hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query userSelectQuery = session.createQuery("from User where email = :emailId and password = :password", User.class);
        userSelectQuery.setParameter("emailId", UserSignIn.getEmail());
        userSelectQuery.setParameter("password", UserSignIn.getPassword());
        User user = (User)userSelectQuery.getSingleResult();
        tx.commit();

        return user;
    }


}
