package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImagenRepo extends JpaRepository<Imagen, Producto> {

    @Query("SELECT Imagen from Imagen WHERE Imagen.fotoProducto= :codigoImagen")
    Imagen buscarImagen(int codigoImagen);
}
