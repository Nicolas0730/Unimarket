package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.awt.*;
import java.io.Serializable;
import java.util.List;

/**
 * Extiende la clase padre: Persona
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Usuario extends Persona implements Serializable {


    //-------------------------------- Atributos ---------------------

    @Column(length = 12)
    private String telefono;

    //-------------------------------- Relaciones ---------------------

    @OneToMany (mappedBy = "usuario")
    private List <Comentario> comentarios;

    @OneToMany (mappedBy = "usuarios")
    private List <Producto> productos;

    @OneToMany (mappedBy = "usuario")
    private List <Compra> compras;

    @OneToMany (mappedBy = "usuario")
    private List<Favorito> favoritos;



}
