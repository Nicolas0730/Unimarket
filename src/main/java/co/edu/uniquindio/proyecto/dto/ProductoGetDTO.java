package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.model.Categoria;

import co.edu.uniquindio.proyecto.model.Imagen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductoGetDTO {

    private int codigo;

    private String nombre;

    private String descripcion;

    private int unidades;

    private double precio;

    private int codigoVendedor;


    private List<Imagen> imagenes;
    private List<Categoria> categorias;

     private LocalDateTime fechaLimite;



}
