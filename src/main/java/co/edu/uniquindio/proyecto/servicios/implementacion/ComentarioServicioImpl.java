package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.model.Comentario;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ComentarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ComentarioServicioImpl implements ComentarioServicio {

    private final ComentarioRepo comentarioRepo;

    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) throws Exception {
        Comentario comentario = new Comentario();

        comentario.setMensaje(comentarioDTO.getMensaje());
        comentario.setCodigoProducto(comentario.getCodigoProducto());
        comentario.setCodigoUsuario(comentarioDTO.getCodigoUsuario());

        return comentarioRepo.save(comentario).getCodigo();
    }

    @Override
    public List<ComentarioGetDTO> listarComentario(int codigoProducto) {

        List<Comentario> list = comentarioRepo.listarComentario(codigoProducto);
        List<ComentarioGetDTO> respuesta = new ArrayList<>();

        for (Comentario c : list){
            respuesta.add(convertir(c));
        }

        return respuesta;
    }

    private ComentarioGetDTO convertir(Comentario c) {
        ComentarioGetDTO comentarioGetDTO = new ComentarioGetDTO(
        c.getCodigo(), c.getFechaComentario(),c.getMensaje(),c.getCodigoProducto().getCodigo(),c.getCodigoUsuario().getCodigo());
        return comentarioGetDTO;
    }


}
