package dao;

import models.OwnersAndHousesRegistration;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;

public class OwnersAndHousesRegistrationDAO implements DAO<OwnersAndHousesRegistration>  {

    @Override
    public void create(OwnersAndHousesRegistration registration) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.saveOrUpdate(registration);
            session.getTransaction().commit();
        }
    }

    @Override
    public OwnersAndHousesRegistration read(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.getReference(OwnersAndHousesRegistration.class, id);
        }
    }

    @Override
    public List<OwnersAndHousesRegistration> readAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return (List<OwnersAndHousesRegistration>) session.createQuery("FROM OwnersAndHousesRegistration").list();
        }
    }

    @Override
    public void update(OwnersAndHousesRegistration registration) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.update(registration);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(OwnersAndHousesRegistration registration) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.delete(registration);
            session.getTransaction().commit();
        }
    }
}
