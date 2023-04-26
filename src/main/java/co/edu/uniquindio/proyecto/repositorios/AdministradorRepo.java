package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorRepo extends JpaRepository<Administrador, Integer> {

    //Falta hacer la consulta 13/04 7:13 pm
    Optional<Administrador> findByCorreo(String correo);
}
