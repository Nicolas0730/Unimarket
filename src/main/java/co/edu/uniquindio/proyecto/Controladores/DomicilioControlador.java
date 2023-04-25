package co.edu.uniquindio.proyecto.Controladores;

import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.DomicilioServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/domicilio")
@AllArgsConstructor
public class DomicilioControlador {
    private final DomicilioServicio.domicilioServcio;

    @PutMapping("/registrar")
    UsuarioGetDTO registrarDireccion(int codigoUsuario);//agregar direccion de domicilio, puede ser diferent al del usuario en el dto

    @GetMapping("/enviar")
    UsuarioGetDTO enviarDomicilio(String direccion, int codigoUsuario);
}
