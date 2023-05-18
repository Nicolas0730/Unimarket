package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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

    @Column ( nullable = false)
    private Date fechaCompra;

    @Positive
    @Column(nullable = false)
    private double totalCompra;

    @ManyToOne
    private Usuario usuario;

    @Column (nullable = false)
   private MedioPago medioPago;

    @ManyToOne  //Una compra tiene un domicilio. La compra puede existir sin el domicilio
    @JoinColumn(nullable = false)
    private Domicilio domicilio;



    @OneToMany(mappedBy = "compra")
    private List<DetalleCompra> detalleCompras; //Compra no depende de detalleCompra


}
