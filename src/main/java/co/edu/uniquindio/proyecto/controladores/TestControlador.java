package co.edu.uniquindio.proyecto.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludo")
public class TestControlador {

    @GetMapping
    public String saludar(){
        return "HOLA";
    }
}
