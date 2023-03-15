package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @ManyToOne
    @JoinColumn(nullable = false) //Un comentario corresponde a un producto
    private Producto codigoProducto; // necesita que exista un comentario

    @ManyToOne
    @JoinColumn(nullable = false) //Un comentario tiene un usuario (que lo escribio)
    private Usuario codigoUsuario; // Necesita que un usuario exista

    @Column(length = 200,nullable = false)
    private String mensaje;

    private Date fechaComentario;

}
