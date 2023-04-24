package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;

public interface RemateServicio {
    ProductoGetDTO aplicarRemate(int codigoProducto, int codigoUsuario ,float precioProducto);

    ProductoGetDTO actualizarRemate(int codigoProducto, int codigoUsuario, float precioProducto);
    ProductoGetDTO eliminarRemate(int codigoProducto, int codigoUsuario);
}
