package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.model.Administrador;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorRepo {

    //Falta hacer la consulta 13/04 7:13 pm
    Optional<Administrador> findByEmail(String email);
}