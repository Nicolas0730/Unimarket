package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Remate implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private int codigo;
    private Date fechaLimite;

//    private Producto codigoProducto;

    @OneToMany(mappedBy = "remate") //Remate no depende de remate usuario
    private List<RemateUsuario> remateUsuario;
}
