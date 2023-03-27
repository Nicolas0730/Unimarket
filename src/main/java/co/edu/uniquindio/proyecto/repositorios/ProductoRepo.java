package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository                            //Si es Integer?? 24/03 11:49 @N
public interface ProductoRepo extends JpaRepository<Producto,Integer> {

    //Consultas a la base de datos

    @Query("SELECT p from Producto p WHERE p.codigo= :codigo")
    Producto buscarProducto(int codigo);


}
