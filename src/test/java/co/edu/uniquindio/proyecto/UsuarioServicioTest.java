package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.model.Usuario;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsuarioServicioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;
    @Test
    public void registrarUsuarioTest(){

        try {
            Usuario usuario=new Usuario();
            usuario.setNombre("Juan");
            usuario.setTelefono("3102165");
            usuario.setPassword("522982");
            usuario.setEmail("nidfni@gmail.com");
            UsuarioDTO usuarioDTO=new UsuarioDTO("Pepito 1", "pepe1@email.com",  "1234","Calle 123", "343","usuario");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
