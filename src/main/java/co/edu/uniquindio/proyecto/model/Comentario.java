package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Comentario implements Serializable {

    //-------------------------------- Atributos ---------------------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private LocalDateTime fechaComentario;

    @Lob // Mapea como text el tipo del atributo en la BD
    @Column(nullable = false)
    private String mensaje;

    //-------------------------------- Relaciones ---------------------

    @ManyToOne

    private Producto producto; // necesita que exista un comentario

    @ManyToOne

    private Usuario  usario;




}
