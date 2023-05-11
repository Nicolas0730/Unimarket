package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.model.Compra;
import co.edu.uniquindio.proyecto.model.RemateUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CompraRepo extends JpaRepository <Compra, Integer> {


//    @Query("select c from Compra c where c.codigo = :codigo")
//    RemateUsuario obtenerCompra (int codigoCompra);
//
//    @Query ("select c from Compra c where c.codigo = :codigo")
//    List<RemateUsuario> listarCompra(int codigoCompra);
}
