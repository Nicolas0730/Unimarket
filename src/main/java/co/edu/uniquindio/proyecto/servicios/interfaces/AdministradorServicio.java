package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.model.Administrador;


public interface AdministradorServicio {

    boolean autorizarProductoDto(int codigoProducto, int codigoAdminsitrador) throws Exception;

    void rechazarProducto(int codigoProducto)throws Exception;

    Administrador obtenerAdminsitrador(int codigoAdminsitrador) throws Exception;

}
