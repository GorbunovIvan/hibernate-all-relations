package utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory != null)
            return sessionFactory;

        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(models.House.class);
        configuration.addAnnotatedClass(models.Owner.class);
        configuration.addAnnotatedClass(models.OwnersAndHousesRegistration.class);
        configuration.addAnnotatedClass(models.Street.class);
        configuration.addAnnotatedClass(models.Yard.class);

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

        sessionFactory = configuration.buildSessionFactory(builder.build());

        return sessionFactory;

    }

    public static void closeSessionFactory() {

        if (sessionFactory == null)
            return;

        sessionFactory.close();
        sessionFactory = null;

    }

}
