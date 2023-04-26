package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,Integer> {

    //JPQL --> Lenguaje de consultas de persistencia de Java

    //Usuario es la clase, no la tabla
    @Query("SELECT u from Usuario u WHERE u.correo= :correo") // el :correo hace referencia al parámetro
    Usuario buscarUsuario(String correo);

    @Query ("SELECT u FROM Usuario u WHERE u.codigo = :codigo")
    Usuario buscarUsuarioCodigo (int codigo);


    Optional<Usuario> findByCorreo(String correo);
}
