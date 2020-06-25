package dao;

import model.Cursuri;
import model.Profesori;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CursDao {

    private SessionFactory sessionFactory;


    public CursDao() {
        SessionFactorySingleton sessionFactorySingleton = SessionFactorySingleton.getInstance();
        sessionFactory = sessionFactorySingleton.getSessionFactory();
    }
    public Cursuri findCursByID(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Cursuri cursuri = session.find(Cursuri.class, id);
        transaction.commit();
        if (session != null) {
            session.close();
        }
        return cursuri;
    }


    public void deleteCursuri(Cursuri cursuri) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(cursuri);
        transaction.commit();
        if (session != null) {
            session.close();
        }
    }

    public void addCursuri(Cursuri cursuri) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(cursuri);
        transaction.commit();
        if (session != null) {
            session.close();
        }
    }

    public List<Cursuri> getAllCursuri() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<Cursuri> query = session.createQuery("from Cursuri", Cursuri.class);
        List<Cursuri> cursuriList = query.getResultList();
        transaction.commit();
        if (session != null) {
            session.close();
        }
        return cursuriList;
    }

}

