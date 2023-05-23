package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.dto.SesionDTO;
import co.edu.uniquindio.proyecto.dto.TokenDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.model.Usuario;
import co.edu.uniquindio.proyecto.servicios.interfaces.SesionServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional
public class UsuarioServicioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private SesionServicio sesionServicio;

    @Test
    public void crearUsuarioTest()
    {

        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO("Pepito 1", "pepe1@email.com", "1234", "Calle 123", "343");

            int codigo = usuarioServicio.crearUsuario(usuarioDTO);


        }catch (Exception e)
        {

            e.printStackTrace();
        }

    }

    @Test
    public void loginTest() throws Exception{

        UsuarioDTO usuarioDTO = new UsuarioDTO("Pepito 1", "pepe1@email.com", "1234", "Calle 123", "343");
        int codigo = usuarioServicio.crearUsuario(usuarioDTO);

        TokenDTO token = sesionServicio.login(new SesionDTO(
                "pepe1@email.com",
                "gahah"
        ));

        System.out.println(token.getToken());


    }


    }

