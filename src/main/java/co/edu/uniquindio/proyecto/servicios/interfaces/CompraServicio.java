package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.model.Compra;

import java.util.List;

public interface CompraServicio {

    int crearCompra(CompraDTO compraDTO);
//se debe guardar, además del cliente y el producto (o los productos), la fecha, el total de la compra y el método de pago.
    List<CompraGetDTO> listarCompras(int codigoUsuario); //listar compras dado el codigo del usuario
    CompraGetDTO obtenerCompra(int codigoCompra);


}
