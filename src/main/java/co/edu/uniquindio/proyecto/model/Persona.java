package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Esta clase representa una persona que será padre de usuario y vendedor
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode
@Getter
@Setter
public class Persona {
    @Id
    @Column(length = 10)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false, length = 150)
    private String nombre;
    @Column(nullable = false, length = 150,unique = true)
    private String correo;
    @Column(nullable = false, length = 120)
    private String password;
    @Column(nullable = true, length = 150)
    private String direccion;

    //@Builder sirve para crear objetos más rapido
}
