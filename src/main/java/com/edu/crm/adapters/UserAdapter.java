package com.edu.crm.adapters;

import com.edu.crm.db.HibernateSessionFactoryUtil;
import com.edu.crm.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class UserAdapter{

    public User read(long id) {
            Session session = HibernateSessionFactoryUtil.getSession();
            Transaction tx = session.beginTransaction();
            User user = session.get(User.class, id);
            session.close();
            return user;
    }
    public void create(User user){
        try {
            Session session = HibernateSessionFactoryUtil.getSession();
            Transaction tx = session.beginTransaction();
            session.save(user);
            tx.commit();
            session.close();
        } catch (Exception ex){
            System.out.println("Trouble create:"+ ex);
        }
    }

    public void update(User user) {
            Session session = HibernateSessionFactoryUtil.getSession();
            Transaction tx = session.beginTransaction();
            session.update(user);
            tx.commit();
            session.close();
    }

    public boolean delete(User user){
        try {
            Session session = HibernateSessionFactoryUtil.getSession();
            Transaction tx = session.beginTransaction();
            session.delete(user);
            tx.commit();
            session.close();
            return true;
        } catch (Exception ex){
            System.out.println("Trouble delete:"+ ex);
            return false;
        }
    }
}
