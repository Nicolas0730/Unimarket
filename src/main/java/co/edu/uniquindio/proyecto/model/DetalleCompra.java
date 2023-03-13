package co.edu.uniquindio.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DetalleCompra {

    @Id
    private String codigo;

//    private Compra codigoCompra;
//    private Producto codigoProducto;
    private int unidades;
    private double precioProducto;
}
