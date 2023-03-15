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

    @ManyToMany() //Productos favoritos del usuario      Se quitaron los argumentos mappedBy = "usuarios" de @ManyToMany para usar JoinTable(name= "Favoritos"
    @JoinTable(name = "Favoritos") //Garantiza que el nombre de la tabla intermedia sea Favoritos y no productocodigo_usuariocodigo
    private List<Producto> productos;

    @OneToMany(mappedBy = "usuarios") //un usuario tiene muchos domicilios. un usuario no necesita de un domicilio
    private List<Domicilio> domicilios;


    @OneToMany(mappedBy = "codigoUsuario")      //Un usuario no necesita que un comentario exista
    private List<Comentario> comentarios; //Un usuario tiene muchos comentarios

    @OneToMany(mappedBy = "usuario") //El usuario tiene muchas compras. Un usuario no depende de una compra
    private List<Compra> compra;

}
