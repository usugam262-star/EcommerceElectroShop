import dao.CategoriaDAO; // Añade si no existe
import dao.PedidoDAO;
import dao.ProductoDAO;
import dao.UsuarioDAO;
import model.Categoria;
import model.Pedido;
import model.Producto;
import model.Usuario;

import java.util.Date;

public class TestCRUD {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ProductoDAO productoDAO = new ProductoDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        CategoriaDAO categoriaDAO = new CategoriaDAO(); // Crea si no existe

        // Crear un Usuario
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan Perez");
        usuario.setEmail("juan@example.com");
        usuario.setPassword("pass123");
        usuario.setDireccion("Calle 123");
        usuarioDAO.create(usuario);

        // Crear una Categoria
        Categoria categoria = new Categoria();
        categoria.setNombre("Electrónica");
        categoria.setDescripcion("Dispositivos electrónicos");
        categoriaDAO.create(categoria); // Asegúrate de tener CategoriaDAO

        // Crear un Producto
        Producto producto = new Producto();
        producto.setNombre("Smartphone");
        producto.setDescripcion("Teléfono inteligente");
        producto.setPrecio(500.0);
        producto.setStock(10);
        producto.setCategoria(categoria); // Asigna la categoría creada
        productoDAO.create(producto);

        // Crear un Pedido
        Pedido pedido = new Pedido();
        pedido.setFecha(new Date());
        pedido.setTotal(500.0);
        pedido.setEstado("Pendiente");
        pedido.setUsuario(usuario);
        pedidoDAO.create(pedido);

        System.out.println("Usuario creado: " + usuario.getNombre());
        System.out.println("Producto creado.");
        System.out.println("Pedido creado.");
    }
}