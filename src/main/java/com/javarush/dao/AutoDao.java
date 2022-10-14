package com.javarush.dao;

import com.javarush.models.Auto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.javarush.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class AutoDao {

    public Auto findById(int id) {
        return HibernateSessionFactoryUtil.getSession().get(Auto.class, id);
    }

    public void save(Auto auto) {
        Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx1 = session.beginTransaction();
        session.save(auto);
        tx1.commit();
        HibernateSessionFactoryUtil.closeSession();
    }

    public void update(Auto auto) {
        Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx1 = session.beginTransaction();
        session.update(auto);
        tx1.commit();
        HibernateSessionFactoryUtil.closeSession();
    }

    public void delete(Auto auto) {
        Session session = HibernateSessionFactoryUtil.getSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(auto);
        tx1.commit();
        HibernateSessionFactoryUtil.closeSession();
    }

    public Auto findAutoById(int id) {
        return HibernateSessionFactoryUtil.getSession().get(Auto.class, id);
    }

    public List<Auto> findAll() {
        List<Auto> autos = (List<Auto>)  HibernateSessionFactoryUtil.getSession().createQuery("FROM Auto").list();
        return autos;
    }
}
