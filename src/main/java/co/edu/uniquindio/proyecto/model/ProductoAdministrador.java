package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class ProductoAdministrador implements Serializable {


    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column (nullable = false, length = 100)
    private String motivo;

    private LocalDateTime fecha;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Administrador administrador;

    private Estado estado;

}
