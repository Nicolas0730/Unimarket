package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;

public interface ModeradorServicio {

    ProductoGetDTO autorizarProductoDto(ProductoDTO productoDTO) throws Exception;

    ProductoGetDTO rechazarProducto(ProductoDTO productoDTO)throws Exception;

}
