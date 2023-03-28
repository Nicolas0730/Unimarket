package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO {
//    private String codigo;
    @NotNull
    @NotBlank
    @Length(max = 100)
    private String nombre;
    @NotNull
    @NotBlank
    @Length(max = 100)
    @Email
    private String correo;
    @Length(min = 8,max = 50,message = "La contraseña debe ser de máximo 50 caracteres") //Validación de que la contraseña tenga solo 50 caracteres
    @NotBlank(message = "La contraseña no puede ser vacía")
    @NotNull(message = "La contraseña no puede ser null")
//    @Pattern(regexp = "[L-_.*]1-40") //Valida una estructura mediante una expresión regular indicada
    private String pass;
    @Length(max = 100, message = "La dirección debe tener máximo 100 caracteres")
    private String direccion;

    @PositiveOrZero
    @Length(max = 12, message = "El teléfono debe tener máximo 12 caracteres")
    private String telefono;
    private String usuario;

}
