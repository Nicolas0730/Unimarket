package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.EmailDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.model.Rol;
import co.edu.uniquindio.proyecto.model.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioRepo usuarioRepo;
    private EmailServicio emailServicio;
    private final PasswordEncoder passwordEncoder;

    @Override
    public int crearUsuario(UsuarioDTO usuarioDTO) throws Exception
    {

        Usuario buscado = usuarioRepo.buscarUsuario(usuarioDTO.getCorreo());

        if(buscado!=null)
        {
            throw new Exception("El correo "+usuarioDTO.getCorreo()+" ya está en uso");
        }

        Usuario usuario = convertir(usuarioDTO);
        return usuarioRepo.save( usuario ).getCodigo();
    }

    @Override
    public int actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO) throws Exception
    {

        Usuario buscado = usuarioRepo.buscarUsuario(usuarioDTO.getCorreo());

        if(buscado!=null)
        {
            throw new Exception("El correo "+usuarioDTO.getCorreo()+" ya está en uso");
        }

        validarExiste(codigoUsuario);

        Usuario usuario = convertir(usuarioDTO);
        usuario.setCodigo(codigoUsuario);

        return usuarioRepo.save(usuario).getCodigo();
    }

    @Override
    public int eliminiarUsuario(int codigoUsuario) throws Exception
    {
        validarExiste(codigoUsuario);
        usuarioRepo.deleteById(codigoUsuario);
        return codigoUsuario;
    }

    @Override
    public UsuarioGetDTO obtenerUsuario(int codigoUsuario) throws Exception
    {
        return convertir( obtener(codigoUsuario) );
    }

    public Usuario obtener(int codigoUsuario) throws Exception
    {
        Optional<Usuario> usuario = usuarioRepo.findById(codigoUsuario);

        if(usuario.isEmpty() )
        {

            throw new Exception("El código "+codigoUsuario+" no está asociado a ningún usuario");
        }

        return usuario.get();
    }



    @Override

    public boolean cambiarPassword(String correo, String passwordNueva ) throws Exception
    {

        Usuario usuario = usuarioRepo.findByCorreo(correo).orElse(null);

        if(usuario==null)
        {
            throw new Exception("El cliente no se encontro con el correo ingresado");
        }

        usuario.setPassword( passwordEncoder.encode(passwordNueva) );
        usuarioRepo.save(usuario);

        return true;
    }


    private void validarExiste(int codigoUsuario) throws Exception
    {
        boolean existe = usuarioRepo.existsById(codigoUsuario);

        if( !existe )
        {
            throw new Exception("El código "+codigoUsuario+" no está asociado a ningún usuario");
        }

    }

    private UsuarioGetDTO convertir(Usuario usuario)
    {

        UsuarioGetDTO usuarioDTO = new UsuarioGetDTO(
                usuario.getCodigo(),
                usuario.getNombre(),
                usuario.getCorreo(),
                usuario.getDireccion(),
                usuario.getTelefono());

        return usuarioDTO;
    }
    private Usuario convertir(UsuarioDTO usuarioDTO)
    {

        Usuario usuario = new Usuario();
        usuario.setNombre( usuarioDTO.getNombre() );
        usuario.setCorreo( usuarioDTO.getCorreo() );
        usuario.setDireccion( usuarioDTO.getDireccion() );
        usuario.setTelefono( usuarioDTO.getTelefono() );
        usuario.setPassword( passwordEncoder.encode( usuarioDTO.getPassword() ));

        return usuario;
    }

}
