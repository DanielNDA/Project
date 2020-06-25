package dao;

import model.Profesori;
import model.Studenti;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProfesoriDao {

    private SessionFactory sessionFactory;


    public ProfesoriDao() {
        SessionFactorySingleton sessionFactorySingleton = SessionFactorySingleton.getInstance();
        sessionFactory = sessionFactorySingleton.getSessionFactory();
    }
    public Profesori findProfesorByID(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Profesori profesori = session.find(Profesori.class, id);
        transaction.commit();
        if (session != null) {
            session.close();
        }
        return profesori;
    }


    public void deleteProfesor(Profesori profesori) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(profesori);
        transaction.commit();
        if (session != null) {
            session.close();
        }
    }

    public void addProfesor(Profesori profesori) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(profesori);
        transaction.commit();
        if (session != null) {
            session.close();
        }
    }

    public List<Profesori> getAllProfesori() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<Profesori> query = session.createQuery("from Profesori", Profesori.class);
        List<Profesori> profesoriList = query.getResultList();
        transaction.commit();
        if (session != null) {
            session.close();
        }
        return profesoriList;
    }

}
