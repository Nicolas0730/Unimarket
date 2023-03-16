package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;

import java.util.List;

public interface ComentarioServicio {

    int crearComentario(ComentarioDTO comentario);

    List<ComentarioGetDTO> listarComentario(int codigoProducto);
}
