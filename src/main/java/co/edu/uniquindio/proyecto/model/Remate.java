package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Remate {
    @Id
    private int codigo;
    private Date fechaLimite;

//    private Producto codigoProducto;
    //Remate se relaciona a remate_usuario
}
