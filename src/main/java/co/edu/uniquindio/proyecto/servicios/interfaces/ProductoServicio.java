package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.model.Categoria;
import co.edu.uniquindio.proyecto.model.Estado;
import co.edu.uniquindio.proyecto.model.Producto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public interface ProductoServicio {

    int creaProducto (ProductoDTO productoDTO ) throws Exception;

    int actualizarProductos ( int codigoProducto, ProductoGetDTO productoGetDTO) throws Exception;

    int actualizarUnidades(int codigoProducto, int unidades ) throws Exception;

    int actualizarEstado (int codigoProducto, Estado estado) throws Exception;

    int eliminarProducto (int codigoProducto) throws Exception;

    void crearFavorito (int codigoUsuario, int codigoProducto) throws Exception;

    void eliminarFavorito ( int codigoUsuario, int codigoProducto) throws Exception;

    Producto obtener (int codigo) throws Exception;

    ProductoGetDTO obtenerProducto ( int codigoProducto) throws Exception;

    List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario);

    List<ProductoGetDTO> listarProductosCategoria(Categoria categoria);

    List<ProductoGetDTO> listarProductosPorEstado(Estado estado);

    List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario);

    List<ProductoGetDTO> listarProductosNombre(String nombre);

    List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo);





}
