package co.edu.uniquindio.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ComentarioGetDTO {

    int codigoComentario;
    LocalDateTime fechaCreacion;
    private String mensaje;
    private int codigoUsuario;
    private int codigoProducto;

}

