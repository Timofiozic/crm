package com.edu.crm.adapters;

import com.edu.crm.db.HibernateSessionFactoryUtil;
import com.edu.crm.model.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderAdapter {

    public Orders read(long id) {
        try{
            return HibernateSessionFactoryUtil.getSession().get(Orders.class, id);
        } catch (Exception ex){
            System.out.println("Trouble read:"+ ex);
            return null;
        }

    }
    public boolean create(Orders order){
        try {
            Session session = HibernateSessionFactoryUtil.getSession();
            Transaction tx = session.beginTransaction();
            session.save(order);
            tx.commit();
            session.close();
            return true;
        } catch (Exception ex){
            System.out.println("Trouble create:"+ ex);
            return false;
        }
    }

    public boolean update(Orders order){
        try {
            Session session = HibernateSessionFactoryUtil.getSession();
            Transaction tx = session.beginTransaction();
            session.update(order);
            tx.commit();
            session.close();
            return true;

        } catch (Exception ex){
            System.out.println("Trouble update:"+ ex);
            return false;
        }

    }

    public boolean delete(Orders order){
        try {
            Session session = HibernateSessionFactoryUtil.getSession();
            Transaction tx = session.beginTransaction();
            session.delete(order);
            tx.commit();
            session.close();
            return true;
        } catch (Exception ex){
            System.out.println("Trouble delete:"+ ex);
            return false;
        }
    }
}

