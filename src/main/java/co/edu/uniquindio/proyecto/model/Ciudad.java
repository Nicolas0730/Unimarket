package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * La entidad ciudad se utilizará para que en el momento de la compra se marque en el domicilio
 */
@Entity
public class Ciudad implements Serializable {



    //-------------------------------- Atributos ---------------------
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column (nullable = false)
    private String nombre;

    //-------------------------------- Relaciones ---------------------

    @OneToOne
    private Domicilio domicilio;

}
