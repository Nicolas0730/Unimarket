package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.model.Categoria;
import co.edu.uniquindio.proyecto.model.Estado;
import co.edu.uniquindio.proyecto.model.Imagen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

//Tiene mas información y se usa para recuperar de la BD
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

    private List<String> imagen;
    private List<Categoria> categoria;
     private LocalDateTime fechaLimite;

}

