package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Producto implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    private int codigo;
    private String nombre;
    private int unidades;
    private String descripcion;
    private double precio;

//    private Vendedor codigo;
//    private EstadoPublicacion codigo;

    @ManyToMany
    private List<Usuario> favoritos;
    @Column(nullable = true)
    private CategoriaProducto categoria; //@ENUM Un producto puede tener varias categorias? 15/03/23 12:42am

    @OneToMany(mappedBy = "codigoProducto") //Un producto no depende de un comentario
    private List<Comentario> comentarios; // Un producto tiene muchos comentarios
}
