package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,Integer> {

    //JPQL --> Lenguaje de consultas de persistencia de Java
    @Query("SELECT u from Usuario u WHERE u.email= :correo") // el :correo hace referencia al parámetro
    Usuario buscarUsuario(String correo);
}
