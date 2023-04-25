package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepo extends JpaRepository<Comentario,Integer> {

    //Necesito buscar la existencia de un comentario para algo?
    @Query("SELECT u from Comentario u WHERE u.codigo= :codigoComentario")
    Comentario buscarComentario(int codigoComentario);
}
