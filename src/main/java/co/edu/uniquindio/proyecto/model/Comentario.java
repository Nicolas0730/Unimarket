package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Comentario {
    @Id
    private int codigo;

//    private Producto codigoProducto;
//    private Usuario codigoUsuario;

    private String mensaje;

    private Date fechaComentario;

}
