package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
@Entity
public class Domicilio implements Serializable {
    @Id
    private int codigo;

//    private Ciudad codigoCiudad;
//    private Compra codigoCompra;
}
