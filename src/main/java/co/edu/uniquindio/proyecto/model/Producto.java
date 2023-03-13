package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Producto implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    private int codigo;
    private String nombre;
    private int unidades;
    private String descripcion;
    private double precio;

//    private Vendedor codigo;
//    private EstadoPublicacion codigo;

}
