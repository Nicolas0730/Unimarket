package co.edu.uniquindio.proyecto.Controladores;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.ComentarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/comentario")
@AllArgsConstructor
public class ComentarioControlador {

    @Autowired
    private final ComentarioServicio.comentarioServicio;

    @PutMapping("/crear")
    int crearComentario(ComentarioDTO comentario) throws Exception;

    //No se contempló la opción de editar comentario ni eliminar
    @GetMapping("/listar")
    List<ComentarioGetDTO> listarComentario(int codigoProducto) ;

    @DeleteMapping("/eliminar")
    int eliminarComentario(ComentarioDTO comentario) throws Exception;
}
