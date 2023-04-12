package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.model.Administrador;
import co.edu.uniquindio.proyecto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepo extends JpaRepository<Administrador,Integer > {

    @Query("SELECT Administrador from Administrador  WHERE Administrador .codigo= :codigo")
    Administrador buscarAdministrador(int codigo);

    @Query("SELECT Administrador from Administrador  WHERE Administrador .codigo= :codigo")
    Administrador comprobarAutenticacion (String email, String codigo);

}
