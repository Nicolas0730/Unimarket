package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.model.Comentario;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComentarioSerivicoImpl implements ComentarioServicio {

    @Autowired
    private ComentarioRepo comentarioRepo; //La clase está sin métodos 21/03 11:21 pm

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) throws Exception {
        //Es necesario validar que el comentario no exista? de ser así debería crear en ComentarioRepo el método
        Comentario comentario= convertirComentario(comentarioDTO);
        return comentarioRepo.save(comentario).getCodigo();
    }

    /**
     * Método que convierte un ComentarioDTO a un Comentario
     * @param comentarioDTO
     * @return
     */
    private Comentario convertirComentario(ComentarioDTO comentarioDTO) throws Exception{

        Comentario comentario = new Comentario();

        comentario.setFechaComentario(LocalDateTime.now());
        comentario.setMensaje(comentarioDTO.getMensaje());
        comentario.setCodigoUsuario(usuarioServicio.obtener( comentarioDTO.getCodigoUsuario()) );
        comentario.setCodigoProducto(comentarioDTO.getCodigoProducto());

        return comentario;
    }

    @Override
    public List<ComentarioGetDTO> listarComentario(int codigoProducto) {
        return null;
    }
}
