package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.servicios.interfaces.CloudinaryServicio;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryServicioImpl implements CloudinaryServicio {
    @Override
    public Map subirImagen(File file, String carpeta) throws Exception {
        return null;
    }

    @Override
    public Map eliminarImagen(String idImagen) throws Exception {
        return null;
    }

    @Override
    public File convertir(MultipartFile imagen) throws IOException {
        return null;
    }
}
