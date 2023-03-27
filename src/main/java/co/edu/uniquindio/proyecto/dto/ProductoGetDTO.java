package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.model.Categoria;
import co.edu.uniquindio.proyecto.model.Estado;
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

    private Estado activo;

    private LocalDateTime fechaPublicacion;
    //Estado
    private LocalDateTime fechaLimite;
    private String nombre;
    private String descripcion;
    private int unidades;
    private float precio;
    private int codigoVendedor;
    private List<String> imagenes;
    public List<Categoria> categorias;



}
