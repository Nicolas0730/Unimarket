package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.model.Compra;
import co.edu.uniquindio.proyecto.servicios.interfaces.CompraServicio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CompraServicioImpl implements CompraServicio {


    @Override
    public Compra obtenerCompra(Integer idCompra) throws Exception {
        return null;
    }

    @Override
    public int crearCompra(CompraDTO compraDTO) {
        return 0;
    }

    @Override
    public List<CompraGetDTO> listarCompras(int codigoUsuario) {
        return null;
    }

    @Override
    public CompraGetDTO obtenerCompra(int codigoCompra) {
        return null;
    }
}
