package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.model.Producto;
import co.edu.uniquindio.proyecto.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
@Setter
public class ComentarioDTO {

    //No va el codigo del comentario? o este se genera 24/03 10:38 pm
    @Length(min = 0,max = 500,message = "La contraseña debe tener máximo 500 caracteres")
    @NotBlank(message = "La contraseña no puede ser vacía")
    @NotNull(message = "La contraseña no puede ser null")
    private String mensaje;
    private int codigoUsuario;
    private int codigoProducto;

}
