package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.model.Categoria;
import co.edu.uniquindio.proyecto.model.Estado;
import co.edu.uniquindio.proyecto.model.Producto;
import co.edu.uniquindio.proyecto.model.estadoPublicacion;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {
    private final ProductoRepo productoRepo;
    private final UsuarioServicioImpl usuarioServicio;
    @Override
    public int crearProducto(ProductoDTO productoDTO)
    throws Exception {
        Producto producto=new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setUnidades(productoDTO.getUnidades());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setVendedor( usuarioServicio.obtener(productoDTO.getCodigoVendedor());
       // producto.setImagenesProducto(productoDTO.getImagenes());
        //producto.setCategoria(productoDTO.getCategorias());
        producto.setEstado(estadoPublicacion.APROBADO.RECHAZADO);
        //producto.setFechaCreacion tambien con local date
       // producto.setFechaLimiteProducto(LocalDateTime.now().plusDays(60));

     //los documentados generan error
        return productoRepo.save( producto ).getCodigo();
    }


    @Override
    public int actualizarProducto(int codigoProducto, ProductoDTO productoDTO)
            throws Exception{
        return 0;
    }

    @Override
    public int eliminarProducto(int codigoProducto) throws Exception {
        return 0;
    }

    @Override
    public ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception{
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario) throws Exception{
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoria(Categoria categoria) throws Exception{
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosEstado(Estado estado)throws Exception {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductoNombre(String nombre)throws Exception {
        List<Producto> lista = productoRepo.listarProductosNombre(nombre);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista){
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }
private ProductoGetDTO convertir (Producto producto){
        ProductoGetDTO productoGetDTO =new ProductoGetDTO(
                producto.getCodigo(),
                producto.getCategoria(),
                producto.getFechaLimiteProducto(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getUnidades(),
                producto.getPrecio(),
                producto.getVendedor().getCodigo(),
                producto.getImagenesProducto(),
                producto.getCategoria()
        );
        return productoGetDTO;

    @Override
    public List<ProductoGetDTO> listarProductosPrecio(float precioMin, float precioMax) {
        return null;
    }
}

    @Override
    public List<ProductoGetDTO> listarProductosPrecio(float precioMin, float precioMax) throws Exception{
        return null;
    }
}
