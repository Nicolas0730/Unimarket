package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class DetalleCompra implements Serializable {

    //-------------------------------- Atributos ---------------------

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Positive
    @Column(nullable = false)
    private int unidades;

    @Positive
    @Column(nullable = false)
    private double precioProducto;

    //-------------------------------- Relaciones ---------------------

    @ManyToOne
    private Compra compra; //Detallecompra depende de Compra

   @ManyToOne
    private Producto producto;

   @ManyToOne
    private DetalleCompra detalleCompra;
}
