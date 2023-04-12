package lk.ijse.Hostel_Management_System.util;
import lk.ijse.Hostel_Management_System.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.util.Properties;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private static SessionFactory sessionFactory;

    private FactoryConfiguration() {
        try {
//            Configuration configuration = new Configuration();
//            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//            configuration
//            .addAnnotatedClass(Student.class)
//            .addAnnotatedClass(Room.class)
//            .addAnnotatedClass(Reservation.class)
//            .addAnnotatedClass(User.class);
//            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            sessionFactory = new Configuration()
                    .mergeProperties(getProperties())
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Room.class)
                    .addAnnotatedClass(Reservation.class)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("There is issue in factory Configuration");
        }
    }

    public static Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader
                    .getSystemClassLoader()
                    .getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            System.out.println("Property file not found!");
            e.printStackTrace();
        }
        return properties;
    }

    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

}
