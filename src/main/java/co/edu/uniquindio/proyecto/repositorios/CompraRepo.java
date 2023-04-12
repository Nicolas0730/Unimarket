package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.model.Ciudad;
import co.edu.uniquindio.proyecto.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompraRepo extends JpaRepository <Compra,Integer > {

    @Query("SELECT Compra from Compra  WHERE Compra .codigo= :codigo")
    Compra buscarCompra(int codigo);
}
