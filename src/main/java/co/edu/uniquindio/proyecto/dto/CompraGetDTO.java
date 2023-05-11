package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.model.MedioPago;

import java.time.LocalDateTime;
import java.util.List;

public class CompraGetDTO {

    private int codigo;
    private LocalDateTime fechaCompra;

    private double totalCompra;
    private int codigoDomicilio;
    private int codigoUsuario;
    private MedioPago metodoPago; //ENUM
    private List<DetalleCompraDTO> detalleCompraDTO;


}
