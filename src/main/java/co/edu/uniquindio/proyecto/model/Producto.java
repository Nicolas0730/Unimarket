package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Producto implements Serializable {


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
    private double precio;

    @Future
    @Column(nullable = false)
    private LocalDateTime fechaLimiteProducto;

    @Column (nullable = false)
    private LocalDateTime fechaPublicacion;



    //-------------------------------- Relaciones -------------------------------

    @ManyToOne
    private Usuario vendedor; //Un producto tiene 1 vendedor. El producto depende del vendedor

    //    @ElementCollection?????????
    //@Column(nullable = false)
    private Estado estado; //@Enum 1 producto tiene 1 estado

    @ManyToMany(mappedBy = "productosFav")
    private List<Usuario> usuarios; //Un producto tiene muchos usuarios . El producto depende del usuario que elija la lista de productos favoritos

//    @ElementCollection?????????
//    @Column(nullable = false)
    private List<Categoria> categoria; //@ENUM    1 producto Tiene 1 categoría

    @OneToMany(mappedBy = "codigoProducto") //Un producto no depende de un comentario
    private List<Comentario> comentarios; // Un producto tiene muchos comentarios

    @OneToMany(mappedBy = "fotoProducto")
    private List<Imagen> imagenesProducto; //@ElemenCollection?

    @ManyToOne() //Producto no depende de detalle compra
    private DetalleCompra detalleCompra; //Un producto pertenece a 1 detalleCompra
}
