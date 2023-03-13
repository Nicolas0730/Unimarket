package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Persona {

    @Id
    private int cedula;

    private String nombre;

    private String email;
    private String password;
    private String direccion;
    private int telefono;
}
