package com.javarush.dao;

import com.javarush.models.Auto;
import com.javarush.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.javarush.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class UserDao {

    public User findById(int id) {
        return HibernateSessionFactoryUtil.getSession().get(User.class, id);
    }

    public void save(User user) {
        Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        HibernateSessionFactoryUtil.closeSession();
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        HibernateSessionFactoryUtil.closeSession();
    }

    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        HibernateSessionFactoryUtil.closeSession();
    }

    public Auto findAutoById(int id) {
        return HibernateSessionFactoryUtil.getSession().get(Auto.class, id);
    }

    public List<User> findAll() {
        List<User> users = (List<User>)  HibernateSessionFactoryUtil.getSession().createQuery("FROM User").list();
        return users;
    }
}
