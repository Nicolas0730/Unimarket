package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.model.Categoria;

import java.util.List;

import co.edu.uniquindio.proyecto.model.Estado;
import co.edu.uniquindio.proyecto.model.Producto;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/productos")
@AllArgsConstructor
public class ProductoControlador {
    @Autowired
    private final ProductoServicio productoServicio;

    @PostMapping("/crear-producto")
    public ResponseEntity<MensajeDTO> crearProducto(@RequestBody ProductoDTO productoDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO<>(HttpStatus.CREATED, false, productoServicio.crearProducto(productoDTO)));
    }

    @PostMapping("/actualizar")
    public ResponseEntity<MensajeDTO> actualizarProducto(@PathVariable int codigoProducto,@RequestBody ProductoDTO productoDTO) throws Exception{
        return  ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.actualizarProducto(codigoProducto,productoDTO)));
    }

    @DeleteMapping("/eliminar")
     public  ResponseEntity<MensajeDTO>eliminarProducto(@PathVariable int codigoProducto) throws Exception{
        productoServicio.eliminarProducto(codigoProducto);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO<>(HttpStatus.OK, false, "Producto eliminado "));
    }

    @GetMapping("/obtener")
    public ResponseEntity<MensajeDTO> obtenerProducto (@PathVariable int codigoProducto) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.obtenerProducto(codigoProducto)));
    }

    @PostMapping("agregarCarrito")
     public  ResponseEntity<MensajeDTO>agregarCarrito(@PathVariable int codigoProducto)throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.agregarCarrito(codigoProducto)));
    }

    @PostMapping("/agregarFavorito")
    public  ResponseEntity<MensajeDTO>agregarFavorito (@PathVariable int codigoUsuario,@PathVariable int codigoProducto) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.agregarFavorito(codigoUsuario,codigoProducto)));
    }

    @DeleteMapping("/eliminarFavorito")
    public ResponseEntity<MensajeDTO> eliminarFavorito(@PathVariable int codigoUsuario,@PathVariable int codigoProducto) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO<>(HttpStatus.OK,false,productoServicio.eliminarFavorito(codigoUsuario,codigoProducto)));
    }


    @GetMapping("/lista/productosUsuario")
     public ResponseEntity<MensajeDTO> listarProductosUsuario(@PathVariable int codigoUsuario) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO<>(HttpStatus.OK, false, listarProductosUsuario(codigoUsuario)));
    }

    @GetMapping("/lista/porudctosCategoria")
    public ResponseEntity<MensajeDTO> listarProductosCategoria(@RequestBody Categoria categoria) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO<>(HttpStatus.OK, false, productoServicio.listarProductosCategoria(categoria)));
    }//Es una enumeracion

    @GetMapping("/lista/productosEstado")
    public ResponseEntity<MensajeDTO>listarProductosEstado(@RequestBody Estado estado)throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO<>(HttpStatus.OK,false, productoServicio.listarProductosEstado(estado)));
    }

    @GetMapping("/lista/productosNombre") //preguntar por este
    public ResponseEntity<MensajeDTO> listarProductoNombre(@RequestBody String nomProducto) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO<>(HttpStatus.OK,false,productoServicio.listarProductoNombre(nomProducto)));
    }

    @GetMapping("/lista/listarProductosPrecio")
    public ResponseEntity<MensajeDTO> listarProductosPrecio(@RequestBody float precioMin, @RequestBody float precioMax) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO<>(HttpStatus.OK,false, productoServicio.listarProductosPrecio(precioMax,precioMin)));
    }

    @GetMapping("/lista/ProductoFavoritos")
    public ResponseEntity<MensajeDTO>listarProductoFavoritos(@RequestBody int codigoUsuario) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK,false, productoServicio.listarProductoFavoritos(codigoUsuario)));
    }

//    @GetMapping("/lista/ProductoPropio")
//    public ResponseEntity<MensajeDTO> lsitarProductoPropio(int codigoUsuario)throws Exception;{
//        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO<>(HttpStatus.OK,false,productoServicio.listarProductosUsuario(codigoUsuario)));
//    }//listar los productos que el usuario publica


}
