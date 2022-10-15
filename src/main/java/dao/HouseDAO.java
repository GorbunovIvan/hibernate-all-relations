package dao;

import models.House;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;

import java.util.List;

public class HouseDAO implements DAO<House>  {

    @Override
    public void create(House house) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.saveOrUpdate(house);
            session.getTransaction().commit();
        }
    }

    @Override
    public House read(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.getReference(House.class, id);
        }
    }

    @Override
    public List<House> readAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return (List<House>) session.createQuery("FROM House").list();
        }
    }

    @Override
    public void update(House house) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.update(house);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(House house) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.delete(house);
            session.getTransaction().commit();
        }
    }
}
