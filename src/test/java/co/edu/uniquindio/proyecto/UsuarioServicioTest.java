package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.model.Usuario;
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

    @Test
    @Sql("classpath:dataset.sql")
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


    }

