package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.AdministradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/administrador")
@AllArgsConstructor
public class AdministradorControlador {
    private final AdministradorServicio administradorServicio;


    @PutMapping("/aprobar/{codigoProducto}")
    ResponseEntity<MensajeDTO> aprobarProducto(@PathVariable int codigoProducto  ) throws Exception{

        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                administradorServicio.autorizarProductoDto(codigoProducto,1)  ));
    }

    @PutMapping("/rechazar/{codigoProducto}")
    void rechazarProducto(@PathVariable int codigoProducto) throws Exception{
        administradorServicio.rechazarProducto(codigoProducto);
    }
}
