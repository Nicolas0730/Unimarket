package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.model.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository                            //Si es Integer?? 24/03 11:49 @N
public interface ProductoRepo extends JpaRepository<Producto,Integer> {

    //Consultas a la base de datos

    @Query("SELECT p from Producto p WHERE p.codigo= :codigo")
    Producto buscarProducto(int codigo);

    @Query("Select p from Producto p where p.nombre like concat('%', :nombre ,'%')  and p.estado = co.edu.uniquindio.proyecto.model.Estado.APROBADO")
    List<Producto> listarProductoNombre (String nombre );

}
