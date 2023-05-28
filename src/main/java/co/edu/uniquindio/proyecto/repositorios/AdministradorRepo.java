package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorRepo extends JpaRepository<Administrador, Integer> {

    //Falta hacer la consulta 13/04 7:13 pm

    @Query("select m from Administrador m where m.correo = :correo")
    Administrador buscarAdministrador(String correo);

    @Query("select p from Administrador p where p.email = :email")
    Optional<Administrador> findByEmail(String email);

}
