package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@AllArgsConstructor
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;

    //El profesor lo puso en el AuthController
    @PostMapping("/crear")
    int crearUsuario(@RequestBody UsuarioDTO usuarioDTO) throws Exception //El tipo de retorno es int porque se va a retornar el codigo con que el usuario se almacena o 0 si no se creo
    {
        return usuarioServicio.crearUsuario(usuarioDTO);
    }

    @PutMapping("/actualizar/{codigoUsuario}")
    int actualizarUsuario(@PathVariable int codigoUsuario, @RequestBody UsuarioDTO userDTO) throws Exception //el codigo del usuario que voy a modificar y el nuevo usuario con los nuevos datos
    {
        return usuarioServicio.actualizarUsuario(codigoUsuario,userDTO);
    }

    //Puede ser void 17/04 9:54 pm
    @DeleteMapping("/eliminar/{codigoUsuario}")
    int eliminarUsuario(@PathVariable int codigoUsuario) throws Exception //Retorna 1 si lo borró, 0 de lo contrario
    {
        return usuarioServicio.eliminarUsuario(codigoUsuario);
    }

    @GetMapping("/obtener/{codigoUsuario}")
    UsuarioGetDTO obtenerUsuario(int codigoUsuario) throws Exception {
        return usuarioServicio.obtenerUsuario(codigoUsuario);
    }

    public ResponseEntity<MensajeDTO> eliminar(@PathVariable int codigo, @Valid @RequestBody UsuarioDTO cliente) throws Exception {
        usuarioServicio.actualizarUsuario(codigo,cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED,false,"Actualizado correctamente"));
    }
    @PostMapping(/actualizar/{"codigo"})
    public ResponseEntity<MensajeDTO> actualizar(@PathVariable int codigo, @Valid @RequestBody UsuarioDTO cliente) throws Exception {
        usuarioServicio.actualizarUsuario(codigo,cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED,false,"Actualizado correctamente"));
    }

}
