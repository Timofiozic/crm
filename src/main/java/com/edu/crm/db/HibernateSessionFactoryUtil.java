package com.edu.crm.db;

import com.edu.crm.model.Order;
import com.edu.crm.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    public static Session getSession() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Order.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
//                Hibernate 6Alpha connection approach
//                final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
//                sessionFactory = new MetadataSources(registry)
//                        .addAnnotatedClasses(
//                        User.class,
//                        Order.class)
//                        .buildMetadata().buildSessionFactory();
            } catch (Exception ex) {
                System.out.println("Исключение в создании сессии " + ex);
                throw ex;
            }
        }
        return sessionFactory.openSession();
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
    }
}
