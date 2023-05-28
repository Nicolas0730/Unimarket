package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.model.Administrador;
import co.edu.uniquindio.proyecto.model.Producto;
import co.edu.uniquindio.proyecto.repositorios.AdministradorRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.AdministradorServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdministradorServicioImpl implements AdministradorServicio {

    @Autowired
    AdministradorRepo administradorRepo;
    @Autowired
    private ProductoServicio productoServicio;
    @Autowired
    private ProductoRepo productoRepo;
    @Override
    public boolean autorizarProductoDto(int codigoProducto, int codigoAdminsitrador) throws Exception {
        Producto producto = productoServicio.obtener(codigoProducto);
        if (producto!= null){
            if (!producto.getActivo().equals("ACTIVO")){
                producto.setActivo("ACTIVO");
                producto.setFechaLimiteProducto(LocalDateTime.now().plusDays(60));
                producto.setAdministrador(obtenerAdminsitrador(codigoAdminsitrador));
                productoRepo.save(producto);

                return true;
            }else {
                throw new Exception("El producto ya esta activo");

            }

        }else {
            throw new Exception("producto en el codigo: "+ codigoProducto+ "No se a encontrado");
        }
    }

    @Override
    public void rechazarProducto(int codigoProducto) throws Exception {
        Producto producto = productoServicio.obtener(codigoProducto);
        if (producto!= null){
            if (!producto.getActivo().equals("INACTIVO")){
                producto.setActivo("INACTIVO");
                productoRepo.save(producto);

            }else {
                throw new Exception("El producto ya esta INACTIVO");

            }

        }else {
            throw new Exception("producto en el codigo: "+ codigoProducto+ "No se a encontrado");
        }
    }

    @Override
    public Administrador obtenerAdminsitrador(int codigoAdminsitrador) throws Exception {
        Optional<Administrador> administrador = administradorRepo.findById(codigoAdminsitrador);

        if(administrador.isEmpty() ) {
            throw new Exception("El código " + codigoAdminsitrador + " no está asociado a ningún usuario");
        }
        return administrador.get();
    }
}
