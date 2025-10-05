import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestConexion {
    public static void main(String[] args) {
        SessionFactory factory = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            System.out.println("Conexión exitosa!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory != null && !factory.isClosed()) {
                factory.close();
            }
        }
    }
}