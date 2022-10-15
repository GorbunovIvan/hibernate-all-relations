package dao;

import models.House;
import models.Yard;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;

public class YardDAO implements DAO<Yard>  {

    @Override
    public void create(Yard yard) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.saveOrUpdate(yard);
            session.getTransaction().commit();
        }
    }

    @Override
    public Yard read(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.getReference(Yard.class, id);
        }
    }

    @Override
    public List<Yard> readAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return (List<Yard>) session.createQuery("FROM Yard").list();
        }
    }

    @Override
    public void update(Yard yard) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.update(yard);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Yard yard) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.delete(yard);
            session.getTransaction().commit();
        }
    }
}
