package co.edu.uniquindio.proyecto.Controladores;

import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/remate")
@AllArgsConstructor
public class RemateControlador {

    @PutMapping("/crear")
    ProductoGetDTO aplicarRemate(int codigoProducto, int codigoUsuario);

    @PutMapping("/actualizar")
    ProductoGetDTO actualizarRemate(int codigoProducto, int codigoUsuario);

    @DeleteMapping("/eliminar")
    ProductoGetDTO eliminarRemate(int codigoProducto, int codigoUsuario);
}
