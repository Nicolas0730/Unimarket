package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.SesionDTO;
import co.edu.uniquindio.proyecto.dto.TokenDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.RemateServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sesion")
@AllArgsConstructor
public class SesionControlador {

//    private  final RemateServicio.remateServico;
//
//    @PutMapping("/crear")
//    TokenDTO login(SesionDTO sesionDTO); //El token será agregado automaticamente por el servidor
//
//    @PutMapping("/actualizar")
//    void logout(int codigoUsuario);
//
//    //no se
//    void finSesion ( int codigoUsuario);
//
//    String enviarEmail(String asunto,String contenido, String destinatario) throws Exception;// envia el email para recuperar contrasea
}
