package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
public class Administrador extends Persona implements Serializable {

    @OneToMany (mappedBy = "administrador")
    private List<ProductoAdministrador> productoAdministrador;
}
