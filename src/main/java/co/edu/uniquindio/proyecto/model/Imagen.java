package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Imagen implements Serializable {

    @Column(length = 255)
    private String ruta;

    @Id
    @EqualsAndHashCode.Include
    @ManyToOne()
    private Producto fotoProducto; //Depende del producto
}
