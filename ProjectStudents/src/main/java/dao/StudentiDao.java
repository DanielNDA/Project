package dao;

import model.Studenti;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentiDao {

    private SessionFactory sessionFactory;


    public StudentiDao() {
        SessionFactorySingleton sessionFactorySingleton = SessionFactorySingleton.getInstance();
        sessionFactory = sessionFactorySingleton.getSessionFactory();
    }

    public Studenti findStudentByID(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Studenti studenti = session.find(Studenti.class, id);
        transaction.commit();
        if (session != null) {
            session.close();
        }
        return studenti;
    }


    public void deleteStudent(Studenti studenti) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(studenti);
        transaction.commit();
        if (session != null) {
            session.close();
        }
    }

    public void addStudent(Studenti studenti) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(studenti);
        transaction.commit();
        if (session != null) {
            session.close();
        }
    }

    public List<Studenti> getAllStudents() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<Studenti> query = session.createQuery("from Studenti", Studenti.class);
        List<Studenti> studentiList = query.getResultList();
        transaction.commit();
        if (session != null) {
            session.close();
        }
        return studentiList;
    }

    public void updateStudent(Studenti studenti) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(studenti);
        transaction.commit();
        if (session != null) {
            session.close();
        }


    }
}