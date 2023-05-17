package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.EmailDTO;

public interface EmailServicio {

    String enviarEmail(String asunto,String contenido, String destinatario) throws Exception;// envia el email para recuperar contrasea

    String emailCompra(String emailUsuarioVendedor, String emailUsuarioComprador, int codigoProducto);

    void enviarEmail(EmailDTO recuperacionPassword);
    //enviar un correo  (tanto al comprador como al vendedor) que muestre los detalles de la misma.tring
}
