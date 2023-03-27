package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class RemateUsuario implements Serializable {



    //-------------------------------- Atributos ---------------------


    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,length = 30,unique = true)
    public int codigo;

    @Column (nullable = false)
    private double valor;

    @Column ( nullable = false)
    private Date fecha_subasta;


    //-------------------------------- Relaciones ---------------------


    @ManyToOne
    private Remate remate; //Remateusuario depende de un remate

    @ManyToOne
    private Usuario usuario; //Remateusuario depende de un usuario
}
