package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
//Está hecho para guardar i
@AllArgsConstructor
@Getter
@Setter
public class ProductoDTO {

    private String nombre;
    private String descripcion;
    private int unidades;
    private float precio;
    private int codigoVendedor;
    private List<String> imagenes;
    public List<Categoria> categorias;

}
