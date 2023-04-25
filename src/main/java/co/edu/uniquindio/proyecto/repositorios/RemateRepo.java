package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.model.Remate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface RemateRepo extends JpaRepository<Remate, Integer> {



//    @Query ("Select r from RemateUsuario r where r.codigo = :codigo AND r.usuario.codigo")
//    Remate



}
