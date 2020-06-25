package dao;

import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class SessionFactorySingleton {


    private SessionFactory sessionFactory;

    private static SessionFactorySingleton sessionFactorySingleton;

    private SessionFactorySingleton(){
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/studenti?serverTimezone=UTC");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "daniel123");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        properties.put(Environment.SHOW_SQL, "true");//
        properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.ENABLE_LAZY_LOAD_NO_TRANS, true);

        configuration.setProperties(properties);

        configuration.addAnnotatedClass(Studenti.class);
        configuration.addAnnotatedClass(Profesori.class);
        configuration.addAnnotatedClass(Orar.class);
        configuration.addAnnotatedClass(Sali.class);
        configuration.addAnnotatedClass(Cursuri.class);
        sessionFactory = configuration.buildSessionFactory();

    }

    public static SessionFactorySingleton getInstance(){
        if(sessionFactorySingleton  == null){
            sessionFactorySingleton = new SessionFactorySingleton();
        }
        return sessionFactorySingleton;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
