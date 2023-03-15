package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class Usuario extends Persona implements Serializable {
//    @Id
//    private int codigoo;  Cuando voy a hacer la tabla intermedia *..* con domicilio genera error ya que el programa entiende que hay dos llaves primarias, codigo y codigo que hereda a persona

    @Column(length = 20,unique = true,nullable = false)
    private String usuario;

    @Column(nullable = true, length = 150)
    private int telefono;

    @ManyToMany(mappedBy = "favoritos") //Productos favoritos del usuario
    private List<Producto> productosFavoritos;

    @OneToMany(mappedBy = "usuarios") //un usuario tiene muchos domicilios. un usuario no necesita de un domicilio
    private List<Domicilio> domicilios;


    @OneToMany(mappedBy = "codigoUsuario")      //Un usuario no necesita que un comentario exista
    private List<Comentario> comentarios; //Un usuario tiene muchos comentarios

    //******************
    @OneToMany(mappedBy = "usuario")
    private List<Compra> compra;
    //*******************
}
