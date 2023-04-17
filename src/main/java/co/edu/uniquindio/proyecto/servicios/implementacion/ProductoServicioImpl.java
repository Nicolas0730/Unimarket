package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.model.Categoria;
import co.edu.uniquindio.proyecto.model.Estado;
import co.edu.uniquindio.proyecto.model.Producto;
<<<<<<< HEAD
import co.edu.uniquindio.proyecto.model.estadoPublicacion;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
=======
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
>>>>>>> 1a86a1cf6c9861c1ec78458cf3401c68c8881762
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {
<<<<<<< HEAD
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
=======

     // se utiliza el final por que Autowired no es recomendable por buena práctica
    private final  ProductoRepo productoRepo;
    private final UsuarioServicio usuarioServicio;


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
      //  producto.setImagenesProducto(productoDTO.getImagenes());
        producto.setEstado(productoDTO.getEstado());

 //      producto.setCategoria(productoDTO.getCategorias());     // Estos toca corregirlos porque genera errores 27/03 3:02 Pm


        return productoRepo.save(producto).getCodigo();
>>>>>>> 1a86a1cf6c9861c1ec78458cf3401c68c8881762
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
<<<<<<< HEAD
    public List<ProductoGetDTO> listarProductoNombre(String nombre)throws Exception {
        List<Producto> lista = productoRepo.listarProductosNombre(nombre);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista){
            respuesta.add( convertir(p) );
=======
    public List<ProductoGetDTO> listarProductoNombre(String nombre) {

        List <Producto> productos = productoRepo.listarProductoNombre(nombre);
        List <ProductoGetDTO> respuesta = new ArrayList<>();

        for ( Producto p : productos){
            respuesta.add(convertir(p));
>>>>>>> 1a86a1cf6c9861c1ec78458cf3401c68c8881762
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






 //falta terminar el convertir y mirar los mockups
    private ProductoGetDTO convertir ( Producto producto){
        ProductoGetDTO productoGetDTO = new ProductoGetDTO(
                producto.getCodigo(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getUnidades(),
                producto.getPrecio(),
                producto.getVendedor().getCodigo(),
                producto.getFechaLimiteProducto()
//                producto.getCategoria().name()

        );
        return productoGetDTO;
    }
}

    @Override
    public List<ProductoGetDTO> listarProductosPrecio(float precioMin, float precioMax) throws Exception{
        return null;
    }
}
