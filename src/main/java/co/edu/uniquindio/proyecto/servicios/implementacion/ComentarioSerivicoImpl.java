package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.model.Comentario;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ComentarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioSerivicoImpl implements ComentarioServicio {

    @Autowired
    private ComentarioRepo comentarioRepo; //La clase está sin métodos 21/03 11:21 pm

    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) throws Exception {
        //Es necesario validar que el comentario no exista? de ser así debería crear en ComentarioRepo el método
        Comentario comentario= convertirUsuario(comentarioDTO);
        return comentarioRepo.save(comentario).getCodigo();
    }

    /**
     * Método que convierte un ComentarioDTO a un Comentario
     * @param comentarioDTO
     * @return
     */
    private Comentario convertirUsuario(ComentarioDTO comentarioDTO) {

        Comentario comentario = new Comentario();

        comentario.setMensaje(comentarioDTO.getMensaje());
        comentario.setCodigoUsuario(comentarioDTO.getCodigoUsuario());
        comentario.setCodigoProducto(comentarioDTO.getCodigoProducto());

        return comentario;
    }

    @Override
    public List<ComentarioGetDTO> listarComentario(int codigoProducto) {
        return null;
    }
}
