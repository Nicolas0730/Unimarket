package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.model.Comentario;

import java.util.List;

public interface ComentarioServicio {

    int crearComentario(ComentarioDTO comentario) throws Exception; //Retorna el codigo del comentario o 0 en caso de no crear el comentario

    //No se contempló la opción de editar comentario ni eliminar
    List<ComentarioGetDTO> listarComentario(int codigoProducto);//solo USUARIOS LOGUEADOS PUEDEN listar los  comentarios que tenga el producto

    int eliminarComentario(ComentarioDTO comentario) throws Exception;// borrar el comentario con el codigo

    ComentarioGetDTO obtenerComentario(int codigoComentario) throws Exception;

}
