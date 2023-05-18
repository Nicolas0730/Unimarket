package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.model.DetalleCompra;
import co.edu.uniquindio.proyecto.model.MedioPago;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class CompraGetDTO {

    private int codigo;
    private LocalDateTime fechaCompra;

    private double totalCompra;
    private int codigoDomicilio;
    private int codigoUsuario;
    private MedioPago metodoPago; //ENUM
    private List<DetalleCompraDTO> detalleCompraDTO;


    public CompraGetDTO(int codigo, Date fechaCompra, double totalCompra, int codigo1, MedioPago medioPago, List<DetalleCompra> detalleCompras) {
    }
}
