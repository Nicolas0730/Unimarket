package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.AdministradorServicio;
import org.springframework.stereotype.Service;

@Service
public class AdministradorServicioImpl implements AdministradorServicio {
    @Override
    public ProductoGetDTO autorizarProductoDto(ProductoDTO productoDTO) throws Exception {
        return null;
    }

    @Override
    public ProductoGetDTO rechazarProducto(ProductoDTO productoDTO) throws Exception {
        return null;
    }
}
