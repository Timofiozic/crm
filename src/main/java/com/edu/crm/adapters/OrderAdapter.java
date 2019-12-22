package com.edu.crm.adapters;

import com.edu.crm.db.HibernateSessionFactoryUtil;
import com.edu.crm.model.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class OrderAdapter {

    public Order read(Long id) {
        return HibernateSessionFactoryUtil.getSession().get(Order.class, id);
    }

    public Long create(Order order) {
        Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx = session.beginTransaction();
        Long generatedId = (Long) session.save(order);
        tx.commit();
        session.close();
        return generatedId;
    }

    public void update(Order order) {
        Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.update(order);
        tx.commit();
        session.close();
    }

    public void delete(Order order) {
        Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.delete(order);
        tx.commit();
        session.close();
    }
}

