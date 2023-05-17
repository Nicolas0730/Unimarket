package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Producto  implements Serializable {


    //-------------------------------- Atributos -------------------------------

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column (nullable = false)
    @NotNull
    @NotBlank (message = "El nombre del producto es obligatorio")
    @Length(max = 100)
    private String nombre;

    @Column(nullable = false)
    @PositiveOrZero
    private int unidades;

    @NotBlank(message = "Debe añadir una descripción")
    @Length(max = 300)
    @Column(nullable = false)
    private String descripcion;

    @Positive
    @Column(nullable = false)
    private float precio;

    @Future
    @Column(nullable = false)
    private LocalDateTime fechaLimiteProducto;

    @Column (nullable = false)
    private LocalDateTime fechaPublicacion;



    //-------------------------------- Relaciones -------------------------------

    private Estado estado; //@Enum 1 producto tiene 1 estado

    @ManyToOne
    private Usuario usuarios; //Un producto tiene muchos usuarios . El producto depende del usuario que elija la lista de productos favoritos

    @OneToMany (mappedBy = "producto")
    private List <ProductoAdministrador> productoAdministrador;
    @OneToMany(mappedBy = "producto")
    private List <Favorito> favoritos;
    @ElementCollection
    private List<Categoria> categoria; //@ENUM    1 producto Tiene 1 categoría

    @OneToMany(mappedBy = "producto") //Un producto no depende de un comentario
    private List<Comentario> comentarios; // Un producto tiene muchos comentarios

   @ElementCollection
    private List<String> imagenes;

    @ManyToMany(mappedBy = "productos") //Producto no depende de detalle compra
    private  List <DetalleCompra> detalleCompras; //Un producto pertenece a 1 detalleCompra

}
