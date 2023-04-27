package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.model.Rol;
import co.edu.uniquindio.proyecto.model.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private final PasswordEncoder passwordEncoder;

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
        usuario.setUsuario(Rol.CLIENTE);
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

    //Funciona internamente pero no tiene que ver con la API //    @Transactional(readOnly = true)

    public Usuario obtener(int codigoUsuario) throws Exception{
        Optional<Usuario> usuario = usuarioRepo.findById(codigoUsuario); //Asegura que no exista el nullPointerException

        if (usuario.isEmpty()){
            throw new Exception("El usuario con el codigo "+codigoUsuario+" no existe");
        }
        return usuario.get();
    }

   // @Override
    public UsuarioGetDTO convertiraUsuario(int codigoUsuario) throws Exception {
        return null;
    }

  //  @Override
    public Usuario convertirUsuario(int codigoUsuario) throws Exception {
        return null;
    }

    //Funciona internamente pero no tiene que ver con la API
    private void validarExiste(int codigoUsuario) throws Exception {
        boolean existe = usuarioRepo.existsById(codigoUsuario);
        if (!existe)
            throw new Exception("El codigo no está asociado con el usuario "+codigoUsuario);
    }

    private UsuarioGetDTO convertiraUsuarioaDTO(Usuario usuario)throws Exception{

        UsuarioGetDTO usuarioDTO = new UsuarioGetDTO(
                usuario.getCodigo(),
                usuario.getNombre(),
                usuario.getCorreo(),
                usuario.getDireccion(),
                usuario.getTelefono());

        return usuarioDTO;
    }

    /**
     * Método que convierte un usuarioDTO en un usuario
     * @param usuarioDTO
     * @return
     */
    private Usuario convertiraUsuario(UsuarioDTO usuarioDTO)throws Exception{

        Usuario usuario = new Usuario();
        usuario.setNombre( usuarioDTO.getNombre() );
        usuario.setCorreo( usuarioDTO.getCorreo() );
        usuario.setDireccion( usuarioDTO.getDireccion() );
        usuario.setTelefono( usuarioDTO.getTelefono() );
        usuario.setPassword( usuarioDTO.getPass() );

        return usuario;
    }
    //Mejor para la BD
//    private void validarUsuario2(int codigoUsuario) throws Exception {
//        boolean existe = usuarioRepo.existsById(codigoUsuario); //Asegura que no exista el nullPointerException
//
//        if (!existe){
//            throw new Exception("El usuario con el codigo "+codigoUsuario+" no existe");
//        }
//    }
//    private UsuarioDTO convertir2(Usuario usuario){
//        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getNombre(),usuario.getEmail(),usuario.getTelefono(),usuario.getPassword(),usuario.getTelefono());
//
//        return usuarioDTO;
//    }

    /**
     * No se como arreglar este método 24/04/2023
     */
//    @Override
//    public int registrarCliente(UsuarioGetDTO usuarioGetDTO) throws Exception {
//        if(!estaDisponible(c.getEmail())){
//            throw new AttributeException("El correo "+c.getEmail()+" ya está en uso");
//        }
//        Usuario usuario = new Usuario();
//        usuario.setNombre( clienteDTO.getNombre() );
//        usuario.setEmail( clienteDTO.getEmail() );
//        usuario.setDireccion( clienteDTO.getDireccion() );
//        usuario.setTelefono( clienteDTO.getTelefono() );
//        usuario.setPassword( passwordEncoder.encode(clienteDTO.getPassword()) );
//        return clienteRepo.save( usuario ).getCodigo();
//    }

}
