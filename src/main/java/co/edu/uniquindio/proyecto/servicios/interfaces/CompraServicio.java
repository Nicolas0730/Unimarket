package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.model.Compra;

import java.util.List;

public interface CompraServicio {

    Compra obtenerCompra(Integer idCompra)throws Exception;

    int crearCompra(CompraDTO compraDTO);
    List<CompraGetDTO> listarCompras(int codigoUsuario);
    CompraGetDTO obtenerCompra(int codigoCompra);
}
