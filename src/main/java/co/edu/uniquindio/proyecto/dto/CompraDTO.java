package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.model.MedioPago;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CompraDTO {

    private int codigoUsuario;

    private double totalCompra;

    private MedioPago metodoPago; //ENUM


}
