package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.model.Categoria;

import co.edu.uniquindio.proyecto.model.Imagen;

import co.edu.uniquindio.proyecto.model.Estado;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
    @Column (nullable = false)
    private String nombre;
    @NotNull
    @Length(min=1,max = 300,message = "La descripción debe tener máximo 300 caracteres.")
    private String descripcion;

    @Column(nullable = false)
    @Positive
    private int unidades;

    @Positive
    @Column(nullable = false)
    private double precio;
    private int codigoVendedor;

    //Cómo parametrizo una lista ?
    private List<String> imagenes;
    private List<Categoria> categorias;

    private Estado estado;



}
