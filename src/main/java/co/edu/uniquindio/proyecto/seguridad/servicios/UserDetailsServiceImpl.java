package co.edu.uniquindio.proyecto.seguridad.servicios;

import co.edu.uniquindio.proyecto.model.Administrador;
import co.edu.uniquindio.proyecto.model.Usuario;
import co.edu.uniquindio.proyecto.repositorios.AdministradorRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.seguridad.modelo.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepo clienteRepo;
    @Autowired
    private AdministradorRepo adminRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> cliente = clienteRepo.findByEmail(email);
        if(cliente.isEmpty()){
            Optional<Administrador> admin = adminRepo.findByEmail(email);
            if(admin.isEmpty())
                throw new UsernameNotFoundException("El usuario no existe");
            return UserDetailsImpl.build(admin.get());
        }else{
            return UserDetailsImpl.build(cliente.get());
        }
    }
}