package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.model.Categoria;
import co.edu.uniquindio.proyecto.model.Estado;
import co.edu.uniquindio.proyecto.model.Producto;
import co.edu.uniquindio.proyecto.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository                            //Si es Integer?? 24/03 11:49 @N
public interface ProductoRepo extends JpaRepository<Producto,Integer> {

    //Consultas a la base de datos

    @Query("SELECT p FROM Producto p WHERE p.codigo= :codigo")
    Producto obtenerProducto (int codigo);

    @Query("SELECT p FROM Producto p WHERE p.nombre like concat('%', :nombre ,'%')  and p.estado = co.edu.uniquindio.proyecto.model.Estado.APROBADO")
    List<Producto> listarProductoNombre (String nombre );

    @Query ("select p from Producto p where :categoria member of p.categoria")
    List <Producto> listarProductosCategoria (Categoria categoria);




    @Query ("select p from Producto p where p.estado = :estado")
    List<Producto> listarProductosEstado (Estado estado);

    @Query ("select p from Producto p where p.vendedor.codigo = :codigoUsuario")
    List<Producto> listarProductosUsuario (int codigoUsuario);

    @Query ("select p from Producto p where p.precio > :precioMin and p.precio < :precioMax")
    List<Producto> listarProductoPrecio (float precioMin, float precioMax);

    @Query ("select p from Producto p join p.vendedor u where u.codigo = :codigo")
    List<Producto> listarProductoFavoritos (int codigo);
}
