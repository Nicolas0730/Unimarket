package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.model.Ciudad;
import co.edu.uniquindio.proyecto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepo extends JpaRepository <Ciudad, Integer > {
    @Query("SELECT Ciudad from Ciudad  WHERE Ciudad.codigo= :codigo")
    Ciudad buscarCiudad(int codigo);
}
