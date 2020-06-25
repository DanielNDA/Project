package dao;

import model.Cursuri;
import model.Orar;
import model.Studenti;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class OrarDao {

    private SessionFactory sessionFactory;


    public OrarDao() {
        SessionFactorySingleton sessionFactorySingleton = SessionFactorySingleton.getInstance();
        sessionFactory = sessionFactorySingleton.getSessionFactory();
    }

    public Orar findOrarByID(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Orar orar = session.find(Orar.class, id);
        transaction.commit();
        if (session != null) {
            session.close();
        }
        return orar;
    }


    public void deleteOrar(Orar orar) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(orar);
        transaction.commit();
        if (session != null) {
            session.close();
        }
    }

    public void addOrar(Orar orar) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(orar);
        transaction.commit();
        if (session != null) {
            session.close();
        }
    }

    public List<Orar> getAllOrar() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<Orar> query = session.createQuery("from Orar", Orar.class);
        List<Orar> orarList = query.getResultList();
        transaction.commit();
        if (session != null) {
            session.close();
        }
        return orarList;
    }

    public void updateOrar(Orar orar) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(orar);
        transaction.commit();
        if (session != null) {
            session.close();
        }

    }
}
