package com.javarush.utils;

import com.javarush.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {

    private static SessionFactory sessionFactory;
    private static Session session;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {

            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Auto.class);
            configuration.addAnnotatedClass(Wheel.class);
            configuration.addAnnotatedClass(Engine.class);
            configuration.addAnnotatedClass(GasStation.class);
            configuration.addAnnotatedClass(UsersAndGasStations.class);

            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

            sessionFactory = configuration.buildSessionFactory(builder.build());
        }

        return sessionFactory;

    }

    public static Session getSession() {

        if (session == null)
            session = getSessionFactory().openSession();

        return session;

    }

    public static void closeSession() {

        if (session != null) {
            session.close();
            session = null;
        }

    }

    public static void closeSessionFactory() {

        closeSession();

        if (sessionFactory != null) {
            sessionFactory.close();
            sessionFactory = null;
        }

    }
}