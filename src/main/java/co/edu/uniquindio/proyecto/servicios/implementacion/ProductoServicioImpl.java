package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.model.Categoria;
import co.edu.uniquindio.proyecto.model.Estado;
import co.edu.uniquindio.proyecto.model.Producto;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicioImpl implements ProductoServicio {
    @Autowired
    private ProductoRepo productoRepo;

    @Override
    public int crearProducto(ProductoDTO productoDTO) throws Exception {
        Producto buscado= productoRepo.buscarProducto(productoDTO.getCodigoVendedor());
        if (buscado!=null){
            throw new Exception("El código del producto "+productoDTO.getNombre()+" ya existe");
        }
        Producto producto = convertirProducto(productoDTO);
        return 0;//productoRepo.save(producto).getCodigo(); //seria CodigoVendedor o codigo del producto
    }

    /**
     * Método que convierte un productoDTO en producto
     * @param productoDTO
     * @return
     */
    private Producto convertirProducto(ProductoDTO productoDTO) {

        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setUnidades(productoDTO.getUnidades());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setCodigoVendedor(productoDTO.getCodigoVendedor());
        producto.setImagenesProducto(productoDTO.getImagenes());
        producto.setCategoria(productoDTO.getCategorias());

        return producto;
    }

    @Override
    public int actualizarProducto(int codigoProducto, ProductoDTO productoDTO) {
        return 0;
    }

    @Override
    public int eliminarProducto(int codigoProducto) {
        return 0;
    }

    @Override
    public ProductoGetDTO obtenerProducto(int codigoProducto) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoria(Categoria categoria) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosEstado(Estado estado) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductoNombre(String nombre) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPrecio(float precioMin, float precioMax) {
        return null;
    }
}
