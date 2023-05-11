package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.model.DetalleCompra;
import co.edu.uniquindio.proyecto.model.MedioPago;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDateTime;
import java.util.List;

public class DetalleCompraDTO {

   @PositiveOrZero
    private int unidades;

   @Positive
   @NotNull
   private double precio;

   private int codigoProducto;
}
