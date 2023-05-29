package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString(callSuper = true)
public class Administrador extends Persona implements Serializable {

    @Column(nullable = false, unique = true)
    private int codigo;
    @OneToMany(mappedBy = "administrador")
    private List<Producto> productoList;

    public Moderador(Integer cedula, String nombre, String correo, String password,Integer codigo) {
        super(cedula, nombre, correo, password);
        this.codigo=codigo;
    }
}


