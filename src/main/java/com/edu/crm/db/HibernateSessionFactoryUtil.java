package com.edu.crm.db;

import com.edu.crm.model.Orders;
import com.edu.crm.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil  {
    private static SessionFactory sessionFactory;
    private HibernateSessionFactoryUtil() {}
    public static Session getSession()
    {
        if (sessionFactory == null) {
         try{
             Configuration configuration = new Configuration().configure();
             configuration.addAnnotatedClass(User.class);
             configuration.addAnnotatedClass(Orders.class);
             StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
             sessionFactory = configuration.buildSessionFactory(builder.build());

         } catch (Exception ex){
             System.out.println("Исключение в создании сессии "+ex);
         }
        }
        return sessionFactory.openSession();
    }
    public static void closeSessionFactory(){
        sessionFactory.close();
    }
}
