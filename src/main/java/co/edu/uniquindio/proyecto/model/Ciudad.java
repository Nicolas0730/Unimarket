package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

/**
 * La entidad ciudad se utilizará para que en el momento de la compra se marque en el domicilio
 */
@Entity
public class Ciudad {

    @Id
    private int codigo;
    private String nombre;

    @OneToOne
    private Domicilio domicilio;

}
