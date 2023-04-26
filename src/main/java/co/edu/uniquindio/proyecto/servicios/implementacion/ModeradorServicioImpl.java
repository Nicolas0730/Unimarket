package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.ModeradorServicio;
import org.springframework.stereotype.Service;

@Service
public class ModeradorServicioImpl implements ModeradorServicio {
    @Override
    public ProductoGetDTO autorizarProductoDto(ProductoDTO productoDTO) throws Exception {
        return null;
    }

    @Override
    public ProductoGetDTO rechazarProducto(ProductoDTO productoDTO) throws Exception {
        return null;
    }
}
