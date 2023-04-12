package co.edu.uniquindio.proyecto.servicios.interfaces;

public interface EmailServicio {

    String SendEmail(String contenido, String destinatario) throws Exception;
}
