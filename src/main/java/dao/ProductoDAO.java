package dao;

import model.Producto;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductoDAO {
    public void create(Producto producto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(producto);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Producto read(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.get(Producto.class, id);
        } finally {
            session.close();
        }
    }

    public void update(Producto producto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(producto);
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
            Producto producto = session.get(Producto.class, id);
            if (producto != null) session.delete(producto);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}