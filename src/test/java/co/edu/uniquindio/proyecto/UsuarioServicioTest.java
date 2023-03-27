package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
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
            UsuarioDTO usuarioDTO = new UsuarioDTO(nombre:"AA", email:"fss@gfdfd", password:"0000000",)
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
