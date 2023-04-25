package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;

public interface DomicilioServicio {
    UsuarioGetDTO registrarDireccion( int codigoUsuario);//agregar direccion de domicilio, puede ser diferent al del usuario en el dto

   UsuarioGetDTO enviarDomicilio(String direccion, int codigoUsuario , int codigoProducto);
}
