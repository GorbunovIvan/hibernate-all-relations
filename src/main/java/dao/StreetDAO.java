package dao;

import models.Street;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;

public class StreetDAO implements DAO<Street>  {

    @Override
    public void create(Street street) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.saveOrUpdate(street);
            session.getTransaction().commit();
        }
    }

    @Override
    public Street read(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.getReference(Street.class, id);
        }
    }

    @Override
    public List<Street> readAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return (List<Street>) session.createQuery("FROM Street").list();
        }
    }

    @Override
    public void update(Street street) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.update(street);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Street street) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.delete(street);
            session.getTransaction().commit();
        }
    }
}
