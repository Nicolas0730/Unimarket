package co.edu.uniquindio.proyecto.Controladores;

import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.RemateServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/remate")
@AllArgsConstructor
public class RemateControlador {
    private final RemateServicio remateServicio;

    @PutMapping("/crear/Remate")
    public ResponseEntity<MensajeDTO> aplicarRemate(@PathVariable int codigoProducto,@PathVariable int codigoUsuario)throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED,false,aplicarRemate(codigoProducto,codigoUsuario)));
    }

    @PutMapping("/actualizar/Remate")
    public ResponseEntity<MensajeDTO> actualizarRemate(int codigoProducto, int codigoUsuario)throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK,false,actualizarRemate(codigoProducto,codigoUsuario)));
    }

    @DeleteMapping("/eliminar/Remate")
     public ResponseEntity<MensajeDTO> eliminarRemate(int codigoProducto, int codigoUsuario)throws Exception{
        remateServicio.eliminarRemate(codigoProducto,codigoUsuario);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK,false ,"Remate eliminado"));
    }
}
