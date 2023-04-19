package co.edu.uniquindio.proyecto.controladores;


import co.edu.uniquindio.proyecto.servicios.implementacion.EmailServicioImpl;
import co.edu.uniquindio.proyecto.servicios.interfaces.EmailServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
@AllArgsConstructor
public class EmailControlador {

    private final EmailServicio.emailServicio;
    String enviarEmail(String asunto,String contenido, String destinatario) throws Exception;// envia el email para recuperar contrasea

    String emailCompra(String emailUsuarioVendedor, String emailUsuarioComprador, int codigoProducto);
//para enviar kheva

}
