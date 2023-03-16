package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    private int unidades;
    private double precioProducto;

    @ManyToOne
    private Compra compra; //Detallecompra depende de Compra

    @OneToMany(mappedBy = "detalleCompra") //DetalleCompra necesita que existan productos
    private List<Producto> productos; //Un detalleCompra puede incluir varios productos
}
