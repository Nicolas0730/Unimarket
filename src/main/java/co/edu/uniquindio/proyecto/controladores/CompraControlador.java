package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.CompraServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compra")
@AllArgsConstructor
public class CompraControlador {

        @Autowired
        private final CompraServicio compraServicio;

        @PutMapping("/crear")
        public ResponseEntity<MensajeDTO>crearCompra(@RequestBody CompraDTO compraDTO) throws Exception{
                return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false, crearCompra(compraDTO)));
        }
        //se debe guardar, además del cliente y el producto (o los productos), la fecha, el total de la compra y el método de pago.

        @GetMapping("/lsita")
        public ResponseEntity<MensajeDTO> listarCompras(@PathVariable int codigoUsuario)throws Exception{
                return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK,false, listarCompras(codigoUsuario)));
        } //listar compras dado el codigo del usuario

        @GetMapping("/obtener")
        public ResponseEntity<MensajeDTO>obtenerCompra(@PathVariable int codigoCompra)throws Exception{
                return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK,false,obtenerCompra(codigoCompra)));
        }


}
