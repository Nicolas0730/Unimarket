package co.edu.uniquindio.proyecto.Controladores;

import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.DomicilioServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/domicilio")
@AllArgsConstructor
public class DomicilioControlador {
    private final DomicilioServicio domicilioServcio;

    @PutMapping("/registrar")
   public ResponseEntity<MensajeDTO> registrarDireccion(@PathVariable int codigoUsuario)throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.OK,false,registrarDireccion(codigoUsuario)));
    }//agregar direccion de domicilio, puede ser diferent al del usuario en el dto

    @GetMapping("/enviar")//duda si debo enviar el Domicilio DTO O asi esta bien,porque podria enviar domicilio y int codigoUsuario
    public ResponseEntity<MensajeDTO> enviarDomicilio(@PathVariable int codigoUsuario)throws Exception {
    return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK,false,codigoUsuario));
    }
}
