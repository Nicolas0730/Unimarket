package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;


public interface AdministradorServicio {

    ProductoGetDTO autorizarProductoDto(ProductoDTO productoDTO) throws Exception;

    ProductoGetDTO rechazarProducto(ProductoDTO productoDTO)throws Exception;

}
