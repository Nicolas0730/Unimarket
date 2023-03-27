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

    //    @Id
    //    private int codigoo;  Cuando voy a hacer la tabla intermedia *..* con domicilio genera error ya que el programa entiende que hay dos llaves primarias, codigo y codigo que hereda a persona
    @Column(nullable = false)
    private Rol usuario;

    @Column(length = 12)
    private String telefono;

    //-------------------------------- Relaciones ---------------------

    @ManyToMany //Productos favoritos del usuario      Se quitaron los argumentos mappedBy = "usuarios" de @ManyToMany para usar JoinTable(name= "Favoritos"
    @JoinTable(name = "favoritos", joinColumns = {}, inverseJoinColumns = {} )
//    @JoinTable(name = "Favoritos") //Garantiza que el nombre de la tabla intermedia sea Favoritos y no productocodigo_usuariocodigo
    private List<Producto> productosFav;

    @OneToMany(mappedBy = "usuarios") //un usuario tiene muchos domicilios. un usuario no necesita de un domicilio
    private List<Domicilio> domicilios;


    @OneToMany(mappedBy = "codigoUsuario")      //Un usuario no necesita que un comentario exista
    private List<Comentario> comentarios; //Un usuario tiene muchos comentarios

    @OneToMany(mappedBy = "usuario") //El usuario tiene muchas compras. Un usuario no depende de una compra
    private List<Compra> compra;


    @OneToMany(mappedBy = "usuario")
    private List<RemateUsuario> remates;

    @OneToMany(mappedBy = "vendedor") //Un usuarioVendedor no depende de un producto
    private List<Producto> productosVendedor;
}
