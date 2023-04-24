package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.SesionDTO;
import co.edu.uniquindio.proyecto.dto.TokenDTO;

//Debe ser util tanto para usuarios como para el admin
public interface SesionServicio {

    TokenDTO login(SesionDTO sesionDTO); //El token será agregado automaticamente por el servidor

    void logout(int codigoUsuario);






}
