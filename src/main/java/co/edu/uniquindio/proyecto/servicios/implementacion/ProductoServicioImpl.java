package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.model.Categoria;
import co.edu.uniquindio.proyecto.model.Estado;
import co.edu.uniquindio.proyecto.model.Producto;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {

    // se utiliza el final por que Autowired no es recomendable por buena práctica    private final ProductoRepo productoRepo;
    private final UsuarioServicioImpl usuarioServicio;
    private final ProductoRepo productoRepo;

    @Override
    public int crearProducto(ProductoDTO productoDTO) throws Exception {

        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setUnidades(productoDTO.getUnidades());
        producto.setDescripcion(producto.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setFechaPublicacion(LocalDateTime.now());
        producto.setFechaLimiteProducto(LocalDateTime.now().plusDays(60));
        producto.setVendedor(usuarioServicio.obtener(productoDTO.getCodigoVendedor()));
        producto.setImagenesProducto(productoDTO.getImagenes());
        producto.setEstado(productoDTO.getEstado());
        producto.setCategoria(productoDTO.getCategorias());     // Estos toca corregirlos porque genera errores 27/03 3:02 Pm


        return productoRepo.save(producto).getCodigo();

    }
        @Override
        public int actualizarProducto ( int codigoProducto, ProductoDTO productoDTO) throws Exception {
            return 0;
        }

//        @Override
//        public int eliminarProducto ( int codigoProducto) throws Exception {
//            return 0;
//        }
//
//        @Override
//        public ProductoGetDTO obtenerProducto ( int codigoProducto) throws Exception {
//            return null;
//        }

//    @Override
//    public int agregarFavorito(int codigoUsuario, int codigoProducto) throws Exception {
//        return 0;
//    }
//
//    @Override
//    public int eliminarFavorito(int codigoUsuario, int codigoProducto) throws Exception {
//        return 0;
//    }
//
//    @Override
//        public List<ProductoGetDTO> listarProductosUsuario ( int codigoUsuario) throws Exception {
//            return null;
//        }

        public List<ProductoGetDTO> listarProductoNombre2 (String nombre) throws Exception{

            List<Producto> productos = productoRepo.listarProductoNombre(nombre);
            List<ProductoGetDTO> respuesta = new ArrayList<>();

            for (Producto p : productos) {
                respuesta.add(convertir(p));

            }

            return respuesta;
        }
        private ProductoGetDTO convertir2 (Producto producto){
            ProductoGetDTO productoGetDTO = new ProductoGetDTO(
                    producto.getCodigo(),
                    producto.getNombre(),
                    producto.getDescripcion(),
                    producto.getUnidades(),
                    producto.getPrecio(),
                    producto.getVendedor().getCodigo(),
                    producto.getImagenesProducto(),
                    producto.getCategoria(),
                    producto.getFechaLimiteProducto()
            );
            return productoGetDTO;

        }

    @Override
    public List<ProductoGetDTO> listarProductoFavoritos(int codigoUsuario) throws Exception {
    return null;
    }
    public int eliminarProducto ( int codigoProducto) throws Exception {
        return 0;
    }

    @Override
    public ProductoGetDTO obtenerProducto ( int codigoProducto) throws Exception {
        return null;
    }

    @Override
    public int agregarCarrito(int codigoProducto) throws Exception {
        return 0;
    }

    @Override
    public int agregarFavorito(int codigoUsuario, int codigoProducto) throws Exception {
        return 0;
    }

    @Override
    public int eliminarFavorito(int codigoUsuario, int codigoProducto) throws Exception {
        return 0;
    }

    @Override
    public List<ProductoGetDTO> listarProductosUsuario ( int codigoUsuario) throws Exception {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoria (Categoria categoria) throws Exception {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosEstado(Estado estado) throws Exception {
        return null;
    }




    public List<ProductoGetDTO> listarProductoNombre (String nombre) throws Exception{

        List<Producto> productos = productoRepo.listarProductoNombre(nombre);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for (Producto p : productos) {
            respuesta.add(convertir(p));

        }

        return respuesta;
    }
    private ProductoGetDTO convertir (Producto producto){
        ProductoGetDTO productoGetDTO = new ProductoGetDTO(
                producto.getCodigo(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getUnidades(),
                producto.getPrecio(),
                producto.getVendedor().getCodigo(),
                producto.getImagenesProducto(),
                producto.getCategoria(),
                producto.getFechaLimiteProducto()
        );
        return productoGetDTO;

    }


    @Override
    public List<ProductoGetDTO> listarProductosPrecio ( float precioMin, float precioMax) throws Exception {
        return null;
    }


    @Override
    public List<ProductoGetDTO> lsitarProductoPropio(int codigoUsuario) throws Exception {
        return null;
    }
}