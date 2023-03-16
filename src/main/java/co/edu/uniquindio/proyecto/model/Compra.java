package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CollectionType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Compra implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @ManyToOne()          //Una compra necesita 1 usuario, un usuario no necesita una compra
    @JoinColumn(nullable = false)
    private Usuario usuario;

    private Date fechaCompra;
    private double totalCompra;
    @ElementCollection //Si es element collection a pesar de que es solo 1 medio de pago?
    private List<MedioPago> medioPago; //Enumeracion

    @ManyToOne  //Una compra tiene un domicilio. La compra puede existir sin el domicilio
    @JoinColumn(nullable = false)
    private Domicilio domicilio;

    @OneToMany(mappedBy = "compra")
    private List<DetalleCompra> compras; //Compra no depende de detalleCompra

}
