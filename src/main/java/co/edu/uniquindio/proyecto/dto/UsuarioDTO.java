package co.edu.uniquindio.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO {
    private String codigo;
    private String nombre;
    private String correo;
    private String pass;
    private String direccion;
    private String telefono;
    private String usuario;
}
