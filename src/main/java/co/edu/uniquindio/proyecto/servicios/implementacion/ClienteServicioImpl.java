package co.edu.uniquindio.proyecto.servicios.implementacion;

import org.springframework.security.crypto.password.PasswordEncoder;

import javax.print.AttributeException;

public class ClienteServicioImpl {

//    private final PasswordEncoder passwordEncoder;
//    @Override
//    public int registrarCliente(ClientePostDTO cliente) throws Exception {
//        Optional<Cliente> buscado = clienteRepo.findById(cliente.getCedula());
//        if(buscado.isPresent()){
//            throw new AttributeException("La cédula ya se encuentra en uso");
//        }
//        if(!estaDisponible(u.getEmail())){
//            throw new AttributeException("El email ya se encuentra en uso");
//        }
//        Cliente nuevo = clienteConverter.convertirPost(cliente);
//        nuevo.setPassword( passwordEncoder.encode(nuevo.getPassword()) );
//        Cliente registro = clienteRepo.save(nuevo);
//        return registro.getCodigo();
//    }
}
