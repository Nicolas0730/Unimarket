package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

/**
 * Esta clase representa una persona que será padre de usuario y vendedor
 */
@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false, length = 150)
    private String nombre;
    @NotBlank
    @Email
    @Column(nullable = false, length = 150,unique = true)
    private String correo;
    @Column(nullable = false, length = 120)
    private String password;
    @Column(nullable = true, length = 150)
    private String direccion;




    //@Builder sirve para crear objetos más rapido
}
