package com.edu.crm.adapters;

import com.edu.crm.db.HibernateSessionFactoryUtil;
import com.edu.crm.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserAdapter{
    public User read(long id) {
        try{
            Session session = HibernateSessionFactoryUtil.getSession();
            Transaction tx = session.beginTransaction();
            User user = session.get(User.class, id);
            session.close();
            return user;
        } catch (Exception ex){
            System.out.println("Trouble read:"+ ex);
            return null;
        }

    }
    public boolean create(User user){
        try {
            Session session = HibernateSessionFactoryUtil.getSession();
            Transaction tx = session.beginTransaction();
            session.save(user);
            tx.commit();
            session.close();
            return true;
        } catch (Exception ex){
            System.out.println("Trouble create:"+ ex);
            return false;
        }
    }

    public boolean update(User user){
        try {
            Session session = HibernateSessionFactoryUtil.getSession();
            Transaction tx = session.beginTransaction();
            session.update(user);
            tx.commit();
            session.close();
            return true;

        } catch (Exception ex){
            System.out.println("Trouble update:"+ ex);
            return false;
        }

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
