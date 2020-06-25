package dao;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Properties;

public class GenericDao<T> {

   private SessionFactory sessionFactory;

    public GenericDao() {
        SessionFactorySingleton sessionFactorySingleton = SessionFactorySingleton.getInstance();
        sessionFactory = sessionFactorySingleton.getSessionFactory();
    }
/*
    public GenericDao() {

        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/studenti?serverTimezone=UTC");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "daniel123");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        properties.put(Environment.SHOW_SQL, "true");//
        properties.put(Environment.HBM2DDL_AUTO, "update");

        configuration.setProperties(properties);

        configuration.addAnnotatedClass(Studenti.class);
        configuration.addAnnotatedClass(Profesori.class);
        configuration.addAnnotatedClass(Orar.class);
        configuration.addAnnotatedClass(Sali.class);
        configuration.addAnnotatedClass(Cursuri.class);


        sessionFactory = configuration.buildSessionFactory();
    }

    */

    public void add(T object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(object);
        transaction.commit();
    }

    public void update(T object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
    }

    public void delete(T object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
    }

    public List<T> getAll(T object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from " + object.getClass().getName());
        List<T> results = query.getResultList();
        transaction.commit();
        return results;
    }

    public T findById(T object, int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from " + object.getClass().getName() + " where id=" + id + "");
        T result = (T) query.getSingleResult();
        transaction.commit();
        return result;

        /*
         List<T>  results = query.getResultList();
         return results.get(0);
         */
    }

    public List<T> findByColumn(T object, String column, String value) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from " + object.getClass().getName() + " where " + column + "='" + value + "'");
        List<T> results = query.getResultList();
        transaction.commit();
        return results;

    }
}
