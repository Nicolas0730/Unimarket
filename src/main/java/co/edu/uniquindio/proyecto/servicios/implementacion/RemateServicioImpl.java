package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.RemateServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RemateServicioImpl implements RemateServicio {
    @Override
    public ProductoGetDTO aplicarRemate(int codigoProducto, int codigoUsuario) {
        return null;
    }

    @Override
    public ProductoGetDTO actualizarRemate(int codigoProducto, int codigoUsuario) {
        return null;
    }

    @Override
    public ProductoGetDTO eliminarRemate(int codigoProducto, int codigoUsuario) {
        return null;
    }
}
