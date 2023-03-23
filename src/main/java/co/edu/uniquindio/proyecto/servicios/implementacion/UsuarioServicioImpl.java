package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {
    @Override
    public int crearUsuario(UsuarioDTO user) {
        return 0;
    }

    @Override
    public int actualizarUsuario(int codigoUsuario, UsuarioDTO userDTO) {
        return 0;
    }

    @Override
    public int eliminarUsuario(int codigoUsuario) {
        return 0;
    }

    @Override
    public UsuarioDTO obtenerUsuario(int codigoUsuario) {
        return null;
    }
}
