package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.io.Serializable;

/**
 * La entidad ciudad se utilizará para que en el momento de la compra se marque en el domicilio
 */
@Entity
public class Ciudad implements Serializable {

    @Id
    private int codigo;
    private String nombre;

    @OneToOne
    private Domicilio domicilio;

}
