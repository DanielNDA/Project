package dao;

import model.Cursuri;
import model.Sali;
import model.Studenti;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SaliDao {

    private SessionFactory sessionFactory;


    public SaliDao() {
        SessionFactorySingleton sessionFactorySingleton = SessionFactorySingleton.getInstance();
        sessionFactory = sessionFactorySingleton.getSessionFactory();
    }

    public void addSala(Sali sali) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(sali);
        transaction.commit();
        if (session != null) {
            session.close();
        }
    }

    public List<Sali> getAllSali() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<Sali> query = session.createQuery("from Sali", Sali.class);
        List<Sali> saliList = query.getResultList();
        transaction.commit();
        if (session != null) {
            session.close();
        }
        return saliList;
    }

    public void updateSala(String sali) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(sali);
        transaction.commit();
        if (session != null) {
            session.close();
        }
    }

    public Sali findSalaByID(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Sali sali = session.find(Sali.class, id);
        transaction.commit();
        if (session != null) {
            session.close();
        }
        return sali;
    }
}