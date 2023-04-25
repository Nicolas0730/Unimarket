package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.servicios.interfaces.EmailServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailServicioImpl implements EmailServicio {
    @Override
    public String enviarEmail(String asunto, String contenido, String destinatario) throws Exception {
        return null;
    }

    @Override
    public String emailCompra(String emailUsuarioVendedor, String emailUsuarioComprador, int codigoProducto) {
        return null;
    }
}
