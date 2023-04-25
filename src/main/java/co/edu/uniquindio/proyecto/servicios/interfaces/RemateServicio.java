package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.model.RemateUsuario;

import java.util.List;

public interface RemateServicio {
    ProductoGetDTO aplicarRemate(int codigoProducto, int codigoUsuario ,float precioProducto);


    ProductoGetDTO actualizarRemate(int codigoProducto, int codigoUsuario, float precioProducto);

    ProductoGetDTO eliminarRemate(int codigoProducto, int codigoUsuario);


    List<RemateUsuario> listarRemate (int codigoRemate) throws Exception;

}
