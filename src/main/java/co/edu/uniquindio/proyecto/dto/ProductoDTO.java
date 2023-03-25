package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.model.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;
//Está hecho para guardar i
@AllArgsConstructor
@Getter
@Setter
public class ProductoDTO {

    @NotNull
    @NotBlank
    @Length(max = 100)
    private String nombre;

    @NotNull
    @Length(min=1,max = 300,message = "La descripción debe tener máximo 300 caracteres.")
    private String descripcion;
    private int unidades;
    private float precio;
    private int codigoVendedor;

    //Cómo parametrizo una lista ?
    private List<String> imagenes;
    public List<Categoria> categorias;

}
