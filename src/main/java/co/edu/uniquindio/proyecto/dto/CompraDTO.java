package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.model.MedioPago;

import java.util.List;

public class CompraDTO {

    private int codigoUsuario;
    private MedioPago metodoPago; //ENUM

    private List<DetalleCompraDTO> detalleCompraDTO;
}
