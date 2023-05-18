package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.model.Categoria;
import co.edu.uniquindio.proyecto.model.Estado;
import co.edu.uniquindio.proyecto.model.Producto;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
    public int creaProducto(ProductoDTO productoDTO) throws Exception {

        Producto producto = new Producto();

        producto.setNombre( productoDTO.getNombre() );
        producto.setDescripcion( productoDTO.getDescripcion() );
        producto.setUnidades( productoDTO.getUnidades() );
        producto.setPrecio( productoDTO.getPrecio() );
        producto.setUsuarios( usuarioServicio.obtener( productoDTO.getCodigoUsuario() ) );
        producto.setCategoria( productoDTO.getCategorias() );
        producto.setEstado(Estado.SINREVISAR);
        producto.setFechaLimiteProducto(LocalDateTime.now().plusDays(60));
        producto.setImagenes(productoDTO.getImagenes());



        return productoRepo.save(producto).getCodigo();
    }

    @Override
    public int actualizarProductos(int codigoProducto, ProductoGetDTO productoGetDTO) throws Exception {
        validarExiste(codigoProducto);

        Producto producto = convertir(productoGetDTO);
        producto.setCodigo(codigoProducto);

        return productoRepo.save( producto ).getCodigo();
    }


    @Override
    public int actualizarUnidades(int codigoProducto, int unidades) throws Exception {

        validarExiste(codigoProducto);

        if(unidades<0)
        {
            throw new Exception("Las unidades no pueden ser menores a cero");

        }

        Producto producto = obtener(codigoProducto);
        producto.setUnidades(unidades);

        return productoRepo.save(producto).getCodigo();
    }

    @Override
    public int actualizarEstado(int codigoProducto, Estado estado) throws Exception {

       validarExiste(codigoProducto);

       if(estado== null) {
           throw  new Exception ("El estado no puede ser null");
       }

       Producto producto = obtener(codigoProducto);
       producto.setEstado(estado);

        return productoRepo.save(producto).getCodigo();
    }

    @Override
    public int eliminarProducto(int codigoProducto) throws Exception {

        validarExiste(codigoProducto);

        productoRepo.deleteById(codigoProducto);


        return codigoProducto;
    }

    @Override
    public void crearFavorito(int codigoUsuario, int codigoProducto) throws Exception {

    }

    @Override
    public void eliminarFavorito(int codigoUsuario, int codigoProducto) throws Exception {

    }



    @Override
    public Producto obtener(int codigo) throws Exception {

        Optional<Producto> producto = productoRepo.findById(codigo);
        if(producto.isEmpty()){
            throw  new Exception("El codigo" + codigo + "no esta asociado a ningun producto");
        }
        return producto.get();
    }

    @Override
    public ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception {

        return convertir (obtener(codigoProducto));
    }

    @Override
    public List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario) {

        List<Producto> lista = productoRepo.listarProductosUsuario(codigoUsuario);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for (Producto p: lista){
            respuesta.add (convertir(p));
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoria(Categoria categoria) {

       List<Producto> lista = productoRepo.listarProductosCategoria(categoria);
       List<ProductoGetDTO> respuesta = new ArrayList<>();

       for (Producto p : lista){
           respuesta.add(convertir(p));
       }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPorEstado(Estado estado) {
        List<Producto> lista = productoRepo.listarProductosEstado(estado);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for (Producto p : lista){
            respuesta.add(convertir(p));
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario) {
        List<Producto> lista = productoRepo.listarProductoFavoritos(codigoUsuario);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for (Producto p : lista){
            respuesta.add(convertir(p));
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosNombre(String nombre) {
        List<Producto> lista = productoRepo.listarProductoNombre(nombre);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for (Producto p : lista){
            respuesta.add(convertir(p));
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo) {
        List<Producto> lista = productoRepo.listarProductoPrecio(precioMinimo,precioMaximo);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for (Producto p : lista){
            respuesta.add(convertir(p));
        }

        return respuesta;
    }

    private void validarExiste (int codigoProducto) throws  Exception {

        boolean existe = productoRepo.existsById(codigoProducto);

        if(!existe){
            throw new Exception("El código " + codigoProducto + "no esta asociado a ningun producto");
        }

    }

    private Producto convertir (ProductoGetDTO productoDTO) throws Exception {

        Producto producto = new Producto();

        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setUnidades(productoDTO.getUnidades());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setImagenes(productoDTO.getImagenes());
        producto.setUsuarios(usuarioServicio.obtener(productoDTO.getCodigoUsuario()));
        producto.setEstado(productoDTO.getEstado());

        return producto;
    }
        private ProductoGetDTO convertir (Producto producto){

            ProductoGetDTO productoGetDTO = new ProductoGetDTO(

                    producto.getCodigo(),
                    producto.getEstado(),
                    producto.getFechaLimiteProducto(),
                    producto.getNombre(),
                    producto.getDescripcion(),
                    producto.getUnidades(),
                    producto.getPrecio(),
                    producto.getUsuarios().getCodigo(),
                    producto.getImagenes(),
                    producto.getCategoria()
            );
            return productoGetDTO;
        }

    }
