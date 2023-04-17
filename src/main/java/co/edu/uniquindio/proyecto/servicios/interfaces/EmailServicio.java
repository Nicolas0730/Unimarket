package co.edu.uniquindio.proyecto.servicios.interfaces;

public interface EmailServicio {

    String enviarEmail(String asunto,String contenido, String destinatario) throws Exception;// envia el email para recuperar contrasea

    String emailCompra(String emailUsuarioVendedor, String emailUsuarioComprador, int codigoProducto);
    //enviar un correo  (tanto al comprador como al vendedor) que muestre los detalles de la misma.tring
}
