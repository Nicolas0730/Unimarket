package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.DomicilioServicio;
import org.springframework.stereotype.Service;

@Service
public class DomicilioServicioImpl implements DomicilioServicio {
    @Override
    public UsuarioGetDTO registrarDireccion(int codigoUsuario) {
        return null;
    }

    @Override
    public UsuarioGetDTO enviarDomicilio(String direccion, int codigoUsuario, int codigoProducto) {
        return null;
    }


    public UsuarioGetDTO enviarDomicilio(String direccion, int codigoUsuario) {
        return null;
    }
}
