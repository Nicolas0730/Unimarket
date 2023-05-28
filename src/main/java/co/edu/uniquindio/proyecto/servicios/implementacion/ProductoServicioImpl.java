package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.model.Categoria;
import co.edu.uniquindio.proyecto.model.Estado;
import co.edu.uniquindio.proyecto.model.Producto;
import co.edu.uniquindio.proyecto.model.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
          validarExiste(codigoProducto);

          Producto producto = convertirProducto(productoDTO);
          producto.setCodigo(codigoProducto);

            return productoRepo.save(producto).getCodigo();
        }


        public boolean validarExiste(int codigoProd) throws Exception {
        boolean e = productoRepo.existsById(codigoProd);
        if (!e){
            throw new Exception("El Producto no existe en la base de datos");
        }

        return e;

        }

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
        List<Producto> productos = productoRepo.listarProductoFavoritos(codigoUsuario);

        List<ProductoGetDTO> respuesta = new ArrayList<>();
        for (Producto p : productos) {
            respuesta.add(convertir(p));
        }
        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductos() {
        List<Producto> lista = productoRepo.listarProductos();
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista){
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }

    /**
     * Método que elimina un producto dado su codigo
     * @param codigoProducto
     * @return
     * @throws Exception
     */
    public int eliminarProducto ( int codigoProducto) throws Exception {
        Optional<Producto> producto= productoRepo.findById(codigoProducto);
        if (producto.isEmpty()){
            throw new Exception("El producto a eliminar no existe.");
        }
        productoRepo.deleteById(codigoProducto);
        return codigoProducto;
    }

    /**
     * Obtiene un producto dado su código y realiza su búsqueda en la BD
     *
     * @param codigoProducto a buscar en la BD
     * @return ProductoGetDTO si este existe
     * @throws Exception Si al realizar la busqueda, el producto está vacío se lanza una excepción
     */
    @Override
    public ProductoGetDTO obtenerProducto ( int codigoProducto) throws Exception {
        Optional<Producto> producto = productoRepo.findById(codigoProducto);

        if (producto.isEmpty()){
            throw new Exception("ERROR, El producto con el código "+codigoProducto+" no existe");
        }
        ProductoGetDTO productoGetDTO= convertir(producto.get());

        return productoGetDTO;
    }

    @Override
    public Producto obtener(int codigoProducto) throws Exception {
        return null;
    }

    @Override
    public int agregarCarrito(int codigoProducto) throws Exception {
        return 0;
    }

    /**
     * Método que agrega un producto a favorito de un usuario
     * @param codigoUsuario del usuario al que será agregado le producto
     * @param codigoProducto del producto que será agregado
     * @return codigo del producto agregado a favoritos
     * @throws Exception
     */
    @Override
    public int agregarFavorito(int codigoUsuario, int codigoProducto) throws Exception {
        Usuario usuario =null;
        usuario = usuarioServicio.obtener(codigoUsuario);
        Producto producto = convertirProducto2(obtenerProducto(codigoProducto));

        usuario.getProductosFav().add(producto);
        return codigoProducto;
    }

    /**
     * Método que elimina un producto favorito de un usuario
     * @param codigoUsuario del usuario que va a eliminar el favorito
     * @param codigoProducto del producto que será eliminado
     * @return codigo del producto eliminado
     * @throws Exception
     */
    @Override
    public int eliminarFavorito(int codigoUsuario, int codigoProducto) throws Exception {

        Usuario usuario =null;
        usuario = usuarioServicio.obtener(codigoUsuario);
        Producto producto = convertirProducto2(obtenerProducto(codigoProducto));

        usuario.getProductosFav().remove(producto);
        return codigoProducto;
    }

    @Override
    public List<ProductoGetDTO> listarProductosUsuario ( int codigoUsuario) throws Exception {

        List<Producto> productos = productoRepo.listarProductosUsuario(codigoUsuario);
        List<ProductoGetDTO> respuesta = new ArrayList<>();
        for (Producto p : productos) {
            respuesta.add(convertir(p));
        }
        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoria (Categoria categoria) throws Exception {
        List<Producto> productos = productoRepo.listarProductosCategoria(categoria);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for (Producto p : productos) {
            respuesta.add(convertir(p));
        }
        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosEstado(Estado estado) throws Exception {

        List<Producto> productos = productoRepo.listarProductosEstado(estado);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for (Producto p : productos) {
            respuesta.add(convertir(p));
        }
        return respuesta;
    }

    public List<ProductoGetDTO> listarProductoNombre (String nombre) throws Exception{

        List<Producto> productos = productoRepo.listarProductoNombre(nombre);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for (Producto p : productos) {
            respuesta.add(convertir(p));

        }
        return respuesta;
    }

    /**
     * Método que convierte un producto en un productoGetDTO
     * @param producto
     * @return
     */
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

    /**
     * Método que convierte un productoDTO en un producto
     * @param productoDTO
     * @return
     */
    private Producto convertirProducto(ProductoDTO productoDTO){
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setUnidades(productoDTO.getUnidades());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setImagenesProducto(productoDTO.getImagenes());
        producto.setCategoria(productoDTO.getCategorias());
        producto.setEstado(productoDTO.getEstado());

        return producto;

    }

    /**
     * Método que convierte un productoGetDTO en un producto
     * @param productoGetDTO
     * @return
     */
    private Producto convertirProducto2(ProductoGetDTO productoGetDTO) throws Exception {
        Producto producto = new Producto();
        producto.setNombre(productoGetDTO.getNombre());
        producto.setDescripcion(productoGetDTO.getDescripcion());
        producto.setUnidades(productoGetDTO.getUnidades());
        producto.setPrecio((float) productoGetDTO.getPrecio());
        producto.setImagenesProducto(productoGetDTO.getImagenes());
        producto.setCategoria(productoGetDTO.getCategorias());
//        producto.setUsuarios(usuarioServicio.obtener(productoGetDTO.getCodigo()));
        producto.setFechaLimiteProducto(productoGetDTO.getFechaLimite());

//        producto.setEstado(productoGetDTO.getEstado());

        return producto;

    }


    @Override
    public List<ProductoGetDTO> listarProductosPrecio ( float precioMin, float precioMax) throws Exception {
        List<Producto> productos = productoRepo.listarProductoPrecio(precioMin,precioMax);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for (Producto p : productos) {
            respuesta.add(convertir(p));

        }
        return respuesta;
    }


}