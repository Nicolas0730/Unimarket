package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.model.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DomicilioRepo extends JpaRepository <Domicilio,Integer> {
}
