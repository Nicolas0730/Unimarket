package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Domicilio implements Serializable {

    //-------------------------------- Atributos ---------------------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(length = 30,nullable = false)
    private int codigo;

    @Column(length = 50,nullable = false)
    private String direccion;

    //-------------------------------- Relaciones ---------------------

    @ManyToOne  //Un Domicilio tiene un usuario
    @JoinColumn(nullable = false)
    private Usuario usuarios;

    @OneToOne(mappedBy = "domicilio")           //Un domicilio tiene una ciudad
    private Ciudad codigoCiudad;    //un domicilio necesita que haya una ciudad, una ciudad no necesita que exista un domicilio

    @OneToMany(mappedBy = "domicilio") //Un domicilio tiene muchas compras. Un domicilio no puede existir sin una compra
    private List<Compra> compras;

}
