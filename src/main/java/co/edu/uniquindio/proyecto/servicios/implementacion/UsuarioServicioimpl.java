package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.model.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServicioimpl implements UsuarioServicio {

    @Autowired
    private UsuarioRepo usuarioRepo;
    //        usuarioRepo.save(); //Guardar con un insert into
//        usuarioRepo.findBy(); //Select * from tabla WHERE id = :id
//        usuarioRepo.delete();//delete from
//        usuarioRepo.existsById(); ////Select * from tabla WHERE id = :id
//        usuarioRepo.findAll() //select * from [tabla]
    @Override
    public int crearUsuario(UsuarioDTO user) throws Exception {
        Usuario buscado = usuarioRepo.buscarUsuario(user.getCorreo());
        if (buscado!= null){
            throw new Exception("El correo "+user.getCorreo()+" ya existe!");
        }
        Usuario usuario= convertiraUsuario(user);
        return usuarioRepo.save(usuario).getCodigo();
    }

    @Override
    public int actualizarUsuario(int codigoUsuario, UsuarioDTO user) throws Exception{
//        validarUsuario(codigoUsuario);
//        Optional<Usuario> buscado = usuarioRepo.findBy(codigoUsuario);
//        Usuario usuario = buscado.get(); //quiere decir que existe y lo asigna

        validarExiste(codigoUsuario);

        Usuario usuario = convertiraUsuario(user);
        usuario.setCodigo(codigoUsuario);

        return usuarioRepo.save(usuario).getCodigo();
    }

    @Override
    public int eliminarUsuario(int codigoUsuario) throws Exception{
        validarExiste(codigoUsuario);
        usuarioRepo.deleteById(codigoUsuario);
        return codigoUsuario;
    }

    @Override
    public UsuarioGetDTO obtenerUsuario(int codigoUsuario) throws Exception {
        return convertiraUsuarioaDTO(obtener(codigoUsuario));
    }

    @Override
    public Usuario obtener(int codigoUsuario) throws Exception{
        Optional<Usuario> usuario = usuarioRepo.findById(codigoUsuario); //Asegura que no exista el nullPointerException

        if (usuario.isEmpty()){
            throw new Exception("El usuario con el codigo "+codigoUsuario+" no existe");
        }
        return usuario.get();
    }

    @Override
    public UsuarioGetDTO convertiraUsuario(int codigoUsuario) throws Exception {
        return null;
    }

    @Override
    public Usuario convertirUsuario(int codigoUsuario) throws Exception {
        return null;
    }

    private void validarExiste(int codigoUsuario) throws Exception {
        boolean existe = usuarioRepo.existsById(codigoUsuario);
        if (!existe)
            throw new Exception("El codigo no está asociado con el usuario "+codigoUsuario);
    }

    public UsuarioGetDTO convertiraUsuarioaDTO(Usuario usuario){

        UsuarioGetDTO usuarioDTO = new UsuarioGetDTO(
                usuario.getCodigo(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getDireccion(),
                usuario.getTelefono());

        return usuarioDTO;
    }

    /**
     * Método que convierte un usuarioDTO en un usuario
     * @param usuarioDTO
     * @return
     */
    private Usuario convertiraUsuario(UsuarioDTO usuarioDTO){

        Usuario usuario = new Usuario();
        usuario.setNombre( usuarioDTO.getNombre() );
        usuario.setEmail( usuarioDTO.getCorreo() );
        usuario.setDireccion( usuarioDTO.getDireccion() );
        usuario.setTelefono( usuarioDTO.getTelefono() );
        usuario.setPassword( usuarioDTO.getPass() );

        return usuario;
    }
}
