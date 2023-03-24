package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Remate implements Serializable {

    //-------------------------------- Atributos ---------------------

    @Id
    @EqualsAndHashCode.Include
    private int codigo;

    @Column (nullable = false)
    @Future (message = "La fecha debe de estar definida en el futuro")
    private Date fechaLimite;


    //-------------------------------- Relaciones  ---------------------

    @ManyToOne
   private Producto producto;

    @OneToMany(mappedBy = "remate") //Remate no depende de remate usuario
    private List<RemateUsuario> remateUsuario;
}
