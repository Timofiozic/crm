package com.edu.crm.adapters;

import com.edu.crm.db.HibernateSessionFactoryUtil;
import com.edu.crm.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class UserAdapter {

    private static final Logger logger = LogManager.getLogger(UserAdapter.class);

    public User read(Long id) {
        Session session = HibernateSessionFactoryUtil.getSession();
        logger.debug("Retrieving by id: {} ", id);
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public Long create(User user) {
        Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx = session.beginTransaction();
        Long generatedId = (Long) session.save(user);
        tx.commit();
        session.close();
        return generatedId;
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.delete(user);
        tx.commit();
        session.close();
    }
}
