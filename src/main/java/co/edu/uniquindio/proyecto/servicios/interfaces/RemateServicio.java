package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;

public interface RemateServicio {
    ProductoGetDTO aplicarRemate(int codigoProducto, int codigoUsuario);

    ProductoGetDTO actualizarRemate(int codigoProducto, int codigoUsuario);
    ProductoGetDTO eliminarRemate(int codigoProducto, int codigoUsuario);
}
