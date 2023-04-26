package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.model.Remate;
import co.edu.uniquindio.proyecto.model.RemateUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RemateRepo extends JpaRepository<Remate, Integer> {



    @Query ("Select r from RemateUsuario r where r.codigo = :codigo")
    List<RemateUsuario> listarRemate (int codigo);



}
