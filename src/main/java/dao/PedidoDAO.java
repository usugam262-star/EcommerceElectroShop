package dao;

import model.Pedido;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PedidoDAO {
    public void create(Pedido pedido) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(pedido);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Pedido read(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.get(Pedido.class, id);
        } finally {
            session.close();
        }
    }

    public void update(Pedido pedido) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(pedido);
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
            Pedido pedido = session.get(Pedido.class, id);
            if (pedido != null) session.delete(pedido);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}