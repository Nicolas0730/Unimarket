package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
public class Administrador extends Persona implements Serializable {

    @Column(nullable = false, unique = true)
    private Integer codigo;
    @OneToMany(mappedBy = "moderador")
    private List<Producto> productoList;

    public Administrador(Integer cedula, String nombre, String email, String password,Integer codigo) {
        super(cedula, nombre, email, password);
        this.codigo=codigo;
    }

}
