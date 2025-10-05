package dao;

import model.Categoria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CategoriaDAO {
    public void create(Categoria categoria) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(categoria);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Categoria read(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.get(Categoria.class, id);
        } finally {
            session.close();
        }
    }

    public void update(Categoria categoria) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(categoria);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Categoria categoria = session.get(Categoria.class, id);
            if (categoria != null) session.delete(categoria);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}