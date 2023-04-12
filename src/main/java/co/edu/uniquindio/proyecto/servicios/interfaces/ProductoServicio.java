package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.model.Categoria;
import co.edu.uniquindio.proyecto.model.Estado;

import java.util.List;

public interface ProductoServicio {

    int crearProducto(ProductoDTO productoDTO) throws Exception;
    int actualizarProducto(int codigoProducto,ProductoDTO productoDTO) throws Exception;
    int eliminarProducto(int codigoProducto) throws Exception;
    ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception;
    List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario) throws Exception;
    List<ProductoGetDTO> listarProductosCategoria(Categoria categoria) throws Exception;//Es una enumeracion
    List<ProductoGetDTO> listarProductosEstado(Estado estado) throws Exception;
    List<ProductoGetDTO> listarProductoNombre(String nombre) throws Exception;
    List<ProductoGetDTO> listarProductosPrecio(float precioMin, float precioMax) throws Exception;
    List<ProductoGetDTO> listarProductoFavoritos(int codigoUsuario) throws Exception;

}
