package co.edu.uniquindio.proyecto.Controladores;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.ComentarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
@RestController
@RequestMapping("api/comentario")
@AllArgsConstructor
public class ComentarioControlador {

//    @Autowired
//    private final ComentarioServicio comentarioServicio;
//
//    @PutMapping("/crear")
//    public ResponseEntity<MensajeDTO> crearComentario(@RequestBody ComentarioDTO comentario) throws Exception{
//        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false, comentarioServicio.crearComentario(comentarioDTO)));
//    }
//
//    //No se contempló la opción de editar comentario ni eliminar
//    @GetMapping("/listar")
//    public ResponseEntity<MensajeDTO> listarComentario(@PathVariable int codigoProducto) throws Exception {
//        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK,false, listarComentario(comentarioDTO)));
//    }
//
//    @DeleteMapping("/eliminar")
//    public  ResponseEntity<MensajeDTO> eliminarComentario(@RequestBody ComentarioDTO comentario) throws Exception{
//        comentarioServicio.eliminarComentario(comentarioDTO);
//        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK,false,"Comentario eliminado"));
//    }
}
