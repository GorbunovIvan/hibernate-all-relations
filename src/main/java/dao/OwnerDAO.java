package dao;

import models.Owner;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;

public class OwnerDAO implements DAO<Owner>  {

    @Override
    public void create(Owner owner) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.saveOrUpdate(owner);
            session.getTransaction().commit();
        }
    }

    @Override
    public Owner read(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.getReference(Owner.class, id);
        }
    }

    @Override
    public List<Owner> readAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return (List<Owner>) session.createQuery("FROM Owner").list();
        }
    }

    @Override
    public void update(Owner owner) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.update(owner);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Owner owner) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.delete(owner);
            session.getTransaction().commit();
        }
    }
}
