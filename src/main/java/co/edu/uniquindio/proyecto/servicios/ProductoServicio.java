package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.model.Categoria;
import co.edu.uniquindio.proyecto.model.Estado;

import java.util.List;

public interface ProductoServicio {

    int crearProducto(ProductoDTO productoDTO);
    int actualizarProducto(int codigoProducto,ProductoDTO productoDTO);
    int eliminarProducto(int codigoProducto);
    ProductoGetDTO obtenerProducto(int codigoProducto);
    List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario);
    List<ProductoGetDTO> listarProductosCategoria(Categoria categoria);//Es una enumeracion
    List<ProductoGetDTO> listarProductosEstado(Estado estado);
    List<ProductoGetDTO> listarProductoNombre(String nombre);
    List<ProductoGetDTO> listarProductosPrecio(float precioMin, float precioMax);

}
