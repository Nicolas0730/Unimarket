package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.model.Categoria;
import co.edu.uniquindio.proyecto.model.Estado;

import java.util.List;

import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
@RestController
@RequestMapping("api/productos")
@AllArgsConstructor
public class ProductoControlador {
//    @Autowired
//    private final ProductoServicio.productoServicio;
//
//    @PostMapping("/crear")
//    int crearProducto(ProductoDTO productoDTO) throws Exception;
//
//    @PostMapping("/actualizar")
//    int actualizarProducto(int codigoProducto,ProductoDTO productoDTO) throws Exception;
//
//  @DeleteMapping("/eliminar")
//    int eliminarProducto(int codigoProducto) throws Exception;
//
//  @GetMapping("/obtener")
//    ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception;
//
//  @PostMapping("agregarCarrito")
//    int agregarCarrito(int codigoProducto)throws Exception;
//
//  @PostMapping("/agregarFavorito")
//    int agregarFavorito (int codigoUsuario, int codigoProducto) throws Exception;
//
//  @DeleteMapping("/eliminarFavorito")
//    int eliminarFavorito(int codigoUsuario, int codigoProducto) throws Exception;
//
//
//    @GetMapping("/lista")
//    List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario) throws Exception;
//
//    @GetMapping("/lista")
//    List<ProductoGetDTO> listarProductosCategoria(Categoria categoria) throws Exception;//Es una enumeracion
//
//    @GetMapping("/lista")
//    List<ProductoGetDTO> listarProductosEstado(Estado estado) throws Exception;
//
//    @GetMapping("/lista")
//    List<ProductoGetDTO> listarProductoNombre(String nombre) throws Exception;
//
//    @GetMapping("/lista")
//    List<ProductoGetDTO> listarProductosPrecio(float precioMin, float precioMax) throws Exception;
//
//    @GetMapping("/lista")
//    List<ProductoGetDTO> listarProductoFavoritos(int codigoUsuario) throws Exception;
//
//    @GetMapping("/lista")
//    List<ProductoGetDTO> lsitarProductoPropio(int codigoUsuario)throws Exception;//listar los productos que el usuario publica


}
