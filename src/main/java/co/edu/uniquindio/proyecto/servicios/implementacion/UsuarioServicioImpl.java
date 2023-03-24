package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.model.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

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

       Usuario usuario=new Usuario();
       usuario.setNombre(user.getNombre());
       usuario.setEmail(user.getCorreo());
       usuario.setTelefono(user.getTelefono());
       usuario.setDireccion(user.getDireccion());
       usuario.setPassword(user.getPass());

        usuarioRepo.save(usuario);

        return usuarioRepo.save(usuario).getCodigo();
    }

    @Override
    public int actualizarUsuario(int codigoUsuario, UsuarioDTO user) throws Exception{
        validarUsuario(codigoUsuario);
        Optional<Usuario> buscado = usuarioRepo.findBy(codigoUsuario);
        Usuario usuario = buscado.get(); //quiere decir que existe y lo asigna

        usuario.setNombre(user.getNombre());
        usuario.setEmail(user.getCorreo());
        usuario.setTelefono(user.getTelefono());
        usuario.setDireccion(user.getDireccion());
        usuario.setPassword(user.getPass());

        usuarioRepo.save(usuario);
        return 0;
    }

    @Override
    public int eliminarUsuario(int codigoUsuario) throws Exception{
        validarUsuario(codigoUsuario);
        usuarioRepo.deleteById(codigoUsuario);
        return codigoUsuario;
    }

    @Override
    public UsuarioDTO obtenerUsuario(int codigoUsuario) throws Exception {
        validarUsuario(codigoUsuario);
        Usuario usuario = usuarioRepo.findBy(codigoUsuario).get();
        return convertir(usuario);
    }

    private void validarUsuario(int codigoUsuario) throws Exception {
        Optional<Usuario> usuario = usuarioRepo.findBy(codigoUsuario); //Asegura que no exista el nullPointerException

        if (usuario.isEmpty()){
            throw new Exception("El usuario con el codigo "+codigoUsuario+" no existe");
        }

    }

    //Mejor para la BD
    private void validarUsuario2(int codigoUsuario) throws Exception {
        boolean existe = usuarioRepo.existsById(codigoUsuario); //Asegura que no exista el nullPointerException

        if (!existe){
            throw new Exception("El usuario con el codigo "+codigoUsuario+" no existe");
        }
    }

    private UsuarioDTO convertir(Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getNombre(),usuario.getEmail(),usuario.getTelefono(),usuario.getPassword(),usuario.getTelefono());

        return usuarioDTO;
    }
}
