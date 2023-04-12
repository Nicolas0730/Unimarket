package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
public class UsuarioServicioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;
    @Test
    @Sql
    public void registrarUsuarioTest(){

        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO("usuario1","correousuario1@gmail.com","1","armenia","123","1");
            usuarioServicio.crearUsuario(usuarioDTO);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql
    public void eliminarUsuario(){
        try {
            usuarioServicio.eliminarUsuario(1);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
