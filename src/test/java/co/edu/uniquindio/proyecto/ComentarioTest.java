package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
public class ComentarioTest {

    @Autowired
private ComentarioServicio comentarioServicio;
    @Test
    @Sql

    public void crearComentario(){
    try{
        ComentarioDTO comentarioDTO =new ComentarioDTO("El precio es exagerado para este producto" ,1 ,1);
        comentarioServicio.crearComentario(comentarioDTO);
    }
    catch (Exception e){
        e.printStackTrace();
    }
    }
}